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
 * Removes a tag containing the given value.
 */
fun NbtList<NbtByte>.remove(value: Byte) = remove(NbtByte(value))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtShort>.remove(value: Short) = remove(NbtShort(value))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtInt>.remove(value: Int) = remove(NbtInt(value))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtLong>.remove(value: Long) = remove(NbtLong(value))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtFloat>.remove(value: Float) = remove(NbtFloat(value))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtDouble>.remove(value: Double) = remove(NbtDouble(value))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtString>.remove(value: String) = remove(NbtString(value))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtByteArray>.remove(value: ByteArray) = remove(NbtByteArray(value))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtByteArray>.remove(value: Array<Byte>) = remove(NbtByteArray(value.toByteArray()))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtIntArray>.remove(value: IntArray) = remove(NbtIntArray(value))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtIntArray>.remove(value: Array<Int>) = remove(NbtIntArray(value.toIntArray()))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtLongArray>.remove(value: LongArray) = remove(NbtLongArray(value))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtLongArray>.remove(value: Array<Long>) = remove(NbtLongArray(value.toLongArray()))
/**
 * Removes a tag containing the given value.
 */
fun NbtList<NbtCompound>.remove(value: Map<String, NbtTag>) = remove(NbtCompound(value))
/**
 * Removes a tag containing the given value.
 */
fun <T: NbtTag> NbtList<NbtList<T>>.remove(value: Iterable<T>) = remove(NbtList(value))
/**
 * Removes a tag containing the given value.
 */
fun <T: NbtTag> NbtList<NbtList<T>>.remove(value: Array<T>) = remove(NbtList(*value))
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtByte>>.remove(value: Array<Byte>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtByte>>.remove(value: ByteArray) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterByte")
fun NbtList<NbtList<NbtByte>>.remove(value: Iterable<Byte>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtShort>>.remove(value: Array<Short>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtShort>>.remove(value: ShortArray) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterShort")
fun NbtList<NbtList<NbtShort>>.remove(value: Iterable<Short>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtInt>>.remove(value: Array<Int>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtInt>>.remove(value: IntArray) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterInt")
fun NbtList<NbtList<NbtInt>>.remove(value: Iterable<Int>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtLong>>.remove(value: Array<Long>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtLong>>.remove(value: LongArray) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterLong")
fun NbtList<NbtList<NbtLong>>.remove(value: Iterable<Long>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtFloat>>.remove(value: Array<Float>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtFloat>>.remove(value: FloatArray) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterFloat")
fun NbtList<NbtList<NbtFloat>>.remove(value: Iterable<Float>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtString>>.remove(value: Array<String>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterString")
fun NbtList<NbtList<NbtString>>.remove(value: Iterable<String>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtByteArray>>.remove(value: Array<ByteArray>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterByteArray")
fun NbtList<NbtList<NbtByteArray>>.remove(value: Iterable<ByteArray>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtIntArray>>.remove(value: Array<IntArray>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterIntArray")
fun NbtList<NbtList<NbtIntArray>>.remove(value: Iterable<IntArray>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtLongArray>>.remove(value: Array<LongArray>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterLongArray")
fun NbtList<NbtList<NbtLongArray>>.remove(value: Iterable<LongArray>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfList")
fun NbtList<NbtList<NbtCompound>>.remove(value: Array<Map<String, NbtTag>>) = remove(value.toNbtList())
/**
 * Removes a tag containing the given value.
 */
@JvmName("removeListOfListIterCompound")
fun NbtList<NbtList<NbtCompound>>.remove(value: Iterable<Map<String, NbtTag>>) = add(value.toNbtList())

/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtByte>.minusAssign(value: Byte) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtShort>.minusAssign(value: Short) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtInt>.minusAssign(value: Int) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtLong>.minusAssign(value: Long) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtFloat>.minusAssign(value: Float) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtDouble>.minusAssign(value: Double) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtString>.minusAssign(value: String) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtByteArray>.minusAssign(value: ByteArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtByteArray>.minusAssign(value: Array<Byte>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtIntArray>.minusAssign(value: IntArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtIntArray>.minusAssign(value: Array<Int>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtLongArray>.minusAssign(value: LongArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtLongArray>.minusAssign(value: Array<Long>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun NbtList<NbtCompound>.minusAssign(value: Map<String, NbtTag>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun <T: NbtTag> NbtList<NbtList<T>>.minusAssign(value: Iterable<T>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
operator fun <T: NbtTag> NbtList<NbtList<T>>.minusAssign(value: Array<T>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtByte>>.minusAssign(value: Array<Byte>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtByte>>.minusAssign(value: ByteArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterByte")
operator fun NbtList<NbtList<NbtByte>>.minusAssign(value: Iterable<Byte>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtShort>>.minusAssign(value: Array<Short>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtShort>>.minusAssign(value: ShortArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterShort")
operator fun NbtList<NbtList<NbtShort>>.minusAssign(value: Iterable<Short>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtInt>>.minusAssign(value: Array<Int>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtInt>>.minusAssign(value: IntArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterInt")
operator fun NbtList<NbtList<NbtInt>>.minusAssign(value: Iterable<Int>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtLong>>.minusAssign(value: Array<Long>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtLong>>.minusAssign(value: LongArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterLong")
operator fun NbtList<NbtList<NbtLong>>.minusAssign(value: Iterable<Long>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtFloat>>.minusAssign(value: Array<Float>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtFloat>>.minusAssign(value: FloatArray) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterFloat")
operator fun NbtList<NbtList<NbtFloat>>.minusAssign(value: Iterable<Float>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtString>>.minusAssign(value: Array<String>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterString")
operator fun NbtList<NbtList<NbtString>>.minusAssign(value: Iterable<String>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtByteArray>>.minusAssign(value: Array<ByteArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterByteArray")
operator fun NbtList<NbtList<NbtByteArray>>.minusAssign(value: Iterable<ByteArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtIntArray>>.minusAssign(value: Array<IntArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterIntArray")
operator fun NbtList<NbtList<NbtIntArray>>.minusAssign(value: Iterable<IntArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtLongArray>>.minusAssign(value: Array<LongArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterLongArray")
operator fun NbtList<NbtList<NbtLongArray>>.minusAssign(value: Iterable<LongArray>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfList")
operator fun NbtList<NbtList<NbtCompound>>.minusAssign(value: Array<Map<String, NbtTag>>) { remove(value) }
/**
 * Removes a tag containing the given value.
 */
@JvmName("minusAssignListOfListIterCompound")
operator fun NbtList<NbtList<NbtCompound>>.minusAssign(value: Iterable<Map<String, NbtTag>>) { remove(value) }

/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtByte>.contains(value: Byte) = contains(NbtByte(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtShort>.contains(value: Short) = contains(NbtShort(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtInt>.contains(value: Int) = contains(NbtInt(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtLong>.contains(value: Long) = contains(NbtLong(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtFloat>.contains(value: Float) = contains(NbtFloat(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtDouble>.contains(value: Double) = contains(NbtDouble(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtString>.contains(value: String) = contains(NbtString(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtByteArray>.contains(value: ByteArray) = contains(NbtByteArray(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtByteArray>.contains(value: Array<Byte>) = contains(NbtByteArray(value.toByteArray()))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtIntArray>.contains(value: IntArray) = contains(NbtIntArray(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtIntArray>.contains(value: Array<Int>) = contains(NbtIntArray(value.toIntArray()))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtLongArray>.contains(value: LongArray) = contains(NbtLongArray(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtLongArray>.contains(value: Array<Long>) = contains(NbtLongArray(value.toLongArray()))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun NbtList<NbtCompound>.contains(value: Map<String, NbtTag>) = contains(NbtCompound(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun <T: NbtTag> NbtList<NbtList<T>>.contains(value: Iterable<T>) = contains(NbtList(value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
operator fun <T: NbtTag> NbtList<NbtList<T>>.contains(value: Array<T>) = contains(NbtList(*value))
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtByte>>.contains(value: Array<Byte>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtByte>>.contains(value: ByteArray) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterByte")
operator fun NbtList<NbtList<NbtByte>>.contains(value: Iterable<Byte>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtShort>>.contains(value: Array<Short>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtShort>>.contains(value: ShortArray) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterShort")
operator fun NbtList<NbtList<NbtShort>>.contains(value: Iterable<Short>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtInt>>.contains(value: Array<Int>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtInt>>.contains(value: IntArray) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterInt")
operator fun NbtList<NbtList<NbtInt>>.contains(value: Iterable<Int>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtLong>>.contains(value: Array<Long>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtLong>>.contains(value: LongArray) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterLong")
operator fun NbtList<NbtList<NbtLong>>.contains(value: Iterable<Long>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtFloat>>.contains(value: Array<Float>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtFloat>>.contains(value: FloatArray) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterFloat")
operator fun NbtList<NbtList<NbtFloat>>.contains(value: Iterable<Float>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtString>>.contains(value: Array<String>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterString")
operator fun NbtList<NbtList<NbtString>>.contains(value: Iterable<String>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtByteArray>>.contains(value: Array<ByteArray>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterByteArray")
operator fun NbtList<NbtList<NbtByteArray>>.contains(value: Iterable<ByteArray>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtIntArray>>.contains(value: Array<IntArray>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterIntArray")
operator fun NbtList<NbtList<NbtIntArray>>.contains(value: Iterable<IntArray>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtLongArray>>.contains(value: Array<LongArray>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterLongArray")
operator fun NbtList<NbtList<NbtLongArray>>.contains(value: Iterable<LongArray>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfList")
operator fun NbtList<NbtList<NbtCompound>>.contains(value: Array<Map<String, NbtTag>>) = contains(value.toNbtList())
/**
 * Checks if the list contains a [NbtTag] with the given value.
 */
@JvmName("containsListOfListIterCompound")
operator fun NbtList<NbtList<NbtCompound>>.contains(value: Iterable<Map<String, NbtTag>>) = add(value.toNbtList())

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

