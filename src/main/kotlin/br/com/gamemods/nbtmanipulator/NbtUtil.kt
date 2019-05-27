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
fun Iterable<List<NbtTag>>.toNbtList() = NbtList(map { NbtList(it) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("byteListIterableToList")
fun Iterable<List<Byte>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("shortListIterableToList")
fun Iterable<List<Short>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("intListIterableToList")
fun Iterable<List<Int>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("longListIterableToList")
fun Iterable<List<Long>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("floatListIterableToList")
fun Iterable<List<Float>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
/**
 * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
 */
@JvmName("doubleListIterableToList")
fun Iterable<List<Double>>.toNbtList() = NbtList(map { NbtList(it.toNbtList()) })
