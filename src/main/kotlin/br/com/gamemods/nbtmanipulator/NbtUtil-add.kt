@file:JvmName("NbtUtil")
@file:JvmMultifileClass

package br.com.gamemods.nbtmanipulator

/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtByte>.add(value: Byte): Boolean = add(NbtByte(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtShort>.add(value: Short): Boolean = add(NbtShort(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtInt>.add(value: Int): Boolean = add(NbtInt(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtLong>.add(value: Long): Boolean = add(NbtLong(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtFloat>.add(value: Float): Boolean = add(NbtFloat(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtDouble>.add(value: Double): Boolean = add(NbtDouble(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtString>.add(value: String): Boolean = add(NbtString(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtByteArray>.add(value: ByteArray): Boolean = add(NbtByteArray(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtByteArray>.add(value: Array<Byte>): Boolean = add(NbtByteArray(value.toByteArray()))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtIntArray>.add(value: IntArray): Boolean = add(NbtIntArray(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtIntArray>.add(value: Array<Int>): Boolean = add(NbtIntArray(value.toIntArray()))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtLongArray>.add(value: LongArray): Boolean = add(NbtLongArray(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtLongArray>.add(value: Array<Long>): Boolean = add(NbtLongArray(value.toLongArray()))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun NbtList<NbtCompound>.add(value: Map<String, NbtTag>): Boolean = add(NbtCompound(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun <T: NbtTag> NbtList<NbtList<T>>.add(value: Iterable<T>): Boolean = add(NbtList(value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
public fun <T: NbtTag> NbtList<NbtList<T>>.add(value: Array<T>): Boolean = add(NbtList(*value))
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtByte>>.add(value: Array<Byte>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtByte>>.add(value: ByteArray): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterByte")
public fun NbtList<NbtList<NbtByte>>.add(value: Iterable<Byte>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtShort>>.add(value: Array<Short>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtShort>>.add(value: ShortArray): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterShort")
public fun NbtList<NbtList<NbtShort>>.add(value: Iterable<Short>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtInt>>.add(value: Array<Int>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtInt>>.add(value: IntArray): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterInt")
public fun NbtList<NbtList<NbtInt>>.add(value: Iterable<Int>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtLong>>.add(value: Array<Long>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtLong>>.add(value: LongArray): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterLong")
public fun NbtList<NbtList<NbtLong>>.add(value: Iterable<Long>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtFloat>>.add(value: Array<Float>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtFloat>>.add(value: FloatArray): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterFloat")
public fun NbtList<NbtList<NbtFloat>>.add(value: Iterable<Float>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtString>>.add(value: Array<String>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterString")
public fun NbtList<NbtList<NbtString>>.add(value: Iterable<String>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtByteArray>>.add(value: Array<ByteArray>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterByteArray")
public fun NbtList<NbtList<NbtByteArray>>.add(value: Iterable<ByteArray>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtIntArray>>.add(value: Array<IntArray>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterIntArray")
public fun NbtList<NbtList<NbtIntArray>>.add(value: Iterable<IntArray>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtLongArray>>.add(value: Array<LongArray>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterLongArray")
public fun NbtList<NbtList<NbtLongArray>>.add(value: Iterable<LongArray>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfList")
public fun NbtList<NbtList<NbtCompound>>.add(value: Array<Map<String, NbtTag>>): Boolean = add(value.toNbtList())
/**
 * Adds a value with the appropriated [NbtTag] wrapper.
 */
@JvmName("addListOfListIterCompound")
public fun NbtList<NbtList<NbtCompound>>.add(value: Iterable<Map<String, NbtTag>>): Boolean = add(value.toNbtList())
