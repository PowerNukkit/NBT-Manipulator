@file:Suppress("unused")

package br.com.gamemods.nbtmanipulator

/**
 * The root component of a file, it contains a hint for the file name and the first tag in the file.
 * @property name The key for the file name. Empty in most cases.
 * @property tag The first tag in the file. A [NbtCompound] in most cases.
 * @property compound A shortcut to read or write [NbtFile.tag] as a [NbtCompound].
 * @property version The version of the data stored in this file.
 * @property length The length of the file which is cached in the file's header.
 * @property isCompressed If the file needed to be uncompressed to load.
 * @property isLittleEndian If the file's byte order is little endian instead of big endian.
 * Will throw a [ClassCastException] if the tag value is not a [NbtCompound]
 */
public data class NbtFile @JvmOverloads constructor(
    var name: String, 
    var tag: NbtTag,
    var version: Int? = null,
    var length: Int? = null,
    var isCompressed: Boolean? = null,
    var isLittleEndian: Boolean? = null
) {
    @Suppress("MemberVisibilityCanBePrivate")
    public var compound: NbtCompound
        @Throws(ClassCastException::class)
        get() = tag as NbtCompound
        set(value) {
            tag = value
        }
}

/**
 * The base class for Nbt Tags. All tag values are mutable.
 *
 * Do not create new classes extending it.
 */
public sealed class NbtTag {
    /**
     * Returns a string representation of the tag's value.
     *
     * The [NbtList] and the array types will have an output similar to a normal [List] and [NbtCompound] to a normal [Map].
     *
     * The class names of the [NbtList]'s and [NbtCompound]'s children will expose.
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    public abstract val stringValue: String

    /**
     * Copies all this and all nested NbtTags into new objects.
     */
    public abstract fun deepCopy(): NbtTag

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
     * appropriated for developer inspections.
     *
     * The [NbtList] and the array types will have an output similar to a normal [List] and [NbtCompound] to a normal [Map].
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    protected open fun toTechnicalString(): String = "${this::class.java.simpleName}($stringValue)"

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
     * appropriated for developer inspections.
     *
     * The [NbtList] and the array types will have an output similar to a normal [List] and [NbtCompound] to a normal [Map].
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    final override fun toString(): String = toTechnicalString()
}

/**
 * A special tag which indicates the end of a compound stream or empty lists.
 *
 * Should not be used directly.
 */
public object NbtEnd : NbtTag() {
    /**
     * Returns an empty string.
     */
    override val stringValue: String
        get() = ""

    /**
     * Returns `"NbtEnd"`.
     */
    override fun toTechnicalString(): String {
        return "NbtEnd"
    }

    /**
     * Returns itself.
     */
    override fun deepCopy(): NbtEnd = NbtEnd
}

/**
 * A tag which wraps a byte value.
 * @property signed A signed byte from `-128` to `127`
 */
public data class NbtByte(var signed: Byte) : NbtTag() {
    /**
     * Read or write the [signed] as a signed byte from `0` to `255`.
     */
    var unsigned: Int
        get() = signed.toInt() and 0xFF
        set(value) {
            this.signed = (value and 0xFF).toByte()
        }

    /**
     * A signed byte from `-128` to `127`.
     */
    @Deprecated(
        "Deprecated in favor of signed and unsigned flavours. Replace with the signed property.",
        ReplaceWith("signed")
    )
    inline var value: Byte
        get() = signed
        set(value) {
            signed = value
        }

    /**
     * Returns a string representation of the tag's signed value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = signed.toString()

    /**
     * Wraps a byte `1` if the value is `true` and `0` otherwise.
     * @param value The value to be checked
     */
    public constructor(value: Boolean): this(if (value) BYTE_TRUE else 0)

    /**
     * Converts the int value to an unsigned byte and wraps it.
     * @param unsigned Unsigned value from `0` to `255`.
     * @throws NumberFormatException if the number is not within the 0..255 range
     */
    @Throws(NumberFormatException::class)
    public constructor(unsigned: Int): this(unsigned.let {
        if(it < 0 || it > 255) {
            throw NumberFormatException("Expected an unsigned byte of range 0 to 255. Got $it.")
        }
        it.toByte()
    })

    /**
     * Parses the string value as a signed byte and wraps it.
     * @param signed Signed value from `-128` to `127`.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toByte())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtByte = copy()

    /**
     * A technical string representation of this tag, containing the tag type, and it's [signed] value,
     * appropriated for developer inspections.
     */
    override fun toTechnicalString(): String {
        return "NbtByte($signed)"
    }

    public companion object {
        /**
         * Parses the string value as an unsigned byte and wraps it.
         * @param unsigned Unsigned value from `0` to `255`.
         * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
         */
        @JvmStatic
        public fun unsigned(unsigned: String): NbtByte = NbtByte(unsigned = unsigned.toInt())
    }
}

/**
 * A tag which wraps a short value.
 * @property value The wrapped value
 */
public data class NbtShort(var value: Short) : NbtTag() {
    /**
     * Returns a string representation of the tag's value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = value.toString()

    /**
     * Parses the string value as a signed short and wraps it.
     * @param signed Signed value from `-32768` to `32767`.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toShort())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtShort = copy()
}

/**
 * A tag which wraps an int value.
 * @property value The wrapped value
 */
public data class NbtInt(var value: Int) : NbtTag() {
    /**
     * Returns a string representation of the tag's value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = value.toString()

    /**
     * Parses the string value as a signed int and wraps it.
     * @param signed Signed value from `-2147483648` to `2147483647`.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toInt())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtInt = copy()
}

/**
 * A tag which wraps a long value.
 * @property value The wrapped value
 */
public data class NbtLong(var value: Long) : NbtTag() {
    /**
     * Returns a string representation of the tag's value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = value.toString()

    /**
     * Parses the string value as a signed long and wraps it.
     * @param signed Signed value from `-9223372036854775808` to `9223372036854775807`.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toLong())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtLong = copy()
}

/**
 * A tag which wraps a float value.
 * @property value The wrapped value
 */
public data class NbtFloat(var value: Float) : NbtTag() {
    /**
     * Returns a string representation of the tag's value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = value.toString()

    /**
     * Parses the string value as a signed float and wraps it.
     * @param signed Signed value from `1.4e-45` to `3.4028235e+38`. NaN and Infinity are also accepted.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toFloat())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtFloat = copy()
}

/**
 * A tag which wraps a double value.
 * @property value The wrapped value
 */
public data class NbtDouble(var value: Double) : NbtTag() {
    /**
     * Returns a string representation of the tag's value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = value.toString()

    /**
     * Parses the string value as a signed double and wraps it.
     * @param signed Signed value from `4.9e-324` to `1.7976931348623157e+308`. NaN and Infinity are also accepted.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toDouble())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtDouble = copy()
}

/**
 * A tag which wraps a mutable byte array.
 * @property value The wrapped value
 */
public data class NbtByteArray(var value: ByteArray): NbtTag() {
    /**
     * Returns a string representation of the tag's value with a structure similar to a normal [List].
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Like [NbtByte], the bytes returned are signed, ranging from `-128` to `127`.
     *
     * Be aware that this may be a slow operation on big arrays.
     */
    override val stringValue: String
        get() = value.takeIf { it.isNotEmpty() }?.joinToString(prefix = "[", postfix = "]") ?: "[]"

    /**
     * Creates a new tag with an empty array.
     */
    public constructor(): this(byteArrayOf())

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * The bytes should be signed, ranging from `-127` to `127`.
     *
     * @param value A string with a structure like `[0, -32, 48, 127]`
     *
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    public constructor(value: String): this(value
        .removeSurrounding("[", "]")
        .split(", ")
        .takeIf { it.size > 1 || it.firstOrNull()?.isNotEmpty() == true }
        ?.map { it.toByte() }
        ?.toByteArray()
        ?: byteArrayOf()
    )

    override fun toTechnicalString(): String {
        return "NbtByteArray$stringValue"
    }

    /**
     * Properly checks the equality of the array.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NbtByteArray

        if (!value.contentEquals(other.value)) return false

        return true
    }

    /**
     * Properly calculates the hashcode of the array.
     */
    override fun hashCode(): Int {
        return value.contentHashCode()
    }

    /**
     * Returns a new wrapper with a copy of the current value.
     */
    override fun deepCopy(): NbtByteArray = copy(value = value.copyOf())
}

/**
 * A tag which wraps a [String] value.
 * @property value The wrapped value
 */
public data class NbtString(var value: String): NbtTag() {
    /**
     * Returns a string which is wrapped by this tag.
     */
    override val stringValue: String
        get() = value

    override fun toTechnicalString(): String {
        return buildString {
            append("NbtString(\"")
            append(
                value.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
            )
            append("\")")
        }
    }

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtString = copy()
}

/**
 * A tag which contains a [MutableList] structure of [NbtTag]s. All children must have the same class.
 *
 * @param T The type of the tag that will be wrapped. [NbtEnd] and [NbtTag] are not valid.
 */
@Suppress("UNCHECKED_CAST")
public class NbtList<T: NbtTag> private constructor(private val tags: ArrayList<T>): NbtTag(), MutableList<T> by tags, RandomAccess {
    /**
     * Returns a string representation of the tag's value.
     *
     * The output will be similar to a normal [List].
     *
     * The class names of the children tags will expose.
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    override val stringValue: String
        get() = tags.toString()

    /**
     * Constructs a [NbtList] with the same contents of the given [Collection].
     *
     * All items in the list must have the same class.
     *
     * Null values in the list are not allowed.
     *
     * The tags in the list will be linked so any modification will also change this tag contents.
     */
    public constructor(tags: Collection<T>): this(ArrayList(tags))

    /**
     * Creates an empty list.
     */
    public constructor(): this(emptyList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    public constructor(vararg tags: T): this(tags.toList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    public constructor(tags: Iterable<T>): this(tags.toList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    public constructor(tags: Sequence<T>): this(tags.toList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    public constructor(tags: NbtList<T>): this(tags as Collection<T>)

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * @param value A string with a structure like `[NbtInt(0), NbtInt(-32), NbtInt(48), NbtInt(127)]`
     *
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    public constructor(value: String): this(NbtListStringParser(value).parseList() as ArrayList<T>)

    override fun add(element: T): Boolean {
        checkTagType(element)
        return tags.add(element)
    }

    override fun add(index: Int, element: T) {
        checkTagType(element)
        return tags.add(index, element)
    }

    override fun set(index: Int, element: T): T {
        if (size > 1) {
            checkTagType(element)
        }
        return tags.set(index, element)
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        val subList = tags.subList(fromIndex, toIndex)
        return object : MutableList<T> by subList, RandomAccess {
            override fun set(index: Int, element: T): T {
                checkTagType(element)
                return subList.set(index, element)
            }

            override fun toString(): String {
                return tags.toString()
            }

            override fun equals(other: Any?): Boolean {
                return subList == other
            }

            override fun hashCode(): Int {
                return subList.hashCode()
            }
        }
    }

    private fun checkTagType(tag: NbtTag) {
        val childrenType = firstOrNull()?.javaClass ?: return
        require(childrenType == tag.javaClass) {
            "NbtList must have all children tags of the same type. \n" +
                    "Tried to add a ${tag.javaClass.simpleName} tag in a NbtList of ${childrenType.javaClass.simpleName}"
        }
    }

    /**
     * Returns a new NbtList with all nested values copied deeply.
     */
    override fun deepCopy(): NbtList<T> = NbtList(map { it.deepCopy() as T })

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
     * appropriated for developer inspections.
     *
     * The output will be similar to a normal [List].
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    override fun toTechnicalString(): String {
        if (tags.isEmpty()) {
            return "NbtList[]"
        }
        return tags.joinToString(prefix = "NbtList[", postfix = "]")
    }

    override fun equals(other: Any?): Boolean {
        return tags == other
    }

    override fun hashCode(): Int {
        return tags.hashCode()
    }


    /**
     * Contains useful methods to create [NbtList]s from Java.
     *
     * Kotlin's users may call `list(1,2,3).toNbtList()` or similar methods.
     */
    public companion object {
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Byte): NbtList<NbtByte> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Short): NbtList<NbtShort> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Int): NbtList<NbtInt> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Long): NbtList<NbtLong> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Float): NbtList<NbtFloat> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Double): NbtList<NbtDouble> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: String): NbtList<NbtString> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: ByteArray): NbtList<NbtByteArray> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: IntArray): NbtList<NbtIntArray> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: LongArray): NbtList<NbtLongArray> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Map<String, NbtTag>): NbtList<NbtCompound> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Iterable<NbtTag>): NbtList<NbtList<NbtTag>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createByteSublist(vararg tags: Iterable<Byte>): NbtList<NbtList<NbtByte>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createByteSublist(vararg tags: Array<Byte>): NbtList<NbtList<NbtByte>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createByteSublist(vararg tags: ByteArray): NbtList<NbtList<NbtByte>> = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createShortSublist(vararg tags: Iterable<Short>): NbtList<NbtList<NbtShort>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createShortSublist(vararg tags: Array<Short>): NbtList<NbtList<NbtShort>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createShortSublist(vararg tags: ShortArray): NbtList<NbtList<NbtShort>> = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createIntSublist(vararg tags: Iterable<Int>): NbtList<NbtList<NbtInt>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createIntSublist(vararg tags: Array<Int>): NbtList<NbtList<NbtInt>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createIntSublist(vararg tags: IntArray): NbtList<NbtList<NbtInt>> = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createFloatSublist(vararg tags: Iterable<Float>): NbtList<NbtList<NbtFloat>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createFloatSublist(vararg tags: Array<Float>): NbtList<NbtList<NbtFloat>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createFloatSublist(vararg tags: FloatArray): NbtList<NbtList<NbtFloat>> = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createDoubleSublist(vararg tags: Iterable<Double>): NbtList<NbtList<NbtDouble>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createDoubleSublist(vararg tags: Array<Double>): NbtList<NbtList<NbtDouble>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createDoubleSublist(vararg tags: DoubleArray): NbtList<NbtList<NbtDouble>> = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createStringSublist(vararg tags: Iterable<String>): NbtList<NbtList<NbtString>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createStringSublist(vararg tags: Array<String>): NbtList<NbtList<NbtString>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createCompoundSublist(vararg tags: Iterable<Map<String, NbtTag>>): NbtList<NbtList<NbtCompound>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createCompoundSublist(vararg tags: Array<Map<String, NbtTag>>): NbtList<NbtList<NbtCompound>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createSublist(vararg tags: Iterable<Iterable<NbtTag>>): NbtList<NbtList<NbtList<NbtTag>>> = tags.toNbtList()
    }
}

/**
 * A tag which contains a [MutableMap] structure associating [String]s to [NbtTag]s.
 *
 * It's the main heart of NBT files and usually contains complex structures.
 *
 * The returned tags by this class will be linked, so modifications to it will also affect the compound value.
 * 
 * All get functions which are not prefixed with `Nullable` and `get` will throw a [ClassCastException]
 * if the tag is mapped to a different class then the method used. For example if a given compound
 * have an example=NbtInt(2) and you try to read it using [NbtCompound.getShort], an exception will be thrown.
 *
 * All get functions which are not prefixed with `Nullable` and `get` will throw [NoSuchElementException]
 * if no value is mapped to the given name. This will change in the future.
 *
 * All get list functions which returns lists of specific types will throw [IllegalStateException] if the list content
 * does not match the requested type.
 *
 * @param value A [Map] which contains all key-value mappings.
 */
public class NbtCompound private constructor(private val value: LinkedHashMap<String, NbtTag>) : NbtTag(), MutableMap<String, NbtTag> by value {
    /**
     * Returns a string representation of the tag's value.
     *
     * The output will be similar to a normal [Map].
     *
     * The class names of the children will expose.
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on compounds.
     */
    override val stringValue: String
        get() = value.takeIf { it.isNotEmpty() }?.entries?.joinToString(prefix = "{", postfix = "}") { (key, tag) ->
            '"' + key.replace("\\", "\\\\").replace("\"", "\\\"") + "\"=" + tag
        } ?: "{}"

    /**
     * Creates a new compound containing the same mappings as the given [Map].
     *
     * The tags in the map will be linked so any modification will also change this tag contents.
     */
    public constructor(value: Map<String, NbtTag>): this(LinkedHashMap(value))

    /**
     * Creates an empty compound.
     */
    public constructor(): this(emptyMap())

    /**
     * Creates a compound which maps the [Pair.first] value to the [Pair.second] tag initially.
     *
     * The given tags will be linked, so modifications to them will also affect the compound value.
     */
    public constructor(vararg tags: Pair<String, NbtTag>): this(mapOf(*tags))

    /**
     * Creates a compound which maps the [Pair.first] value to the [Pair.second] tag initially.
     *
     * The given tags will be linked, so modifications to them will also affect the compound value.
     */
    public constructor(tags: Iterable<Pair<String, NbtTag>>): this(tags.toMap())

    /**
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    public constructor(value: String): this(NbtCompoundStringParser(value).parseCompound())

    /**
     * Directly maps a [NbtTag] to a key. The value must not be [NbtEnd].
     * The given tag will be linked, so modifications to it will also affect the compound value.
     */
    public operator fun set(key: String, value: NbtTag) {
        put(key, value)
    }

    /**
     * Maps a [NbtByte] `1` if the value is `true` and `0` otherwise.
     */
    public operator fun set(key: String, value: Boolean): Unit = set(key, if (value) BYTE_TRUE else 0)
    /**
     * Maps a [NbtByte] with the given value.
     */
    public operator fun set(key: String, value: Byte): Unit = set(key, NbtByte(value))
    /**
     * Maps a [NbtShort] with the given value.
     */
    public operator fun set(key: String, value: Short): Unit = set(key, NbtShort(value))
    /**
     * Maps a [NbtInt] with the given value.
     */
    public operator fun set(key: String, value: Int): Unit = set(key, NbtInt(value))
    /**
     * Maps a [NbtLong] with the given value.
     */
    public operator fun set(key: String, value: Long): Unit = set(key, NbtLong(value))
    /**
     * Maps a [NbtFloat] with the given value.
     */
    public operator fun set(key: String, value: Float): Unit = set(key, NbtFloat(value))
    /**
     * Maps a [NbtDouble] with the given value.
     */
    public operator fun set(key: String, value: Double): Unit = set(key, NbtDouble(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    public operator fun set(key: String, value: ByteArray): Unit = set(key, NbtByteArray(value))
    /**
     * Maps a [NbtDouble] with the given value.
     */
    public operator fun set(key: String, value: String): Unit = set(key, NbtString(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    public operator fun set(key: String, value: IntArray): Unit = set(key, NbtIntArray(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    public operator fun set(key: String, value: LongArray): Unit = set(key, NbtLongArray(value))

    /**
     * Returns `true` if [getByte] returns `1`, `false` otherwise.
     * Will also return `false` if the value is not mapped.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     */
    @Throws(ClassCastException::class)
    public fun getNullableBooleanByte(key: String): Boolean = getNullableByte(key) == BYTE_TRUE
    /**
     * Returns `true` if [getByte] returns `1`, `false` otherwise.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getBooleanByte(key: String): Boolean = getByte(key) == BYTE_TRUE

    /**
     * Returns the value corresponding to the given [key], or throw an exception if such a key is not present in the compound.
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(NoSuchElementException::class)
    public fun require(key: String): NbtTag = get(key) ?: throw NoSuchElementException(key)
    
    /**
     * Returns the unwrapped byte value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getByte(key: String): Byte = (require(key) as NbtByte).signed
    /**
     * Returns the unwrapped short value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtShort]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getShort(key: String): Short = (require(key) as NbtShort).value
    /**
     * Returns the unwrapped int value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtInt]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getInt(key: String): Int = (require(key) as NbtInt).value
    /**
     * Returns the unwrapped long value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getLong(key: String): Long = (require(key) as NbtLong).value
    /**
     * Returns the unwrapped float value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtFloat]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getFloat(key: String): Float = (require(key) as NbtFloat).value
    /**
     * Returns the unwrapped double value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtDouble]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getDouble(key: String): Double = (require(key) as NbtDouble).value
    /**
     * Returns the unwrapped byte array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByteArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getByteArray(key: String): ByteArray = (require(key) as NbtByteArray).value
    /**
     * Returns the unwrapped string value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtString]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getString(key: String): String = (require(key) as NbtString).value
    /**
     * Returns the unwrapped int array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtIntArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getIntArray(key: String): IntArray = (require(key) as NbtIntArray).value
    /**
     * Returns the unwrapped long array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getLongArray(key: String): LongArray = (require(key) as NbtLongArray).value
    /**
     * Returns the [NbtCompound] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtCompound]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getCompound(key: String): NbtCompound = require(key) as NbtCompound
    /**
     * Returns the [NbtList] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getList(key: String): NbtList<*> = require(key) as NbtList<*>

    /**
     * Returns the [NbtList] of bytes mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByte]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getByteList(key: String): NbtList<NbtByte> = getList(key).cast()
    /**
     * Returns the [NbtList] of shorts mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtShort]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getShortList(key: String): NbtList<NbtShort> = getList(key).cast()
    /**
     * Returns the [NbtList] of integers mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getIntList(key: String): NbtList<NbtInt> = getList(key).cast()
    /**
     * Returns the [NbtList] of longs mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLong]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getLongList(key: String): NbtList<NbtLong> = getList(key).cast()
    /**
     * Returns the [NbtList] of floats mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtFloat]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getFloatList(key: String): NbtList<NbtFloat> = getList(key).cast()
    /**
     * Returns the [NbtList] of doubles mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtDouble]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getDoubleList(key: String): NbtList<NbtDouble> = getList(key).cast()
    /**
     * Returns the [NbtList] of byte arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByteArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getByteArrayList(key: String): NbtList<NbtByteArray> = getList(key).cast()
    /**
     * Returns the [NbtList] of strings mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtString]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getStringList(key: String): NbtList<NbtString> = getList(key).cast()
    /**
     * Returns the [NbtList] of int arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getIntArrayList(key: String): NbtList<NbtIntArray> = getList(key).cast()
    /**
     * Returns the [NbtList] of long arrays mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLongArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getLongArrayList(key: String): NbtList<NbtLongArray> = getList(key).cast()
    /**
     * Returns the [NbtList] of compounds mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtCompound]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getCompoundList(key: String): NbtList<NbtCompound> = getList(key).cast()
    /**
     * Returns the [NbtList] of lists mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtList]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getListOfList(key: String): NbtList<NbtList<*>> = getList(key).cast()

    /**
     * Returns the unwrapped byte value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     */
    @Throws(ClassCastException::class)
    public fun getNullableByte(key: String): Byte? = this[key]?.let { it as NbtByte }?.signed
    /**
     * Returns the unwrapped short value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtShort]
     */
    @Throws(ClassCastException::class)
    public fun getNullableShort(key: String): Short? = this[key]?.let { it as NbtShort }?.value
    /**
     * Returns the unwrapped int value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtInt]
     */
    @Throws(ClassCastException::class)
    public fun getNullableInt(key: String): Int? = this[key]?.let { it as NbtInt }?.value
    /**
     * Returns the unwrapped long value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLong]
     */
    @Throws(ClassCastException::class)
    public fun getNullableLong(key: String): Long? = this[key]?.let { it as NbtLong }?.value
    /**
     * Returns the unwrapped float value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtFloat]
     */
    @Throws(ClassCastException::class)
    public fun getNullableFloat(key: String): Float? = this[key]?.let { it as NbtFloat }?.value
    /**
     * Returns the unwrapped double value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtDouble]
     */
    @Throws(ClassCastException::class)
    public fun getNullableDouble(key: String): Double? = this[key]?.let { it as NbtDouble }?.value
    /**
     * Returns the unwrapped byte array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByteArray]
     */
    @Throws(ClassCastException::class)
    public fun getNullableByteArray(key: String): ByteArray? = this[key]?.let { it as NbtByteArray }?.value
    /**
     * Returns the unwrapped string value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtString]
     */
    @Throws(ClassCastException::class)
    public fun getNullableString(key: String): String? = this[key]?.let { it as NbtString }?.value
    /**
     * Returns the unwrapped int array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtIntArray]
     */
    @Throws(ClassCastException::class)
    public fun getNullableIntArray(key: String): IntArray? = this[key]?.let { it as NbtIntArray }?.value
    /**
     * Returns the unwrapped long array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     */
    @Throws(ClassCastException::class)
    public fun getNullableLongArray(key: String): LongArray? = this[key]?.let { it as NbtLongArray }?.value
    /**
     * Returns the [NbtCompound] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtCompound]
     */
    @Throws(ClassCastException::class)
    public fun getNullableCompound(key: String): NbtCompound? = this[key]?.let { it as NbtCompound }
    /**
     * Returns the [NbtList] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     */
    @Throws(ClassCastException::class)
    public fun getNullableList(key: String): NbtList<*>? = this[key]?.let { it as NbtList<*> }

    /**
     * Returns the [NbtList] of bytes mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByte]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableByteList(key: String): NbtList<NbtByte>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of shorts mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtShort]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableShortList(key: String): NbtList<NbtShort>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of integers mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableIntList(key: String): NbtList<NbtInt>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of longs mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLong]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableLongList(key: String): NbtList<NbtLong>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of floats mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtFloat]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableFloatList(key: String): NbtList<NbtFloat>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of doubles mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtDouble]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableDoubleList(key: String): NbtList<NbtDouble>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of byte arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByteArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableByteArrayList(key: String): NbtList<NbtByteArray>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of strings mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtString]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableStringList(key: String): NbtList<NbtString>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of int arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableIntArrayList(key: String): NbtList<NbtIntArray>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of long arrays mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLongArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableLongArrayList(key: String): NbtList<NbtLongArray>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of compounds mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtCompound]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableCompoundList(key: String): NbtList<NbtCompound>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of lists mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtList]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableListOfList(key: String): NbtList<NbtList<*>>? = getNullableList(key)?.cast()

    /**
     * Checks if the other compound have a given tag, if it has been placed it in this compound.
     *
     * The tag will be linked, so any change in the tag will also affect both compounds.
     * @param other The compound that will be checked
     * @param tagKey The name of the tag that will be mapped
     * @param default If the other compound doesn't have the tag then this parameter will be used.
     */
    public fun copyFrom(other: NbtCompound, tagKey: String, default: NbtTag? = null) {
        val tag = other[tagKey] ?: default
        if (tag != null) {
            this[tagKey] = tag
        }
    }

    /**
     * Checks if the compound have a given tag, if it has been placed it in the other compound.
     *
     * The tag will be linked, so any change in the tag will also affect both compounds.
     * @param other The compound that will be modified
     * @param tagKey The name of the tag that will be mapped
     * @param default If the compound doesn't have the tag then this parameter will be used.
     */
    public fun copyTo(other: NbtCompound, tagKey: String, default: NbtTag? = null) {
        val tag = this[tagKey] ?: default
        if (tag != null) {
            other[tagKey] = tag
        }
    }

    /**
     * Returns a new NbtCompound with all nested values copied deeply.
     */
    override fun deepCopy(): NbtCompound = NbtCompound(mapValues { it.value.deepCopy() })

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
     * appropriated for developer inspections.
     *
     * The output will be similar to a normal [Map].
     *
     * Be aware that this may be a slow operation on compounds.
     */
    override fun toTechnicalString(): String {
        if (value.isEmpty()) {
            return "NbtCompound{}"
        }
        return "NbtCompound$stringValue"
        /*return buildString {
            append("NbtCompound{")
            val iterator = value.iterator()
            while (iterator.hasNext()) {
                val (key, tag) = iterator.next()
                append(key).append('=').append(tag)
                if (iterator.hasNext()) {
                    append(", ")
                }
            }
            append('}')
        }*/
    }

    override fun equals(other: Any?): Boolean {
        return value == other
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

}

/**
 * A tag which wraps a mutable int array.
 * @property value The wrapped value
 */
public data class NbtIntArray(var value: IntArray): NbtTag() {
    /**
     * Returns a string representation of the tag's value with a structure similar to a normal [List].
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on big arrays.
     */
    override val stringValue: String
        get() = value.takeIf { it.isNotEmpty() }?.joinToString(prefix = "[", postfix = "]") ?: "[]"

    /**
     * Creates a new tag with an empty array.
     */
    public constructor(): this(intArrayOf())

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * @param value A string with a structure like `[0, -32, 48, 127]`
     *
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    public constructor(value: String): this(value
        .removeSurrounding("[", "]")
        .split(", ")
        .takeIf { it.size > 1 || it.firstOrNull()?.isNotEmpty() == true }
        ?.map { it.toInt() }
        ?.toIntArray()
        ?: intArrayOf()
    )

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
     * appropriated for developer inspections.
     *
     * The output will be similar to a normal [List].
     *
     * Be aware that this may be a slow operation on big arrays.
     */
    override fun toTechnicalString(): String {
        return "NbtIntArray$stringValue"
    }

    /**
     * Properly checks the equality of the array.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NbtIntArray

        if (!value.contentEquals(other.value)) return false

        return true
    }

    /**
     * Properly calculates the hashcode of the array.
     */
    override fun hashCode(): Int {
        return value.contentHashCode()
    }

    /**
     * Returns a new wrapper with a copy of the current value.
     */
    override fun deepCopy(): NbtIntArray = copy(value = value.copyOf())
}

/**
 * A tag which wraps a mutable long array.
 * @property value The wrapped value
 */
public data class NbtLongArray(var value: LongArray) : NbtTag() {
    /**
     * Returns a string representation of the tag's value with a structure similar to a normal [List].
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on big arrays.
     */
    override val stringValue: String
        get() = value.takeIf { it.isNotEmpty() }?.joinToString(prefix = "[", postfix = "]") ?: "[]"

    /**
     * Creates a new tag with an empty array.
     */
    public constructor(): this(longArrayOf())

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * @param value A string with a structure like `[0, -32, 48, 127]`
     *
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    public constructor(value: String): this(value
        .removeSurrounding("[", "]")
        .split(", ")
        .takeIf { it.size > 1 || it.firstOrNull()?.isNotEmpty() == true }
        ?.map { it.toLong() }
        ?.toLongArray()
        ?: longArrayOf()
    )

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
     * appropriated for developer inspections.
     *
     * The output will be similar to a normal [List].
     *
     * Be aware that this may be a slow operation on big arrays.
     */
    override fun toTechnicalString(): String {
        return "NbtLongArray$stringValue"
    }

    /**
     * Properly checks the equality of the array.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NbtLongArray

        if (!value.contentEquals(other.value)) return false

        return true
    }

    /**
     * Properly calculates the hashcode of the array.
     */
    override fun hashCode(): Int {
        return value.contentHashCode()
    }

    /**
     * Returns a new wrapper with a copy of the current value.
     */
    override fun deepCopy(): NbtLongArray = copy(value = value.copyOf())
}
