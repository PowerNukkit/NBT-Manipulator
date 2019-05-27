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
sealed class NbtTag

/**
 * A special tag which indicates the end of a compound stream or empty lists.
 *
 * Should not be used directly.
 */
object NbtEnd : NbtTag()

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
}

/**
 * A tag which wraps a short value.
 * @property value The wrapped value
 */
data class NbtShort(var value: Short) : NbtTag()

/**
 * A tag which wraps an int value.
 * @property value The wrapped value
 */
data class NbtInt(var value: Int) : NbtTag()

/**
 * A tag which wraps a long value.
 * @property value The wrapped value
 */
data class NbtLong(var value: Long) : NbtTag()

/**
 * A tag which wraps a float value.
 * @property value The wrapped value
 */
data class NbtFloat(var value: Float) : NbtTag()

/**
 * A tag which wraps a double value.
 * @property value The wrapped value
 */
data class NbtDouble(var value: Double) : NbtTag()

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
}

/**
 * A tag which wraps a [String] value.
 * @property value The wrapped value
 */
data class NbtString(var value: String): NbtTag()

/**
 * A tag which wraps a mutable list of [NbtTag]s. All items in the list must have the same class.
 * Null values in the list are not allowed.
 * @property value The wrapped mutable list. It must implement all optional methods.
 * The list instance will be linked so any modification will also change the tag value.
 * @param T The type of the tag that will be wrapped. [NbtEnd] and [NbtTag] are not valid.
 */
data class NbtList<T: NbtTag>(var value: MutableList<T>): NbtTag() {
    /**
     * Creates a tag with an empty mutable list.
     */
    constructor(): this(mutableListOf())

    /**
     * Converts the array into a mutable list and wraps it. Make sure to use the same class in all values.
     */
    constructor(vararg tags: T): this(tags.toMutableList())
}

/**
 * Creates a new mutable list based on the given list and then wrappers it into a [NbtList].
 */
@Suppress("FunctionName")
@JvmName("cloneListToNbtList")
fun <T: NbtTag> NbtList(list: List<T>) = NbtList(list.toMutableList())

private inline fun <reified Nbt: NbtTag> NbtList<*>.cast(): NbtList<Nbt> {
    /*check(Nbt::class == NbtTag::class) {
        "NbtTag is not a valid type for NbtList"
    }*/

    if (value.isNotEmpty()) {
        check(value.first()::class == Nbt::class) {
            "Cannot use this list as NbtList<${Nbt::class.simpleName}>"
        }
    }

    @Suppress("UNCHECKED_CAST")
    return this as NbtList<Nbt>
}

private const val BYTE_TRUE: Byte = 1

/**
 * A key-value mapping tag similar to [MutableMap].
 *
 * It's the main heart of NBT files and usually contains complex structures.
 *
 * @property value The wrapped [MutableMap] which contains all key-value mappings.
 * The map instance will be linked so any modification will also change the tag mappings.
 *
 * All get functions which are not prefixed with `Nullable` and [NbtCompound.get] will throw a [ClassCastException]
 * if the tag is mapped to a different class then the method used. For example if a given compound
 * have a example=NbtInt(2) and you try to read it using [NbtCompound.getShort], an exception will be thrown.
 *
 * All get functions which are not prefixed with `Nullable` and [NbtCompound.get] will throw [TypeCastException]
 * if no value is mapped to the given name. This will change in future.
 */
data class NbtCompound(var value: MutableMap<String, NbtTag>) : NbtTag() {
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
     * Simple access to the [MutableMap], will return a [NbtTag] if there's a value for that key.
     *
     * The returned tag will be linked, so modifications to it will also affects the compound value.
     */
    operator fun get(name: String) = value[name]

    /**
     * Directly maps a [NbtTag] to a key. The value must not be [NbtEnd].
     * The given tag will be linked, so modifications to it will also affects the compound value.
     */
    operator fun set(name: String, value: NbtTag) {
        this.value[name] = value
    }

    /**
     * Maps a [NbtByte] `1` if the value is `true` and `0` otherwise.
     */
    operator fun set(name: String, value: Boolean) = set(name, if (value) BYTE_TRUE else 0)
    /**
     * Maps a [NbtByte] with the given value.
     */
    operator fun set(name: String, value: Byte) = set(name, NbtByte(value))
    /**
     * Maps a [NbtShort] with the given value.
     */
    operator fun set(name: String, value: Short) = set(name, NbtShort(value))
    /**
     * Maps a [NbtInt] with the given value.
     */
    operator fun set(name: String, value: Int) = set(name, NbtInt(value))
    /**
     * Maps a [NbtLong] with the given value.
     */
    operator fun set(name: String, value: Long) = set(name, NbtLong(value))
    /**
     * Maps a [NbtFloat] with the given value.
     */
    operator fun set(name: String, value: Float) = set(name, NbtFloat(value))
    /**
     * Maps a [NbtDouble] with the given value.
     */
    operator fun set(name: String, value: Double) = set(name, NbtDouble(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    operator fun set(name: String, value: ByteArray) = set(name, NbtByteArray(value))
    /**
     * Maps a [NbtDouble] with the given value.
     */
    operator fun set(name: String, value: String) = set(name, NbtString(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    operator fun set(name: String, value: IntArray) = set(name, NbtIntArray(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    operator fun set(name: String, value: LongArray) = set(name, NbtLongArray(value))

    /**
     * Removes a mapping if it exists.
     */
    fun remove(name: String): NbtTag? = value.remove(name)

    /**
     * Removes a mapping if the current mapping maps to the expected value
     */
    fun remove(name: String, expectedValue: NbtTag) = value.remove(name, expectedValue)

    /**
     * Removes a mapping if it exists.
     */
    @JvmSynthetic
    operator fun minusAssign(name: String) {
        remove(name)
    }

    /**
     * Returns `true` if [getByte] returns `1`, `false` otherwise.
     * Will also return `false` if the value is not mapped.
     */
    fun getNullableBooleanByte(name: String) = getNullableByte(name) == BYTE_TRUE
    /**
     * Returns `true` if [getByte] returns `1`, `false` otherwise.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     * @throws TypeCastException If no value exists for that name
     */
    fun getBooleanByte(name: String) = getByte(name) == BYTE_TRUE

    /**
     * Returns the unwrapped byte value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     * @throws TypeCastException If no value exists for that name
     */
    fun getByte(name: String) = (value[name] as NbtByte).value
    /**
     * Returns the unwrapped short value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtShort]
     * @throws TypeCastException If no value exists for that name
     */
    fun getShort(name: String) = (value[name] as NbtShort).value
    /**
     * Returns the unwrapped int value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtInt]
     * @throws TypeCastException If no value exists for that name
     */
    fun getInt(name: String) = (value[name] as NbtInt).value
    /**
     * Returns the unwrapped long value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     * @throws TypeCastException If no value exists for that name
     */
    fun getLong(name: String) = (value[name] as NbtLong).value
    /**
     * Returns the unwrapped float value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtFloat]
     * @throws TypeCastException If no value exists for that name
     */
    fun getFloat(name: String) = (value[name] as NbtFloat).value
    /**
     * Returns the unwrapped double value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtDouble]
     * @throws TypeCastException If no value exists for that name
     */
    fun getDouble(name: String) = (value[name] as NbtDouble).value
    /**
     * Returns the unwrapped byte array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByteArray]
     * @throws TypeCastException If no value exists for that name
     */
    fun getByteArray(name: String) = (value[name] as NbtByteArray).value
    /**
     * Returns the unwrapped string value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtString]
     * @throws TypeCastException If no value exists for that name
     */
    fun getString(name: String) = (value[name] as NbtString).value
    /**
     * Returns the unwrapped int array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtIntArray]
     * @throws TypeCastException If no value exists for that name
     */
    fun getIntArray(name: String) = (value[name] as NbtIntArray).value
    /**
     * Returns the unwrapped long array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     * @throws TypeCastException If no value exists for that name
     */
    fun getLongArray(name: String) = (value[name] as NbtLongArray).value
    /**
     * Returns the [NbtCompound] mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtCompound]
     * @throws TypeCastException If no value exists for that name
     */
    fun getCompound(name: String) = value[name] as NbtCompound
    /**
     * Returns the [NbtList] mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     */
    fun getList(name: String) = value[name] as NbtList<*>

    /**
     * Returns the [NbtList] of bytes mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByte]
     */
    fun getByteList(name: String) = getList(name).cast<NbtByte>()
    /**
     * Returns the [NbtList] of shorts mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtShort]
     */
    fun getShortList(name: String) = getList(name).cast<NbtShort>()
    /**
     * Returns the [NbtList] of integers mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    fun getIntList(name: String) = getList(name).cast<NbtInt>()
    /**
     * Returns the [NbtList] of longs mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLong]
     */
    fun getLongList(name: String) = getList(name).cast<NbtLong>()
    /**
     * Returns the [NbtList] of floats mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtFloat]
     */
    fun getFloatList(name: String) = getList(name).cast<NbtFloat>()
    /**
     * Returns the [NbtList] of doubles mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtDouble]
     */
    fun getDoubleList(name: String) = getList(name).cast<NbtDouble>()
    /**
     * Returns the [NbtList] of byte arrays mapped to that name. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByteArray]
     */
    fun getByteArrayList(name: String) = getList(name).cast<NbtByteArray>()
    /**
     * Returns the [NbtList] of strings mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtString]
     */
    fun getStringList(name: String) = getList(name).cast<NbtString>()
    /**
     * Returns the [NbtList] of int arrays mapped to that name. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    fun getIntArrayList(name: String) = getList(name).cast<NbtIntArray>()
    /**
     * Returns the [NbtList] of long arrays mapped to that name. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLongArray]
     */
    fun getLongArrayList(name: String) = getList(name).cast<NbtLongArray>()
    /**
     * Returns the [NbtList] of compounds mapped to that name. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtCompound]
     */
    fun getCompoundList(name: String) = getList(name).cast<NbtCompound>()
    /**
     * Returns the [NbtList] of lists mapped to that name. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws TypeCastException If no value exists for that name
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtList]
     */
    fun getListOfList(name: String) = getList(name).cast<NbtList<*>>()

    /**
     * Returns the unwrapped byte value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableByte(name: String) = (value[name] as? NbtByte)?.value
    /**
     * Returns the unwrapped short value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableShort(name: String) = (value[name] as? NbtShort)?.value
    /**
     * Returns the unwrapped int value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableInt(name: String) = (value[name] as? NbtInt)?.value
    /**
     * Returns the unwrapped long value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableLong(name: String) = (value[name] as? NbtLong)?.value
    /**
     * Returns the unwrapped float value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableFloat(name: String) = (value[name] as? NbtFloat)?.value
    /**
     * Returns the unwrapped double value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableDouble(name: String) = (value[name] as? NbtDouble)?.value
    /**
     * Returns the unwrapped byte array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableByteArray(name: String) = (value[name] as? NbtByteArray)?.value
    /**
     * Returns the unwrapped string value or null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableString(name: String) = (value[name] as? NbtString)?.value
    /**
     * Returns the unwrapped int array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableIntArray(name: String) = (value[name] as? NbtIntArray)?.value
    /**
     * Returns the unwrapped long array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableLongArray(name: String) = (value[name] as? NbtLongArray)?.value
    /**
     * Returns the [NbtCompound] mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableCompound(name: String) = value[name] as? NbtCompound
    /**
     * Returns the [NbtList] mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     */
    fun getNullableList(name: String) = value[name] as? NbtList<*>

    /**
     * Returns the [NbtList] of bytes mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByte]
     */
    fun getNullableByteList(name: String) = getNullableList(name)?.cast<NbtByte>()
    /**
     * Returns the [NbtList] of shorts mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtShort]
     */
    fun getNullableShortList(name: String) = getNullableList(name)?.cast<NbtShort>()
    /**
     * Returns the [NbtList] of integers mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    fun getNullableIntList(name: String) = getNullableList(name)?.cast<NbtInt>()
    /**
     * Returns the [NbtList] of longs mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLong]
     */
    fun getNullableLongList(name: String) = getNullableList(name)?.cast<NbtLong>()
    /**
     * Returns the [NbtList] of floats mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtFloat]
     */
    fun getNullableFloatList(name: String) = getNullableList(name)?.cast<NbtFloat>()
    /**
     * Returns the [NbtList] of doubles mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtDouble]
     */
    fun getNullableDoubleList(name: String) = getNullableList(name)?.cast<NbtDouble>()
    /**
     * Returns the [NbtList] of byte arrays mapped to that name. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByteArray]
     */
    fun getNullableByteArrayList(name: String) = getNullableList(name)?.cast<NbtByteArray>()
    /**
     * Returns the [NbtList] of strings mapped to that name. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtString]
     */
    fun getNullableStringList(name: String) = getNullableList(name)?.cast<NbtString>()
    /**
     * Returns the [NbtList] of int arrays mapped to that name. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    fun getNullableIntArrayList(name: String) = getNullableList(name)?.cast<NbtIntArray>()
    /**
     * Returns the [NbtList] of long arrays mapped to that name. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLongArray]
     */
    fun getNullableLongArrayList(name: String) = getNullableList(name)?.cast<NbtLongArray>()
    /**
     * Returns the [NbtList] of compounds mapped to that name. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtCompound]
     */
    fun getNullableCompoundList(name: String) = getNullableList(name)?.cast<NbtCompound>()
    /**
     * Returns the [NbtList] of lists mapped to that name. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtList]
     */
    fun getNullableListOfList(name: String) = getNullableList(name)?.cast<NbtList<*>>()

    /**
     * Checks if the other compound have a given tag, if it has then place it in this compound.
     *
     * The tag will be linked, so any change in the tag will also affect both compounds.
     * @param other The compound that will be checked
     * @param tagName The name of the tag that will be mapped
     * @param default If the other compound doesn't have the tag then this parameter will be used.
     */
    fun copyFrom(other: NbtCompound, tagName: String, default: NbtTag? = null) {
        val tag = other[tagName] ?: default
        if (tag != null) {
            this[tagName] = tag
        }
    }

    /**
     * Checks if the this compound have a given tag, if it has then place it in the other compound.
     *
     * The tag will be linked, so any change in the tag will also affect both compounds.
     * @param other The compound that will be modified
     * @param tagName The name of the tag that will be mapped
     * @param default If the this compound doesn't have the tag then this parameter will be used.
     */
    fun copyTo(other: NbtCompound, tagName: String, default: NbtTag? = null) {
        val tag = this[tagName] ?: default
        if (tag != null) {
            other[tagName] = tag
        }
    }
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
}
