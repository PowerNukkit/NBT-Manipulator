@file:JvmName("NbtUtil")

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

/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtByte>.remove(value: Byte): Boolean = remove(NbtByte(value))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtShort>.remove(value: Short): Boolean = remove(NbtShort(value))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtInt>.remove(value: Int): Boolean = remove(NbtInt(value))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtLong>.remove(value: Long): Boolean = remove(NbtLong(value))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtFloat>.remove(value: Float): Boolean = remove(NbtFloat(value))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtDouble>.remove(value: Double): Boolean = remove(NbtDouble(value))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtString>.remove(value: String): Boolean = remove(NbtString(value))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtByteArray>.remove(value: ByteArray): Boolean = remove(NbtByteArray(value))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtByteArray>.remove(value: Array<Byte>): Boolean = remove(NbtByteArray(value.toByteArray()))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtIntArray>.remove(value: IntArray): Boolean = remove(NbtIntArray(value))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtIntArray>.remove(value: Array<Int>): Boolean = remove(NbtIntArray(value.toIntArray()))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtLongArray>.remove(value: LongArray): Boolean = remove(NbtLongArray(value))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtLongArray>.remove(value: Array<Long>): Boolean = remove(NbtLongArray(value.toLongArray()))
/**
 * Removes a tag containing the given value.
 */
public fun NbtList<NbtCompound>.remove(value: Map<String, NbtTag>): Boolean = remove(NbtCompound(value))
/**
 * Removes a tag containing the given value.
 */
public fun <T: NbtTag> NbtList<NbtList<T>>.remove(value: Iterable<T>): Boolean = remove(NbtList(value))
/**
 * Removes a tag containing the given value.
 */
public fun <T: NbtTag> NbtList<NbtList<T>>.remove(value: Array<T>): Boolean = remove(NbtList(*value))
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtByte>>.remove(value: Array<Byte>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtByte>>.remove(value: ByteArray): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterByte")
public fun NbtList<NbtList<NbtByte>>.remove(value: Iterable<Byte>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtShort>>.remove(value: Array<Short>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtShort>>.remove(value: ShortArray): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterShort")
public fun NbtList<NbtList<NbtShort>>.remove(value: Iterable<Short>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtInt>>.remove(value: Array<Int>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtInt>>.remove(value: IntArray): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterInt")
public fun NbtList<NbtList<NbtInt>>.remove(value: Iterable<Int>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtLong>>.remove(value: Array<Long>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtLong>>.remove(value: LongArray): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterLong")
public fun NbtList<NbtList<NbtLong>>.remove(value: Iterable<Long>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtFloat>>.remove(value: Array<Float>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtFloat>>.remove(value: FloatArray): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterFloat")
public fun NbtList<NbtList<NbtFloat>>.remove(value: Iterable<Float>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtString>>.remove(value: Array<String>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterString")
public fun NbtList<NbtList<NbtString>>.remove(value: Iterable<String>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtByteArray>>.remove(value: Array<ByteArray>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterByteArray")
public fun NbtList<NbtList<NbtByteArray>>.remove(value: Iterable<ByteArray>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtIntArray>>.remove(value: Array<IntArray>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterIntArray")
public fun NbtList<NbtList<NbtIntArray>>.remove(value: Iterable<IntArray>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtLongArray>>.remove(value: Array<LongArray>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterLongArray")
public fun NbtList<NbtList<NbtLongArray>>.remove(value: Iterable<LongArray>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
public fun NbtList<NbtList<NbtCompound>>.remove(value: Array<Map<String, NbtTag>>): Boolean = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterCompound")
public fun NbtList<NbtList<NbtCompound>>.remove(value: Iterable<Map<String, NbtTag>>): Boolean = add(value.toNbtList())

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

/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtByte>.contains(value: Byte): Boolean = contains(NbtByte(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtShort>.contains(value: Short): Boolean = contains(NbtShort(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtInt>.contains(value: Int): Boolean = contains(NbtInt(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtLong>.contains(value: Long): Boolean = contains(NbtLong(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtFloat>.contains(value: Float): Boolean = contains(NbtFloat(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtDouble>.contains(value: Double): Boolean = contains(NbtDouble(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtString>.contains(value: String): Boolean = contains(NbtString(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtByteArray>.contains(value: ByteArray): Boolean = contains(NbtByteArray(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtByteArray>.contains(value: Array<Byte>): Boolean = contains(NbtByteArray(value.toByteArray()))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtIntArray>.contains(value: IntArray): Boolean = contains(NbtIntArray(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtIntArray>.contains(value: Array<Int>): Boolean = contains(NbtIntArray(value.toIntArray()))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtLongArray>.contains(value: LongArray): Boolean = contains(NbtLongArray(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtLongArray>.contains(value: Array<Long>): Boolean = contains(NbtLongArray(value.toLongArray()))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun NbtList<NbtCompound>.contains(value: Map<String, NbtTag>): Boolean = contains(NbtCompound(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun <T: NbtTag> NbtList<NbtList<T>>.contains(value: Iterable<T>): Boolean = contains(NbtList(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
public operator fun <T: NbtTag> NbtList<NbtList<T>>.contains(value: Array<T>): Boolean = contains(NbtList(*value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtByte>>.contains(value: Array<Byte>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtByte>>.contains(value: ByteArray): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterByte")
public operator fun NbtList<NbtList<NbtByte>>.contains(value: Iterable<Byte>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtShort>>.contains(value: Array<Short>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtShort>>.contains(value: ShortArray): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterShort")
public operator fun NbtList<NbtList<NbtShort>>.contains(value: Iterable<Short>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtInt>>.contains(value: Array<Int>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtInt>>.contains(value: IntArray): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterInt")
public operator fun NbtList<NbtList<NbtInt>>.contains(value: Iterable<Int>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtLong>>.contains(value: Array<Long>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtLong>>.contains(value: LongArray): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterLong")
public operator fun NbtList<NbtList<NbtLong>>.contains(value: Iterable<Long>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtFloat>>.contains(value: Array<Float>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtFloat>>.contains(value: FloatArray): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterFloat")
public operator fun NbtList<NbtList<NbtFloat>>.contains(value: Iterable<Float>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtString>>.contains(value: Array<String>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterString")
public operator fun NbtList<NbtList<NbtString>>.contains(value: Iterable<String>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtByteArray>>.contains(value: Array<ByteArray>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterByteArray")
public operator fun NbtList<NbtList<NbtByteArray>>.contains(value: Iterable<ByteArray>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtIntArray>>.contains(value: Array<IntArray>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterIntArray")
public operator fun NbtList<NbtList<NbtIntArray>>.contains(value: Iterable<IntArray>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtLongArray>>.contains(value: Array<LongArray>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterLongArray")
public operator fun NbtList<NbtList<NbtLongArray>>.contains(value: Iterable<LongArray>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
public operator fun NbtList<NbtList<NbtCompound>>.contains(value: Array<Map<String, NbtTag>>): Boolean = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterCompound")
public operator fun NbtList<NbtList<NbtCompound>>.contains(value: Iterable<Map<String, NbtTag>>): Boolean = add(value.toNbtList())

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

