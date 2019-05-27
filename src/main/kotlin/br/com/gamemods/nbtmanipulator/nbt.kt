@file:JvmName("NbtUtil")
@file:Suppress("unused")

package br.com.gamemods.nbtmanipulator

/**
 * The root component of a file, it contains a hint for the file name and the first tag in the file.
 * @property name The key for the file name. Empty in most cases.
 * @property tag The first tag in the file. A [NbtCompound] in most cases.
 * @property compound A shortcut to read or write [NbtFile.tag] as a [NbtCompound].
 * Will throw a [ClassCastException] if the tag value is not a [NbtCompound]
 */
data class NbtFile(var name: String, var tag: NbtTag) {
    var compound: NbtCompound
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
sealed class NbtTag {
    /**
     * Copies all this and all nested NbtTags into new objects.
     */
    abstract fun deepCopy(): NbtTag
}

/**
 * A special tag which indicates the end of a compound stream or empty lists.
 *
 * Should not be used directly.
 */
object NbtEnd : NbtTag() {
    /**
     * Returns itself.
     */
    override fun deepCopy() = NbtEnd
}

/**
 * A tag which wraps a byte value.
 * @property value The wrapped value
 */
data class NbtByte(var value: Byte) : NbtTag() {
    /**
     * Wraps a byte `1` if the value is `true` and `0` otherwise.
     * @param value The value to be checked
     */
    constructor(value: Boolean): this(if (value) BYTE_TRUE else 0)

    /**
     * Converts the int value to an unsigned byte and wraps it.
     * @param unsigned Unsigned value from `0` to `255`.
     */
    constructor(unsigned: Int): this((unsigned and 0xFF).toByte())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy() = copy()
}

/**
 * A tag which wraps a short value.
 * @property value The wrapped value
 */
data class NbtShort(var value: Short) : NbtTag() {
    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy() = copy()
}

/**
 * A tag which wraps an int value.
 * @property value The wrapped value
 */
data class NbtInt(var value: Int) : NbtTag() {
    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy() = copy()
}

/**
 * A tag which wraps a long value.
 * @property value The wrapped value
 */
data class NbtLong(var value: Long) : NbtTag() {
    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy() = copy()
}

/**
 * A tag which wraps a float value.
 * @property value The wrapped value
 */
data class NbtFloat(var value: Float) : NbtTag() {
    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy() = copy()
}

/**
 * A tag which wraps a double value.
 * @property value The wrapped value
 */
data class NbtDouble(var value: Double) : NbtTag() {
    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy() = copy()
}

/**
 * A tag which wraps a mutable byte array.
 * @property value The wrapped value
 */
data class NbtByteArray(var value: ByteArray): NbtTag() {
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
    override fun deepCopy() = copy(value = value.copyOf())
}

/**
 * A tag which wraps a [String] value.
 * @property value The wrapped value
 */
data class NbtString(var value: String): NbtTag() {
    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy() = copy()
}

/**
 * A tag which contains a [MutableList] structure of [NbtTag]s. All items in the list must have the same class.
 * Null values in the list are not allowed.
 * @param tags The tags that will be in this list initially. May be read-only.
 * The tags in the list will be linked so any modification will also change this tag contents.
 * @param T The type of the tag that will be wrapped. [NbtEnd] and [NbtTag] are not valid.
 */
@Suppress("UNCHECKED_CAST")
class NbtList<T: NbtTag>(tags: Collection<T>): NbtTag(), MutableList<T> by tags.toMutableList() {
    /**
     * Creates a empty list.
     */
    constructor(): this(emptyList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    constructor(vararg tags: T): this(tags.toList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    constructor(tags: Iterable<T>): this(tags.toList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    constructor(tags: Sequence<T>): this(tags.toList())

    /**
     * Returns a new NbtList with all nested values copied deeply.
     */
    override fun deepCopy() = NbtList(map { it.deepCopy() as T })
}

private inline fun <reified Nbt: NbtTag> NbtList<*>.cast(): NbtList<Nbt> {
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

private const val BYTE_TRUE: Byte = 1

/**
 * A tag which contains a [MutableMap] structure associating [String]s to [NbtTag]s.
 *
 * It's the main heart of NBT files and usually contains complex structures.
 *
 * @param value A [Map] which contains all key-value mappings.
 * The tags in the map will be linked so any modification will also change this tag contents.
 *
 * The returned tags by this class will be linked, so modifications to it will also affects the compound value.
 * 
 * All get functions which are not prefixed with `Nullable` and [NbtCompound.get] will throw a [ClassCastException]
 * if the tag is mapped to a different class then the method used. For example if a given compound
 * have a example=NbtInt(2) and you try to read it using [NbtCompound.getShort], an exception will be thrown.
 *
 * All get functions which are not prefixed with `Nullable` and [NbtCompound.get] will throw [TypeCastException]
 * if no value is mapped to the given name. This will change in future.
 */
class NbtCompound(value: Map<String, NbtTag>) : NbtTag(), MutableMap<String, NbtTag> by LinkedHashMap(value) {
    /**
     * Creates an empty compound.
     */
    constructor(): this(mutableMapOf())

    /**
     * Creates a compound which maps the [Pair.first] value to the [Pair.second] tag initially.
     *
     * The given tags will be linked, so modifications to them will also affects the compound value.
     */
    constructor(vararg tags: Pair<String, NbtTag>): this(mutableMapOf(*tags))

    /**
     * Directly maps a [NbtTag] to a key. The value must not be [NbtEnd].
     * The given tag will be linked, so modifications to it will also affects the compound value.
     */
    operator fun set(key: String, value: NbtTag) {
        this[key] = value
    }

    /**
     * Maps a [NbtByte] `1` if the value is `true` and `0` otherwise.
     */
    operator fun set(key: String, value: Boolean) = set(key, if (value) BYTE_TRUE else 0)
    /**
     * Maps a [NbtByte] with the given value.
     */
    operator fun set(key: String, value: Byte) = set(key, NbtByte(value))
    /**
     * Maps a [NbtShort] with the given value.
     */
    operator fun set(key: String, value: Short) = set(key, NbtShort(value))
    /**
     * Maps a [NbtInt] with the given value.
     */
    operator fun set(key: String, value: Int) = set(key, NbtInt(value))
    /**
     * Maps a [NbtLong] with the given value.
     */
    operator fun set(key: String, value: Long) = set(key, NbtLong(value))
    /**
     * Maps a [NbtFloat] with the given value.
     */
    operator fun set(key: String, value: Float) = set(key, NbtFloat(value))
    /**
     * Maps a [NbtDouble] with the given value.
     */
    operator fun set(key: String, value: Double) = set(key, NbtDouble(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    operator fun set(key: String, value: ByteArray) = set(key, NbtByteArray(value))
    /**
     * Maps a [NbtDouble] with the given value.
     */
    operator fun set(key: String, value: String) = set(key, NbtString(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    operator fun set(key: String, value: IntArray) = set(key, NbtIntArray(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    operator fun set(key: String, value: LongArray) = set(key, NbtLongArray(value))

    /**
     * Returns `true` if [getByte] returns `1`, `false` otherwise.
     * Will also return `false` if the value is not mapped.
     */
    fun getNullableBooleanByte(key: String) = getNullableByte(key) == BYTE_TRUE
    /**
     * Returns `true` if [getByte] returns `1`, `false` otherwise.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     * @throws TypeCastException If no value exists for that key
     */
    fun getBooleanByte(key: String) = getByte(key) == BYTE_TRUE

    /**
     * Returns the unwrapped byte value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     * @throws TypeCastException If no value exists for that key
     */
    fun getByte(key: String) = (this[key] as NbtByte).value
    /**
     * Returns the unwrapped short value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtShort]
     * @throws TypeCastException If no value exists for that key
     */
    fun getShort(key: String) = (this[key] as NbtShort).value
    /**
     * Returns the unwrapped int value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtInt]
     * @throws TypeCastException If no value exists for that key
     */
    fun getInt(key: String) = (this[key] as NbtInt).value
    /**
     * Returns the unwrapped long value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     * @throws TypeCastException If no value exists for that key
     */
    fun getLong(key: String) = (this[key] as NbtLong).value
    /**
     * Returns the unwrapped float value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtFloat]
     * @throws TypeCastException If no value exists for that key
     */
    fun getFloat(key: String) = (this[key] as NbtFloat).value
    /**
     * Returns the unwrapped double value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtDouble]
     * @throws TypeCastException If no value exists for that key
     */
    fun getDouble(key: String) = (this[key] as NbtDouble).value
    /**
     * Returns the unwrapped byte array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByteArray]
     * @throws TypeCastException If no value exists for that key
     */
    fun getByteArray(key: String) = (this[key] as NbtByteArray).value
    /**
     * Returns the unwrapped string value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtString]
     * @throws TypeCastException If no value exists for that key
     */
    fun getString(key: String) = (this[key] as NbtString).value
    /**
     * Returns the unwrapped int array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtIntArray]
     * @throws TypeCastException If no value exists for that key
     */
    fun getIntArray(key: String) = (this[key] as NbtIntArray).value
    /**
     * Returns the unwrapped long array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     * @throws TypeCastException If no value exists for that key
     */
    fun getLongArray(key: String) = (this[key] as NbtLongArray).value
    /**
     * Returns the [NbtCompound] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtCompound]
     * @throws TypeCastException If no value exists for that key
     */
    fun getCompound(key: String) = this[key] as NbtCompound
    /**
     * Returns the [NbtList] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     */
    fun getList(key: String) = this[key] as NbtList<*>

    /**
     * Returns the [NbtList] of bytes mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByte]
     */
    fun getByteList(key: String) = getList(key).cast<NbtByte>()
    /**
     * Returns the [NbtList] of shorts mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtShort]
     */
    fun getShortList(key: String) = getList(key).cast<NbtShort>()
    /**
     * Returns the [NbtList] of integers mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    fun getIntList(key: String) = getList(key).cast<NbtInt>()
    /**
     * Returns the [NbtList] of longs mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLong]
     */
    fun getLongList(key: String) = getList(key).cast<NbtLong>()
    /**
     * Returns the [NbtList] of floats mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtFloat]
     */
    fun getFloatList(key: String) = getList(key).cast<NbtFloat>()
    /**
     * Returns the [NbtList] of doubles mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtDouble]
     */
    fun getDoubleList(key: String) = getList(key).cast<NbtDouble>()
    /**
     * Returns the [NbtList] of byte arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByteArray]
     */
    fun getByteArrayList(key: String) = getList(key).cast<NbtByteArray>()
    /**
     * Returns the [NbtList] of strings mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtString]
     */
    fun getStringList(key: String) = getList(key).cast<NbtString>()
    /**
     * Returns the [NbtList] of int arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    fun getIntArrayList(key: String) = getList(key).cast<NbtIntArray>()
    /**
     * Returns the [NbtList] of long arrays mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLongArray]
     */
    fun getLongArrayList(key: String) = getList(key).cast<NbtLongArray>()
    /**
     * Returns the [NbtList] of compounds mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtCompound]
     */
    fun getCompoundList(key: String) = getList(key).cast<NbtCompound>()
    /**
     * Returns the [NbtList] of lists mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that key
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtList]
     */
    fun getListOfList(key: String) = getList(key).cast<NbtList<*>>()

    /**
     * Returns the unwrapped byte value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableByte(key: String) = (this[key] as? NbtByte)?.value
    /**
     * Returns the unwrapped short value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableShort(key: String) = (this[key] as? NbtShort)?.value
    /**
     * Returns the unwrapped int value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableInt(key: String) = (this[key] as? NbtInt)?.value
    /**
     * Returns the unwrapped long value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableLong(key: String) = (this[key] as? NbtLong)?.value
    /**
     * Returns the unwrapped float value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableFloat(key: String) = (this[key] as? NbtFloat)?.value
    /**
     * Returns the unwrapped double value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableDouble(key: String) = (this[key] as? NbtDouble)?.value
    /**
     * Returns the unwrapped byte array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableByteArray(key: String) = (this[key] as? NbtByteArray)?.value
    /**
     * Returns the unwrapped string value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableString(key: String) = (this[key] as? NbtString)?.value
    /**
     * Returns the unwrapped int array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableIntArray(key: String) = (this[key] as? NbtIntArray)?.value
    /**
     * Returns the unwrapped long array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableLongArray(key: String) = (this[key] as? NbtLongArray)?.value
    /**
     * Returns the [NbtCompound] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableCompound(key: String) = this[key] as? NbtCompound
    /**
     * Returns the [NbtList] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableList(key: String) = this[key] as? NbtList<*>

    /**
     * Returns the [NbtList] of bytes mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByte]
     */
    fun getNullableByteList(key: String) = getNullableList(key)?.cast<NbtByte>()
    /**
     * Returns the [NbtList] of shorts mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtShort]
     */
    fun getNullableShortList(key: String) = getNullableList(key)?.cast<NbtShort>()
    /**
     * Returns the [NbtList] of integers mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    fun getNullableIntList(key: String) = getNullableList(key)?.cast<NbtInt>()
    /**
     * Returns the [NbtList] of longs mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLong]
     */
    fun getNullableLongList(key: String) = getNullableList(key)?.cast<NbtLong>()
    /**
     * Returns the [NbtList] of floats mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtFloat]
     */
    fun getNullableFloatList(key: String) = getNullableList(key)?.cast<NbtFloat>()
    /**
     * Returns the [NbtList] of doubles mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtDouble]
     */
    fun getNullableDoubleList(key: String) = getNullableList(key)?.cast<NbtDouble>()
    /**
     * Returns the [NbtList] of byte arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByteArray]
     */
    fun getNullableByteArrayList(key: String) = getNullableList(key)?.cast<NbtByteArray>()
    /**
     * Returns the [NbtList] of strings mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtString]
     */
    fun getNullableStringList(key: String) = getNullableList(key)?.cast<NbtString>()
    /**
     * Returns the [NbtList] of int arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    fun getNullableIntArrayList(key: String) = getNullableList(key)?.cast<NbtIntArray>()
    /**
     * Returns the [NbtList] of long arrays mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLongArray]
     */
    fun getNullableLongArrayList(key: String) = getNullableList(key)?.cast<NbtLongArray>()
    /**
     * Returns the [NbtList] of compounds mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtCompound]
     */
    fun getNullableCompoundList(key: String) = getNullableList(key)?.cast<NbtCompound>()
    /**
     * Returns the [NbtList] of lists mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtList]
     */
    fun getNullableListOfList(key: String) = getNullableList(key)?.cast<NbtList<*>>()

    /**
     * Checks if the other compound have a given tag, if it has then place it in this compound.
     *
     * The tag will be linked, so any change in the tag will also affect both compounds.
     * @param other The compound that will be checked
     * @param tagKey The name of the tag that will be mapped
     * @param default If the other compound doesn't have the tag then this parameter will be used.
     */
    fun copyFrom(other: NbtCompound, tagKey: String, default: NbtTag? = null) {
        val tag = other[tagKey] ?: default
        if (tag != null) {
            this[tagKey] = tag
        }
    }

    /**
     * Checks if the this compound have a given tag, if it has then place it in the other compound.
     *
     * The tag will be linked, so any change in the tag will also affect both compounds.
     * @param other The compound that will be modified
     * @param tagKey The name of the tag that will be mapped
     * @param default If the this compound doesn't have the tag then this parameter will be used.
     */
    fun copyTo(other: NbtCompound, tagKey: String, default: NbtTag? = null) {
        val tag = this[tagKey] ?: default
        if (tag != null) {
            other[tagKey] = tag
        }
    }

    override fun deepCopy() = NbtCompound(mapValues { it.value.deepCopy() })
}

/**
 * A tag which wraps a mutable int array.
 * @property value The wrapped value
 */
data class NbtIntArray(var value: IntArray): NbtTag() {
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

    override fun deepCopy() = copy(value = value.copyOf())
}

/**
 * A tag which wraps a mutable long array.
 * @property value The wrapped value
 */
data class NbtLongArray(var value: LongArray) : NbtTag() {
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

    override fun deepCopy() = copy(value = value.copyOf())
}
