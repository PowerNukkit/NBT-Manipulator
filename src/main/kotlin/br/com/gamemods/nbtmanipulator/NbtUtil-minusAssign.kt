@file:JvmName("NbtUtil")
@file:JvmMultifileClass

package br.com.gamemods.nbtmanipulator

/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtByte>.minusAssign(value: Byte) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtShort>.minusAssign(value: Short) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtInt>.minusAssign(value: Int) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtLong>.minusAssign(value: Long) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtFloat>.minusAssign(value: Float) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtDouble>.minusAssign(value: Double) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtString>.minusAssign(value: String) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtByteArray>.minusAssign(value: ByteArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtByteArray>.minusAssign(value: Array<Byte>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtIntArray>.minusAssign(value: IntArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtIntArray>.minusAssign(value: Array<Int>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtLongArray>.minusAssign(value: LongArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtLongArray>.minusAssign(value: Array<Long>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun NbtList<NbtCompound>.minusAssign(value: Map<String, NbtTag>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun <T: NbtTag> NbtList<NbtList<T>>.minusAssign(value: Iterable<T>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
public operator fun <T: NbtTag> NbtList<NbtList<T>>.minusAssign(value: Array<T>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtByte>>.minusAssign(value: Array<Byte>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtByte>>.minusAssign(value: ByteArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterByte")
public operator fun NbtList<NbtList<NbtByte>>.minusAssign(value: Iterable<Byte>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtShort>>.minusAssign(value: Array<Short>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtShort>>.minusAssign(value: ShortArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterShort")
public operator fun NbtList<NbtList<NbtShort>>.minusAssign(value: Iterable<Short>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtInt>>.minusAssign(value: Array<Int>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtInt>>.minusAssign(value: IntArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterInt")
public operator fun NbtList<NbtList<NbtInt>>.minusAssign(value: Iterable<Int>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtLong>>.minusAssign(value: Array<Long>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtLong>>.minusAssign(value: LongArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterLong")
public operator fun NbtList<NbtList<NbtLong>>.minusAssign(value: Iterable<Long>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtFloat>>.minusAssign(value: Array<Float>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtFloat>>.minusAssign(value: FloatArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterFloat")
public operator fun NbtList<NbtList<NbtFloat>>.minusAssign(value: Iterable<Float>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtString>>.minusAssign(value: Array<String>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterString")
public operator fun NbtList<NbtList<NbtString>>.minusAssign(value: Iterable<String>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtByteArray>>.minusAssign(value: Array<ByteArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterByteArray")
public operator fun NbtList<NbtList<NbtByteArray>>.minusAssign(value: Iterable<ByteArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtIntArray>>.minusAssign(value: Array<IntArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterIntArray")
public operator fun NbtList<NbtList<NbtIntArray>>.minusAssign(value: Iterable<IntArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtLongArray>>.minusAssign(value: Array<LongArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterLongArray")
public operator fun NbtList<NbtList<NbtLongArray>>.minusAssign(value: Iterable<LongArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
public operator fun NbtList<NbtList<NbtCompound>>.minusAssign(value: Array<Map<String, NbtTag>>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterCompound")
public operator fun NbtList<NbtList<NbtCompound>>.minusAssign(value: Iterable<Map<String, NbtTag>>) { remove(value) }
