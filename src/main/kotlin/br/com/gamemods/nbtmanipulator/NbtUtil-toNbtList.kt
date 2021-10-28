@file:JvmName("NbtUtil")
@file:JvmMultifileClass

package br.com.gamemods.nbtmanipulator

/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("booleanIterableToList")
public fun Iterable<Boolean>.toNbtList(): NbtList<NbtByte> = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("byteIterableToList")
public fun Iterable<Byte>.toNbtList(): NbtList<NbtByte> = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("shortIterableToList")
public fun Iterable<Short>.toNbtList(): NbtList<NbtShort> = NbtList(map { NbtShort(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("intIterableToList")
public fun Iterable<Int>.toNbtList(): NbtList<NbtInt> = NbtList(map { NbtInt(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("longIterableToList")
public fun Iterable<Long>.toNbtList(): NbtList<NbtLong> = NbtList(map { NbtLong(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("floatIterableToList")
public fun Iterable<Float>.toNbtList(): NbtList<NbtFloat> = NbtList(map { NbtFloat(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("doubleIterableToList")
public fun Iterable<Double>.toNbtList(): NbtList<NbtDouble> = NbtList(map { NbtDouble(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("stringIterableToList")
public fun Iterable<String>.toNbtList(): NbtList<NbtString> = NbtList(map { NbtString(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("byteArrayIterableToList")
public fun Iterable<ByteArray>.toNbtList(): NbtList<NbtByteArray> = NbtList(map { NbtByteArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("intArrayIterableToList")
public fun Iterable<IntArray>.toNbtList(): NbtList<NbtIntArray> = NbtList(map { NbtIntArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("longArrayIterableToList")
public fun Iterable<LongArray>.toNbtList(): NbtList<NbtLongArray> = NbtList(map { NbtLongArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("compoundIterableToList")
public fun Iterable<Map<String, NbtTag>>.toNbtList(): NbtList<NbtCompound> = NbtList(map { NbtCompound(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("listIterableToList")
public fun Iterable<Iterable<NbtTag>>.toNbtList(): NbtList<NbtList<NbtTag>> = NbtList(map { NbtList(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("byteListIterableToList")
public fun Iterable<Iterable<Byte>>.toNbtList(): NbtList<NbtList<NbtByte>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("shortListIterableToList")
public fun Iterable<Iterable<Short>>.toNbtList(): NbtList<NbtList<NbtShort>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("intListIterableToList")
public fun Iterable<Iterable<Int>>.toNbtList(): NbtList<NbtList<NbtInt>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("longListIterableToList")
public fun Iterable<Iterable<Long>>.toNbtList(): NbtList<NbtList<NbtLong>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("floatListIterableToList")
public fun Iterable<Iterable<Float>>.toNbtList(): NbtList<NbtList<NbtFloat>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("doubleListIterableToList")
public fun Iterable<Iterable<Double>>.toNbtList(): NbtList<NbtList<NbtDouble>> = NbtList(map { NbtList(it.toNbtList()) })

/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<Boolean>.toNbtList(): NbtList<NbtByte> = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<Byte>.toNbtList(): NbtList<NbtByte> = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<Short>.toNbtList(): NbtList<NbtShort> = NbtList(map { NbtShort(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<Int>.toNbtList(): NbtList<NbtInt> = NbtList(map { NbtInt(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<Long>.toNbtList(): NbtList<NbtLong> = NbtList(map { NbtLong(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<Float>.toNbtList(): NbtList<NbtFloat> = NbtList(map { NbtFloat(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<Double>.toNbtList(): NbtList<NbtDouble> = NbtList(map { NbtDouble(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun BooleanArray.toNbtList(): NbtList<NbtByte> = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun ByteArray.toNbtList(): NbtList<NbtByte> = NbtList(map { NbtByte(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun ShortArray.toNbtList(): NbtList<NbtShort> = NbtList(map { NbtShort(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun IntArray.toNbtList(): NbtList<NbtInt> = NbtList(map { NbtInt(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun LongArray.toNbtList(): NbtList<NbtLong> = NbtList(map { NbtLong(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun FloatArray.toNbtList(): NbtList<NbtFloat> = NbtList(map { NbtFloat(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun DoubleArray.toNbtList(): NbtList<NbtDouble> = NbtList(map { NbtDouble(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out String>.toNbtList(): NbtList<NbtString> = NbtList(map { NbtString(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out ByteArray>.toNbtList(): NbtList<NbtByteArray> = NbtList(map { NbtByteArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out IntArray>.toNbtList(): NbtList<NbtIntArray> = NbtList(map { NbtIntArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out LongArray>.toNbtList(): NbtList<NbtLongArray> = NbtList(map { NbtLongArray(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Map<String, NbtTag>>.toNbtList(): NbtList<NbtCompound> = NbtList(map { NbtCompound(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<NbtTag>>.toNbtList(): NbtList<NbtList<NbtTag>> = NbtList(map { NbtList(*it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<Byte>>.toNbtList(): NbtList<NbtList<NbtByte>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<Short>>.toNbtList(): NbtList<NbtList<NbtShort>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<Int>>.toNbtList(): NbtList<NbtList<NbtInt>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<Long>>.toNbtList(): NbtList<NbtList<NbtLong>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<Float>>.toNbtList(): NbtList<NbtList<NbtFloat>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<Double>>.toNbtList(): NbtList<NbtList<NbtDouble>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<out String>>.toNbtList(): NbtList<NbtList<NbtString>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<out ByteArray>>.toNbtList(): NbtList<NbtList<NbtByteArray>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<out IntArray>>.toNbtList(): NbtList<NbtList<NbtIntArray>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<out LongArray>>.toNbtList(): NbtList<NbtList<NbtLongArray>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<out Array<NbtTag>>>.toNbtList(): NbtList<NbtList<NbtList<NbtTag>>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayToNbtList")
public fun Array<out Array<out Map<String, NbtTag>>>.toNbtList(): NbtList<NbtList<NbtCompound>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableNbtTagToNbtList")
public fun Array<out Iterable<NbtTag>>.toNbtList(): NbtList<NbtList<NbtTag>> = NbtList(map { NbtList(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableByteToNbtList")
public fun Array<out Iterable<Byte>>.toNbtList(): NbtList<NbtList<NbtByte>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableShortToNbtList")
public fun Array<out Iterable<Short>>.toNbtList(): NbtList<NbtList<NbtShort>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableIntToNbtList")
public fun Array<out Iterable<Int>>.toNbtList(): NbtList<NbtList<NbtInt>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableLongToNbtList")
public fun Array<out Iterable<Long>>.toNbtList(): NbtList<NbtList<NbtLong>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableFloatToNbtList")
public fun Array<out Iterable<Float>>.toNbtList(): NbtList<NbtList<NbtFloat>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableDoubleToNbtList")
public fun Array<out Iterable<Double>>.toNbtList(): NbtList<NbtList<NbtDouble>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableStringToNbtList")
public fun Array<out Iterable<String>>.toNbtList(): NbtList<NbtList<NbtString>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableByteArrayToNbtList")
public fun Array<out Iterable<ByteArray>>.toNbtList(): NbtList<NbtList<NbtByteArray>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableIntArrayToNbtList")
public fun Array<out Iterable<IntArray>>.toNbtList(): NbtList<NbtList<NbtIntArray>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableLongArrayToNbtList")
public fun Array<out Iterable<LongArray>>.toNbtList(): NbtList<NbtList<NbtLongArray>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableIterableNbtTagToNbtList")
public fun Array<out Iterable<Iterable<NbtTag>>>.toNbtList(): NbtList<NbtList<NbtList<NbtTag>>> = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("arrayIterableCompoundToNbtList")
public fun Array<out Iterable<Map<String, NbtTag>>>.toNbtList(): NbtList<NbtList<NbtCompound>> = NbtList(map { NbtList(it.toNbtList()) })
