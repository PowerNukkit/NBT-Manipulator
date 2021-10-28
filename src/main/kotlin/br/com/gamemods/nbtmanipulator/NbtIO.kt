@file:JvmName("_NbtIO_Internal")

package br.com.gamemods.nbtmanipulator

import java.io.*
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream
import kotlin.reflect.KClass
import kotlin.reflect.cast

/**
 * Contains useful methods do read and write [NbtFile] from [File] and [InputStream]/[OutputStream].
 */
public object NbtIO {
    /**
     * Calls [writeNbtFile] using the information stored in the [NbtFile], uses the method's default when the information
     * is missing (null).  This method does not write the Bedrock Edition version and length headers.
     * @param outputStream The stream that the file will be written
     * @param file The file that will be written to the stream
     */
    @JvmStatic
    @Throws(IOException::class)
    public fun writeNbtFileAsOriginal(outputStream: OutputStream, file: NbtFile) {
        writeNbtFile(outputStream, file, 
            compressed = file.isCompressed ?: true,
            littleEndian = file.isLittleEndian ?: false
        )
    }
    
    /**
     * Writes the [NbtFile] in the stream. This method does not write the Bedrock Edition version and length headers.
     * @param outputStream The stream that the file will be written
     * @param file The file that will be written to the stream
     * @param compressed If the file will be compressed by [GZIPOutputStream].
     * @param littleEndian Uses little endian to write to the stream as in Bedrock Edition
     */
    @JvmStatic
    @Throws(IOException::class)
    @JvmOverloads
    public fun writeNbtFile(outputStream: OutputStream, file: NbtFile, compressed: Boolean = true, littleEndian: Boolean = false) {
        val output = if (compressed) GZIPOutputStream(outputStream) else outputStream
        val dataOut: DataOutput = if (littleEndian) LittleEndianDataOutputStream(output) else DataOutputStream(output)
        writeNbtFileDirectly(dataOut, file)
        (dataOut as OutputStream).flush()
        if (output is GZIPOutputStream) {
            output.finish()
        }
    }

    /**
     * Writes the [NbtFile] to the output. This method does not write the Bedrock Edition version and length headers.
     * @param output Where the file will be written, needs to handle compression and endianness.
     * @param file The file that will be written to the output
     */
    @JvmStatic
    @Throws(IOException::class)
    public fun writeNbtFileDirectly(output: DataOutput, file: NbtFile) {
        val tag = file.tag
        val typeId = tag.typeId
        val serializer = serializers[typeId]
        output.writeByte(typeId)
        output.writeUTF(file.name)

        serializer.writeTag(output, tag)
    }

    /**
     * Writes the [NbtFile] in a [File].
     * @param file The output file
     * @param file The NBT file that will be written on the output file
     * @param compressed If the file will be compressed by [GZIPOutputStream]
     * @param littleEndian Uses little endian to write to the stream as in Bedrock Edition
     * @param writeHeaders Writes the [NbtFile.version] and content size headers to the file.
     * The [NbtFile.length] property will be updated when this flag is set to true.
     * If [NbtFile.version] is null when this flag is true, `0` is assumed.
     * The header is always written in little endian regardless of the [littleEndian] param.
     */
    @JvmStatic
    @Throws(IOException::class)
    @JvmOverloads
    public fun writeNbtFile(
        file: File, tag: NbtFile, compressed: Boolean = true, 
        littleEndian: Boolean = false, writeHeaders: Boolean = false
    ) {
        if (!writeHeaders) {
            file.outputStream().buffered().use { stream ->
                writeNbtFile(stream, tag, compressed, littleEndian)
                stream.flush()
            }
        } else {
            RandomAccessFile(file, "rw").use { openFile ->
                openFile.setLength(8)
                FileOutputStream(openFile.fd).buffered().let { stream ->
                    with(LittleEndianDataOutputStream(stream)) {
                        writeInt(tag.version ?: 0)
                        writeInt(0)
                        flush()
                    }
                    writeNbtFile(stream, tag, compressed, littleEndian)
                    stream.flush()
                }
                
                val fileLength = openFile.length() - 8L
                val intLength = if (fileLength > Int.MAX_VALUE) Int.MAX_VALUE else fileLength.toInt()
                tag.length = intLength
                
                openFile.seek(8)
                with(LittleEndianDataOutputStream(FileOutputStream(openFile.fd))) {
                    writeInt(intLength)
                    flush()
                }
            }
        }
    }

    /**
     * Read a [NbtFile] from the [InputStream].
     * @param inputStream The input stream that will be read
     * @param compressed If the file needs to be decompressed by [GZIPInputStream]
     * @param littleEndian Reads the NBT file using little endian byte order
     * @param readHeaders Reads the NBT version and length headers before the content
     * These data are read in little endian byte order regardless of the [littleEndian] parameter.
     */
    @JvmStatic
    @Throws(IOException::class)
    @JvmOverloads
    public fun readNbtFile(
        inputStream: InputStream, compressed: Boolean = true, 
        littleEndian: Boolean = false, readHeaders: Boolean = false
    ): NbtFile {
        var version: Int? = null
        var length: Int? = null

        if (readHeaders) {
            with(LittleEndianDataInputStream(inputStream)) {
                version = readInt()
                length = readInt()
            }
        }

        val input = if (compressed) GZIPInputStream(inputStream) else inputStream
        val dataIn: DataInput = if (littleEndian) LittleEndianDataInputStream(input) else DataInputStream(input)
        val nbtFile = readNbtFileDirectly(dataIn)
        nbtFile.version = version
        nbtFile.length = length
        nbtFile.isCompressed = compressed
        nbtFile.isLittleEndian = littleEndian
        return nbtFile
    }

    /**
     * Reads a [NbtFile] from the input. This method does not read the Bedrock Edition version and length headers.
     * @param input Where the file will be read, needs to handle compression and endianness.
     */
    @JvmStatic
    @Throws(IOException::class)
    public fun readNbtFileDirectly(input: DataInput): NbtFile {
        val typeId = input.readUnsignedByte()
        val serializer = serializers[typeId]

        val name = input.readUTF()

        return NbtFile(name, serializer.readTag(input))
    }

    /**
     * Read a [NbtFile] from a [File].
     * @param file The input file that will be read
     * @param compressed If the file needs to be decompressed by [GZIPInputStream]
     * @param littleEndian
     * @param readHeaders
     */
    @JvmStatic
    @Throws(IOException::class)
    @JvmOverloads
    public fun readNbtFile(
        file: File, compressed: Boolean = true,
        littleEndian: Boolean = false, 
        readHeaders: Boolean = false
    ): NbtFile {
        return file.inputStream().buffered().use { readNbtFile(it, compressed, littleEndian, readHeaders) }
    }

    
    /**
     * Does an exhaustive attempts to load the NBT file, returning it if any of the attempts is successful. 
     * @param file
     */
    @JvmStatic
    @Throws(IOException::class)
    public fun readNbtFileDetectingSettings(file: File): NbtFile {
        RandomAccessFile(file, "r").use { openFile ->
            var ex: IOException? = null
            fun retry(compressed: Boolean, littleEndian: Boolean, readHeaders: Boolean): NbtFile? {
                return try {
                    openFile.seek(0)
                    readNbtFile(FileInputStream(openFile.fd).buffered(), compressed, littleEndian, readHeaders)
                }  catch (e: IOException) {
                    val lastEx = ex
                    if (lastEx == null) {
                        ex = lastEx
                    } else {
                        lastEx.addSuppressed(e)
                    }
                    null
                }
            }
            return retry(compressed = true, littleEndian = false, readHeaders = false)  // Java's level.dat
                ?: retry(compressed = false, littleEndian = true, readHeaders = true)   // Bedrock's level.dat
                ?: retry(compressed = true, littleEndian = false, readHeaders = true)   // Trying all possibilities
                ?: retry(compressed = true, littleEndian = true, readHeaders = false)
                ?: retry(compressed = true, littleEndian = true, readHeaders = true)
                ?: retry(compressed = false, littleEndian = false, readHeaders = false)
                ?: retry(compressed = false, littleEndian = false, readHeaders = true)
                ?: retry(compressed = false, littleEndian = true, readHeaders = false)
                ?: retry(compressed = false, littleEndian = true, readHeaders = true)
                ?: throw IOException("Could not load the NbtFile $file with any settings", ex)
        }
    }

    /**
     * Writes the [NbtTag] directly, without name and optionally without type id.
     * @param output Where the file will be written, needs to handle compression and endianness.
     * @param tag The tag that will be written to the output
     * @param writeTypeId If the first byte written should be the NBT tag type id.
     */
    @JvmStatic
    @Throws(IOException::class)
    public fun writeNbtTagDirectly(output: DataOutput, tag: NbtTag, writeTypeId: Boolean = true) {
        val typeId = tag.typeId
        val serializer = serializers[typeId]
        output.takeIf { writeTypeId }?.writeByte(typeId)
        serializer.writeTag(output, tag)
    }

    /**
     * Reads a [NbtTag] of type [T] from the input directly, this is a reader for [writeNbtTagDirectly].
     * @param input Where the file will be read, needs to handle compression and endianness.
     * @param tagType The type of the tag that will be read, use `null` if the tag was written with `writeTypeId` enabled
     * @throws IllegalArgumentException If [T] is exactly [NbtTag].
     */
    @JvmStatic
    @Throws(IOException::class, IllegalArgumentException::class)
    public fun <T: NbtTag> readNbtTagDirectly(input: DataInput, tagType: Class<T>? = null): T {
        if (tagType == null) {
            val typeId = input.readByte().toInt()
            val serializer = serializers[typeId]

            @Suppress("UNCHECKED_CAST")
            return serializer.readTag(input) as T
        } else {
            return readNbtTagDirectly(input, tagType.kotlin)
        }
    }

    /**
     * Reads a [NbtTag] of type [T] from the input directly, this is a reader for [writeNbtTagDirectly].
     * @param input Where the file will be read, needs to handle compression and endianness.
     * @param tagType The type of the tag that will be read.
     * @throws IllegalArgumentException If [T] is exactly [NbtTag].
     */
    @PublishedApi
    @Throws(IOException::class, IllegalArgumentException::class)
    internal fun <T: NbtTag> readNbtTagDirectly(input: DataInput, tagType: KClass<T>): T {
        require(tagType != NbtTag::class) {
            "A final tag type is required. The NbtTag class is not a valid option for the tag type parameter."
        }
        val serializer = serializers.first { it.kClass == tagType }
        return tagType.cast(serializer.readTag(input))
    }

    /**
     * Reads a [NbtTag] of type [T] from the input directly, this is a reader for [writeNbtTagDirectly].
     * @param input Where the file will be read, needs to handle compression and endianness.
     * @param T The type of the tag that will be read.
     * @throws IllegalArgumentException If [T] is exactly [NbtTag].
     */
    @JvmStatic
    @Throws(IOException::class, IllegalArgumentException::class)
    public inline fun <reified T: NbtTag> readNbtTagDirectly(input: DataInput): T {
        return readNbtTagDirectly(input, T::class)
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///  PRIVATE AREA  //  PRIVATE AREA  //  PRIVATE AREA  //  PRIVATE AREA  //  PRIVATE AREA  //  PRIVATE AREA  ///
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    private val serializers = listOf(
        NbtEndSerial,
        NbtByteSerial,
        NbtShortSerial,
        NbtIntSerial,
        NbtLongSerial,
        NbtFloatSerial,
        NbtDoubleSerial,
        NbtByteArraySerial,
        NbtStringSerial,
        NbtListSerial,
        NbtCompoundSerial,
        NbtIntArraySerial,
        NbtLongArraySerial
    )

    private val NbtTag.typeId
        get() = serializers.indexOfFirst { it.kClass == this::class }

    private sealed class NbtSerial<T: NbtTag> (val kClass: KClass<T>){
        abstract fun readTag(input: DataInput): T
        abstract fun writeTag(output: DataOutput, tag: T)

        @Suppress("UNCHECKED_CAST")
        @JvmName("writeRawTag")
        fun writeTag(output: DataOutput, tag: NbtTag) {
            writeTag(output, tag as T)
        }
    }

    private object NbtEndSerial: NbtSerial<NbtEnd>(NbtEnd::class) {
        override fun readTag(input: DataInput): NbtEnd {
            return NbtEnd
        }

        override fun writeTag(output: DataOutput, tag: NbtEnd) {
        }
    }

    private object NbtByteSerial: NbtSerial<NbtByte>(NbtByte::class) {
        override fun readTag(input: DataInput): NbtByte {
            return NbtByte(input.readByte())
        }

        override fun writeTag(output: DataOutput, tag: NbtByte) {
            output.writeByte(tag.signed.toInt())
        }
    }

    private object NbtShortSerial: NbtSerial<NbtShort>(NbtShort::class) {
        override fun readTag(input: DataInput): NbtShort {
            return NbtShort(input.readShort())
        }

        override fun writeTag(output: DataOutput, tag: NbtShort) {
            output.writeShort(tag.value.toInt())
        }
    }

    private object NbtIntSerial: NbtSerial<NbtInt>(NbtInt::class) {
        override fun readTag(input: DataInput): NbtInt {
            return NbtInt(input.readInt())
        }

        override fun writeTag(output: DataOutput, tag: NbtInt) {
            output.writeInt(tag.value)
        }
    }

    private object NbtLongSerial: NbtSerial<NbtLong>(NbtLong::class) {
        override fun readTag(input: DataInput): NbtLong {
            return NbtLong(input.readLong())
        }

        override fun writeTag(output: DataOutput, tag: NbtLong) {
            output.writeLong(tag.value)
        }
    }

    private object NbtFloatSerial: NbtSerial<NbtFloat>(NbtFloat::class) {
        override fun readTag(input: DataInput): NbtFloat {
            return NbtFloat(input.readFloat())
        }

        override fun writeTag(output: DataOutput, tag: NbtFloat) {
            output.writeFloat(tag.value)
        }
    }

    private object NbtDoubleSerial: NbtSerial<NbtDouble>(NbtDouble::class) {
        override fun readTag(input: DataInput): NbtDouble {
            return NbtDouble(input.readDouble())
        }

        override fun writeTag(output: DataOutput, tag: NbtDouble) {
            output.writeDouble(tag.value)
        }
    }

    private object NbtByteArraySerial: NbtSerial<NbtByteArray>(NbtByteArray::class) {
        override fun readTag(input: DataInput): NbtByteArray {
            val size = input.readInt()
            val bytes = ByteArray(size)
            input.readFully(bytes)
            return NbtByteArray(bytes)
        }

        override fun writeTag(output: DataOutput, tag: NbtByteArray) {
            output.writeInt(tag.value.size)
            output.write(tag.value)
        }
    }

    private object NbtStringSerial: NbtSerial<NbtString>(NbtString::class) {
        override fun readTag(input: DataInput): NbtString {
            return NbtString(input.readUTF())
        }

        override fun writeTag(output: DataOutput, tag: NbtString) {
            output.writeUTF(tag.value)
        }
    }

    private object NbtListSerial: NbtSerial<NbtList<*>>(NbtList::class) {
        override fun readTag(input: DataInput): NbtList<*> {
            val type = input.readUnsignedByte()
            val size = input.readInt()
            if (type == 0 && size > 0) {
                error("Missing type on NbtList")
            }
            val serializer = serializers[type]
            val list = mutableListOf<NbtTag>()
            for (i in 1..size) {
                list += serializer.readTag(input)
            }
            return NbtList(list)
        }

        override fun writeTag(output: DataOutput, tag: NbtList<*>) {
            val sample = tag.firstOrNull() ?: NbtEnd
            val typeId = sample.typeId
            val serializer = serializers[typeId]

            if (typeId == 0 && tag.size > 0) {
                error("NbtList cannot have NbtEnd")
            }

            output.writeByte(typeId)
            output.writeInt(tag.size)
            tag.forEach {
                serializer.writeTag(output, it)
            }
        }
    }

    private object NbtCompoundSerial: NbtSerial<NbtCompound>(NbtCompound::class) {
        override fun readTag(input: DataInput): NbtCompound {
            val map = mutableMapOf<String, NbtTag>()
            while (true) {
                val typeId = input.readUnsignedByte()
                if (typeId == 0) {
                    break
                }

                val name = input.readUTF()
                val serializer = serializers[typeId]
                val childTag = serializer.readTag(input)
                map[name] = childTag
            }
            return NbtCompound(map)
        }

        override fun writeTag(output: DataOutput, tag: NbtCompound) {
            check(tag.values.none { it == NbtEnd }) {
                "NbtCompound cannot have an NbtEnd"
            }

            tag.forEach { (name, childTag) ->
                val typeId = childTag.typeId
                val serializer = serializers[typeId]
                output.writeByte(typeId)
                output.writeUTF(name)
                serializer.writeTag(output, childTag)
            }

            output.writeByte(0)
        }
    }

    private object NbtIntArraySerial: NbtSerial<NbtIntArray>(NbtIntArray::class) {
        override fun readTag(input: DataInput): NbtIntArray {
            val size = input.readInt()
            val array = IntArray(size)
            for (i in 0 until size) {
                array[i] = input.readInt()
            }
            return NbtIntArray(array)
        }

        override fun writeTag(output: DataOutput, tag: NbtIntArray) {
            output.writeInt(tag.value.size)
            tag.value.forEach {
                output.writeInt(it)
            }
        }
    }

    private object NbtLongArraySerial: NbtSerial<NbtLongArray>(NbtLongArray::class) {
        override fun readTag(input: DataInput): NbtLongArray {
            val size = input.readInt()
            val array = LongArray(size)
            for (i in 0 until size) {
                array[i] = input.readLong()
            }
            return NbtLongArray(array)
        }

        override fun writeTag(output: DataOutput, tag: NbtLongArray) {
            output.writeInt(tag.value.size)
            tag.value.forEach {
                output.writeLong(it)
            }
        }
    }
}
