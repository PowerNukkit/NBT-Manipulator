@file:JvmName("NbtUtil")
@file:JvmMultifileClass

package br.com.gamemods.nbtmanipulator

/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtByte>.plusAssign(value: Byte) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtShort>.plusAssign(value: Short) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtInt>.plusAssign(value: Int) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtLong>.plusAssign(value: Long) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtFloat>.plusAssign(value: Float) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtDouble>.plusAssign(value: Double) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtString>.plusAssign(value: String) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtByteArray>.plusAssign(value: ByteArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtByteArray>.plusAssign(value: Array<Byte>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtIntArray>.plusAssign(value: IntArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtIntArray>.plusAssign(value: Array<Int>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtLongArray>.plusAssign(value: LongArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtLongArray>.plusAssign(value: Array<Long>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun NbtList<NbtCompound>.plusAssign(value: Map<String, NbtTag>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun <T: NbtTag> NbtList<NbtList<T>>.plusAssign(value: Iterable<T>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public operator fun <T: NbtTag> NbtList<NbtList<T>>.plusAssign(value: Array<T>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtByte>>.plusAssign(value: Array<Byte>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtByte>>.plusAssign(value: ByteArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterByte")
public operator fun NbtList<NbtList<NbtByte>>.plusAssign(value: Iterable<Byte>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtShort>>.plusAssign(value: Array<Short>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtShort>>.plusAssign(value: ShortArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterShort")
public operator fun NbtList<NbtList<NbtShort>>.plusAssign(value: Iterable<Short>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtInt>>.plusAssign(value: Array<Int>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtInt>>.plusAssign(value: IntArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterInt")
public operator fun NbtList<NbtList<NbtInt>>.plusAssign(value: Iterable<Int>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtLong>>.plusAssign(value: Array<Long>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtLong>>.plusAssign(value: LongArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterLong")
public operator fun NbtList<NbtList<NbtLong>>.plusAssign(value: Iterable<Long>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtFloat>>.plusAssign(value: Array<Float>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtFloat>>.plusAssign(value: FloatArray) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterFloat")
public operator fun NbtList<NbtList<NbtFloat>>.plusAssign(value: Iterable<Float>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtString>>.plusAssign(value: Array<String>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterString")
public operator fun NbtList<NbtList<NbtString>>.plusAssign(value: Iterable<String>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtByteArray>>.plusAssign(value: Array<ByteArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterByteArray")
public operator fun NbtList<NbtList<NbtByteArray>>.plusAssign(value: Iterable<ByteArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtIntArray>>.plusAssign(value: Array<IntArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterIntArray")
public operator fun NbtList<NbtList<NbtIntArray>>.plusAssign(value: Iterable<IntArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtLongArray>>.plusAssign(value: Array<LongArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterLongArray")
public operator fun NbtList<NbtList<NbtLongArray>>.plusAssign(value: Iterable<LongArray>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfList")
public operator fun NbtList<NbtList<NbtCompound>>.plusAssign(value: Array<Map<String, NbtTag>>) { add(value) }
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("plusAssignListOfListIterCompound")
public operator fun NbtList<NbtList<NbtCompound>>.plusAssign(value: Iterable<Map<String, NbtTag>>) { add(value) }
