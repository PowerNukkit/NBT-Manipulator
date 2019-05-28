@file:JvmName("NbtUtil")
@file:Suppress("unused")

package br.com.gamemods.nbtmanipulator

internal const val BYTE_TRUE: Byte = 1

internal inline fun <reified Nbt: NbtTag> NbtList<*>.cast(): NbtList<Nbt> {
    /*check(Nbt::class == NbtTag::class) {
        "NbtTag is not a valid type for NbtList"
    }*/

    if (isNotEmpty()) {
        check(first()::class == Nbt::class) {
            "Cannot use this list as NbtList<${Nbt::class.simpleName}>"
        }
    }

    @Suppress("UNCHECKED_CAST")
    return this as NbtList<Nbt>
}

/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtByte>.add(value: Byte) = add(NbtByte(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtShort>.add(value: Short) = add(NbtShort(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtInt>.add(value: Int) = add(NbtInt(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtLong>.add(value: Long) = add(NbtLong(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtFloat>.add(value: Float) = add(NbtFloat(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtDouble>.add(value: Double) = add(NbtDouble(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtString>.add(value: String) = add(NbtString(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtByteArray>.add(value: ByteArray) = add(NbtByteArray(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtByteArray>.add(value: Array<Byte>) = add(NbtByteArray(value.toByteArray()))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtIntArray>.add(value: IntArray) = add(NbtIntArray(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtIntArray>.add(value: Array<Int>) = add(NbtIntArray(value.toIntArray()))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtLongArray>.add(value: LongArray) = add(NbtLongArray(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtLongArray>.add(value: Array<Long>) = add(NbtLongArray(value.toLongArray()))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun NbtList<NbtCompound>.add(value: Map<String, NbtTag>) = add(NbtCompound(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun <T: NbtTag> NbtList<NbtList<T>>.add(value: Iterable<T>) = add(NbtList(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
fun <T: NbtTag> NbtList<NbtList<T>>.add(value: Array<T>) = add(NbtList(*value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtByte>>.add(value: Array<Byte>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtByte>>.add(value: ByteArray) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterByte")
fun NbtList<NbtList<NbtByte>>.add(value: Iterable<Byte>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtShort>>.add(value: Array<Short>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtShort>>.add(value: ShortArray) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterShort")
fun NbtList<NbtList<NbtShort>>.add(value: Iterable<Short>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtInt>>.add(value: Array<Int>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtInt>>.add(value: IntArray) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterInt")
fun NbtList<NbtList<NbtInt>>.add(value: Iterable<Int>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtLong>>.add(value: Array<Long>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtLong>>.add(value: LongArray) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterLong")
fun NbtList<NbtList<NbtLong>>.add(value: Iterable<Long>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtFloat>>.add(value: Array<Float>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtFloat>>.add(value: FloatArray) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterFloat")
fun NbtList<NbtList<NbtFloat>>.add(value: Iterable<Float>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtString>>.add(value: Array<String>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterString")
fun NbtList<NbtList<NbtString>>.add(value: Iterable<String>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtByteArray>>.add(value: Array<ByteArray>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterByteArray")
fun NbtList<NbtList<NbtByteArray>>.add(value: Iterable<ByteArray>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtIntArray>>.add(value: Array<IntArray>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterIntArray")
fun NbtList<NbtList<NbtIntArray>>.add(value: Iterable<IntArray>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtLongArray>>.add(value: Array<LongArray>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterLongArray")
fun NbtList<NbtList<NbtLongArray>>.add(value: Iterable<LongArray>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
fun NbtList<NbtList<NbtCompound>>.add(value: Array<Map<String, NbtTag>>) = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterCompound")
fun NbtList<NbtList<NbtCompound>>.add(value: Iterable<Map<String, NbtTag>>) = add(value.toNbtList())

/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtByte>.plusAssign(value: Byte) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtShort>.plusAssign(value: Short) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtInt>.plusAssign(value: Int) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtLong>.plusAssign(value: Long) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtFloat>.plusAssign(value: Float) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtDouble>.plusAssign(value: Double) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtString>.plusAssign(value: String) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtByteArray>.plusAssign(value: ByteArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtByteArray>.plusAssign(value: Array<Byte>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtIntArray>.plusAssign(value: IntArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtIntArray>.plusAssign(value: Array<Int>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtLongArray>.plusAssign(value: LongArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtLongArray>.plusAssign(value: Array<Long>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun NbtList<NbtCompound>.plusAssign(value: Map<String, NbtTag>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun <T: NbtTag> NbtList<NbtList<T>>.plusAssign(value: Iterable<T>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
operator fun <T: NbtTag> NbtList<NbtList<T>>.plusAssign(value: Array<T>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtByte>>.plusAssign(value: Array<Byte>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtByte>>.plusAssign(value: ByteArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterByte")
operator fun NbtList<NbtList<NbtByte>>.plusAssign(value: Iterable<Byte>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtShort>>.plusAssign(value: Array<Short>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtShort>>.plusAssign(value: ShortArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterShort")
operator fun NbtList<NbtList<NbtShort>>.plusAssign(value: Iterable<Short>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtInt>>.plusAssign(value: Array<Int>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtInt>>.plusAssign(value: IntArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterInt")
operator fun NbtList<NbtList<NbtInt>>.plusAssign(value: Iterable<Int>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtLong>>.plusAssign(value: Array<Long>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtLong>>.plusAssign(value: LongArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterLong")
operator fun NbtList<NbtList<NbtLong>>.plusAssign(value: Iterable<Long>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtFloat>>.plusAssign(value: Array<Float>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtFloat>>.plusAssign(value: FloatArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterFloat")
operator fun NbtList<NbtList<NbtFloat>>.plusAssign(value: Iterable<Float>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtString>>.plusAssign(value: Array<String>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterString")
operator fun NbtList<NbtList<NbtString>>.plusAssign(value: Iterable<String>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtByteArray>>.plusAssign(value: Array<ByteArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterByteArray")
operator fun NbtList<NbtList<NbtByteArray>>.plusAssign(value: Iterable<ByteArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtIntArray>>.plusAssign(value: Array<IntArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterIntArray")
operator fun NbtList<NbtList<NbtIntArray>>.plusAssign(value: Iterable<IntArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtLongArray>>.plusAssign(value: Array<LongArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterLongArray")
operator fun NbtList<NbtList<NbtLongArray>>.plusAssign(value: Iterable<LongArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
operator fun NbtList<NbtList<NbtCompound>>.plusAssign(value: Array<Map<String, NbtTag>>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterCompound")
operator fun NbtList<NbtList<NbtCompound>>.plusAssign(value: Iterable<Map<String, NbtTag>>) { add(value) }

/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("booleanIterableToList")
fun Iterable<Boolean>.toNbtList() = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("byteIterableToList")
fun Iterable<Byte>.toNbtList() = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("shortIterableToList")
fun Iterable<Short>.toNbtList() = NbtList(map { NbtShort(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("intIterableToList")
fun Iterable<Int>.toNbtList() = NbtList(map { NbtInt(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("longIterableToList")
fun Iterable<Long>.toNbtList() = NbtList(map { NbtLong(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("floatIterableToList")
fun Iterable<Float>.toNbtList() = NbtList(map { NbtFloat(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("doubleIterableToList")
fun Iterable<Double>.toNbtList() = NbtList(map { NbtDouble(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("stringIterableToList")
fun Iterable<String>.toNbtList() = NbtList(map { NbtString(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("byteArrayIterableToList")
fun Iterable<ByteArray>.toNbtList() = NbtList(map { NbtByteArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("intArrayIterableToList")
fun Iterable<IntArray>.toNbtList() = NbtList(map { NbtIntArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("longArrayIterableToList")
fun Iterable<LongArray>.toNbtList() = NbtList(map { NbtLongArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("compoundIterableToList")
fun Iterable<Map<String, NbtTag>>.toNbtList() = NbtList(map { NbtCompound(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("listIterableToList")
fun Iterable<Iterable<NbtTag>>.toNbtList() = NbtList(map { NbtList(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("byteListIterableToList")
fun Iterable<Iterable<Byte>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("shortListIterableToList")
fun Iterable<Iterable<Short>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("intListIterableToList")
fun Iterable<Iterable<Int>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("longListIterableToList")
fun Iterable<Iterable<Long>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("floatListIterableToList")
fun Iterable<Iterable<Float>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("doubleListIterableToList")
fun Iterable<Iterable<Double>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })

/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<Boolean>.toNbtList() = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<Byte>.toNbtList() = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<Short>.toNbtList() = NbtList(map { NbtShort(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<Int>.toNbtList() = NbtList(map { NbtInt(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<Long>.toNbtList() = NbtList(map { NbtLong(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<Float>.toNbtList() = NbtList(map { NbtFloat(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<Double>.toNbtList() = NbtList(map { NbtDouble(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun BooleanArray.toNbtList() = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun ByteArray.toNbtList() = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun ShortArray.toNbtList() = NbtList(map { NbtShort(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun IntArray.toNbtList() = NbtList(map { NbtInt(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun LongArray.toNbtList() = NbtList(map { NbtLong(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun FloatArray.toNbtList() = NbtList(map { NbtFloat(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun DoubleArray.toNbtList() = NbtList(map { NbtDouble(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out String>.toNbtList() = NbtList(map { NbtString(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out ByteArray>.toNbtList() = NbtList(map { NbtByteArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out IntArray>.toNbtList() = NbtList(map { NbtIntArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out LongArray>.toNbtList() = NbtList(map { NbtLongArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Map<String, NbtTag>>.toNbtList() = NbtList(map { NbtCompound(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<NbtTag>>.toNbtList() = NbtList(map { NbtList(*it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<Byte>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<Short>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<Int>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<Long>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<Float>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<Double>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<out String>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<out ByteArray>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<out IntArray>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<out LongArray>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<out Array<NbtTag>>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
fun Array<out Array<out Map<String, NbtTag>>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableNbtTagToNbtList")
fun Array<out Iterable<NbtTag>>.toNbtList() = NbtList(map { NbtList(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableByteToNbtList")
fun Array<out Iterable<Byte>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableShortToNbtList")
fun Array<out Iterable<Short>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableIntToNbtList")
fun Array<out Iterable<Int>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableLongToNbtList")
fun Array<out Iterable<Long>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableFloatToNbtList")
fun Array<out Iterable<Float>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableDoubleToNbtList")
fun Array<out Iterable<Double>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableStringToNbtList")
fun Array<out Iterable<String>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableByteArrayToNbtList")
fun Array<out Iterable<ByteArray>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableIntArrayToNbtList")
fun Array<out Iterable<IntArray>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableLongArrayToNbtList")
fun Array<out Iterable<LongArray>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableIterableNbtTagToNbtList")
fun Array<out Iterable<Iterable<NbtTag>>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableCompoundToNbtList")
fun Array<out Iterable<Map<String, NbtTag>>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })

