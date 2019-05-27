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

