package br.com.gamemods.nbtmanipulator

/**
 * A tag which contains a [MutableMap] structure associating [String]s to [NbtTag]s.
 *
 * It's the main heart of NBT files and usually contains complex structures.
 *
 * The returned tags by this class will be linked, so modifications to it will also affect the compound value.
 *
 * All get functions which are not prefixed with `Nullable` and `get` will throw a [ClassCastException]
 * if the tag is mapped to a different class then the method used. For example if a given compound
 * have an example=NbtInt(2) and you try to read it using [NbtCompound.getShort], an exception will be thrown.
 *
 * All get functions which are not prefixed with `Nullable` and `get` will throw [NoSuchElementException]
 * if no value is mapped to the given name. This will change in the future.
 *
 * All get list functions which returns lists of specific types will throw [IllegalStateException] if the list content
 * does not match the requested type.
 *
 * @param value A [Map] which contains all key-value mappings.
 */
public class NbtCompound private constructor(private val value: LinkedHashMap<String, NbtTag>) : NbtTag(), MutableMap<String, NbtTag> by value {
    /**
     * Returns a string representation of the tag's value.
     *
     * The output will be similar to a normal [Map].
     *
     * The class names of the children will expose.
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on compounds.
     */
    override val stringValue: String
        get() = value.takeIf { it.isNotEmpty() }?.entries?.joinToString(prefix = "{", postfix = "}") { (key, tag) ->
            '"' + key.replace("\\", "\\\\").replace("\"", "\\\"") + "\"=" + tag
        } ?: "{}"

    /**
     * Creates a new compound containing the same mappings as the given [Map].
     *
     * The tags in the map will be linked so any modification will also change this tag contents.
     */
    public constructor(value: Map<String, NbtTag>): this(LinkedHashMap(value))

    /**
     * Creates an empty compound.
     */
    public constructor(): this(emptyMap())

    /**
     * Creates a compound which maps the [Pair.first] value to the [Pair.second] tag initially.
     *
     * The given tags will be linked, so modifications to them will also affect the compound value.
     */
    public constructor(vararg tags: Pair<String, NbtTag>): this(mapOf(*tags))

    /**
     * Creates a compound which maps the [Pair.first] value to the [Pair.second] tag initially.
     *
     * The given tags will be linked, so modifications to them will also affect the compound value.
     */
    public constructor(tags: Iterable<Pair<String, NbtTag>>): this(tags.toMap())

    /**
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    public constructor(value: String): this(NbtCompoundStringParser(value).parseCompound())

    /**
     * Directly maps a [NbtTag] to a key. The value must not be [NbtEnd].
     * The given tag will be linked, so modifications to it will also affect the compound value.
     */
    public operator fun set(key: String, value: NbtTag) {
        put(key, value)
    }

    /**
     * Maps a [NbtByte] `1` if the value is `true` and `0` otherwise.
     */
    public operator fun set(key: String, value: Boolean): Unit = set(key, if (value) BYTE_TRUE else 0)
    /**
     * Maps a [NbtByte] with the given value.
     */
    public operator fun set(key: String, value: Byte): Unit = set(key, NbtByte(value))
    /**
     * Maps a [NbtShort] with the given value.
     */
    public operator fun set(key: String, value: Short): Unit = set(key, NbtShort(value))
    /**
     * Maps a [NbtInt] with the given value.
     */
    public operator fun set(key: String, value: Int): Unit = set(key, NbtInt(value))
    /**
     * Maps a [NbtLong] with the given value.
     */
    public operator fun set(key: String, value: Long): Unit = set(key, NbtLong(value))
    /**
     * Maps a [NbtFloat] with the given value.
     */
    public operator fun set(key: String, value: Float): Unit = set(key, NbtFloat(value))
    /**
     * Maps a [NbtDouble] with the given value.
     */
    public operator fun set(key: String, value: Double): Unit = set(key, NbtDouble(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    public operator fun set(key: String, value: ByteArray): Unit = set(key, NbtByteArray(value))
    /**
     * Maps a [NbtDouble] with the given value.
     */
    public operator fun set(key: String, value: String): Unit = set(key, NbtString(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    public operator fun set(key: String, value: IntArray): Unit = set(key, NbtIntArray(value))
    /**
     * Maps a [NbtByteArray] with the given value. The array instance will be linked so any modification will also
     * change the tag value.
     */
    public operator fun set(key: String, value: LongArray): Unit = set(key, NbtLongArray(value))

    /**
     * Returns `true` if [getByte] returns `1`, `false` otherwise.
     * Will also return `false` if the value is not mapped.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     */
    @Throws(ClassCastException::class)
    public fun getNullableBooleanByte(key: String): Boolean = getNullableByte(key) == BYTE_TRUE
    /**
     * Returns `true` if [getByte] returns `1`, `false` otherwise.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getBooleanByte(key: String): Boolean = getByte(key) == BYTE_TRUE

    /**
     * Returns the value corresponding to the given [key], or throw an exception if such a key is not present in the compound.
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(NoSuchElementException::class)
    public fun require(key: String): NbtTag = get(key) ?: throw NoSuchElementException(key)

    /**
     * Returns the unwrapped byte value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getByte(key: String): Byte = (require(key) as NbtByte).signed
    /**
     * Returns the unwrapped short value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtShort]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getShort(key: String): Short = (require(key) as NbtShort).value
    /**
     * Returns the unwrapped int value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtInt]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getInt(key: String): Int = (require(key) as NbtInt).value
    /**
     * Returns the unwrapped long value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getLong(key: String): Long = (require(key) as NbtLong).value
    /**
     * Returns the unwrapped float value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtFloat]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getFloat(key: String): Float = (require(key) as NbtFloat).value
    /**
     * Returns the unwrapped double value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtDouble]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getDouble(key: String): Double = (require(key) as NbtDouble).value
    /**
     * Returns the unwrapped byte array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByteArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getByteArray(key: String): ByteArray = (require(key) as NbtByteArray).value
    /**
     * Returns the unwrapped string value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtString]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getString(key: String): String = (require(key) as NbtString).value
    /**
     * Returns the unwrapped int array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtIntArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getIntArray(key: String): IntArray = (require(key) as NbtIntArray).value
    /**
     * Returns the unwrapped long array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getLongArray(key: String): LongArray = (require(key) as NbtLongArray).value
    /**
     * Returns the [NbtCompound] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtCompound]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getCompound(key: String): NbtCompound = require(key) as NbtCompound
    /**
     * Returns the [NbtList] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    public fun getList(key: String): NbtList<*> = require(key) as NbtList<*>

    /**
     * Returns the [NbtList] of bytes mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByte]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getByteList(key: String): NbtList<NbtByte> = getList(key).cast()
    /**
     * Returns the [NbtList] of shorts mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtShort]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getShortList(key: String): NbtList<NbtShort> = getList(key).cast()
    /**
     * Returns the [NbtList] of integers mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getIntList(key: String): NbtList<NbtInt> = getList(key).cast()
    /**
     * Returns the [NbtList] of longs mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLong]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getLongList(key: String): NbtList<NbtLong> = getList(key).cast()
    /**
     * Returns the [NbtList] of floats mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtFloat]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getFloatList(key: String): NbtList<NbtFloat> = getList(key).cast()
    /**
     * Returns the [NbtList] of doubles mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtDouble]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getDoubleList(key: String): NbtList<NbtDouble> = getList(key).cast()
    /**
     * Returns the [NbtList] of byte arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByteArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getByteArrayList(key: String): NbtList<NbtByteArray> = getList(key).cast()
    /**
     * Returns the [NbtList] of strings mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtString]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getStringList(key: String): NbtList<NbtString> = getList(key).cast()
    /**
     * Returns the [NbtList] of int arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getIntArrayList(key: String): NbtList<NbtIntArray> = getList(key).cast()
    /**
     * Returns the [NbtList] of long arrays mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLongArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getLongArrayList(key: String): NbtList<NbtLongArray> = getList(key).cast()
    /**
     * Returns the [NbtList] of compounds mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtCompound]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getCompoundList(key: String): NbtList<NbtCompound> = getList(key).cast()
    /**
     * Returns the [NbtList] of lists mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtList]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    public fun getListOfList(key: String): NbtList<NbtList<*>> = getList(key).cast()

    /**
     * Returns the unwrapped byte value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     */
    @Throws(ClassCastException::class)
    public fun getNullableByte(key: String): Byte? = this[key]?.let { it as NbtByte }?.signed
    /**
     * Returns the unwrapped short value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtShort]
     */
    @Throws(ClassCastException::class)
    public fun getNullableShort(key: String): Short? = this[key]?.let { it as NbtShort }?.value
    /**
     * Returns the unwrapped int value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtInt]
     */
    @Throws(ClassCastException::class)
    public fun getNullableInt(key: String): Int? = this[key]?.let { it as NbtInt }?.value
    /**
     * Returns the unwrapped long value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLong]
     */
    @Throws(ClassCastException::class)
    public fun getNullableLong(key: String): Long? = this[key]?.let { it as NbtLong }?.value
    /**
     * Returns the unwrapped float value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtFloat]
     */
    @Throws(ClassCastException::class)
    public fun getNullableFloat(key: String): Float? = this[key]?.let { it as NbtFloat }?.value
    /**
     * Returns the unwrapped double value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtDouble]
     */
    @Throws(ClassCastException::class)
    public fun getNullableDouble(key: String): Double? = this[key]?.let { it as NbtDouble }?.value
    /**
     * Returns the unwrapped byte array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByteArray]
     */
    @Throws(ClassCastException::class)
    public fun getNullableByteArray(key: String): ByteArray? = this[key]?.let { it as NbtByteArray }?.value
    /**
     * Returns the unwrapped string value or null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtString]
     */
    @Throws(ClassCastException::class)
    public fun getNullableString(key: String): String? = this[key]?.let { it as NbtString }?.value
    /**
     * Returns the unwrapped int array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtIntArray]
     */
    @Throws(ClassCastException::class)
    public fun getNullableIntArray(key: String): IntArray? = this[key]?.let { it as NbtIntArray }?.value
    /**
     * Returns the unwrapped long array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     */
    @Throws(ClassCastException::class)
    public fun getNullableLongArray(key: String): LongArray? = this[key]?.let { it as NbtLongArray }?.value
    /**
     * Returns the [NbtCompound] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtCompound]
     */
    @Throws(ClassCastException::class)
    public fun getNullableCompound(key: String): NbtCompound? = this[key]?.let { it as NbtCompound }
    /**
     * Returns the [NbtList] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     */
    @Throws(ClassCastException::class)
    public fun getNullableList(key: String): NbtList<*>? = this[key]?.let { it as NbtList<*> }

    /**
     * Returns the [NbtList] of bytes mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByte]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableByteList(key: String): NbtList<NbtByte>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of shorts mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtShort]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableShortList(key: String): NbtList<NbtShort>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of integers mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableIntList(key: String): NbtList<NbtInt>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of longs mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLong]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableLongList(key: String): NbtList<NbtLong>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of floats mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtFloat]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableFloatList(key: String): NbtList<NbtFloat>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of doubles mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtDouble]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableDoubleList(key: String): NbtList<NbtDouble>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of byte arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByteArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableByteArrayList(key: String): NbtList<NbtByteArray>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of strings mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtString]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableStringList(key: String): NbtList<NbtString>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of int arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableIntArrayList(key: String): NbtList<NbtIntArray>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of long arrays mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLongArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableLongArrayList(key: String): NbtList<NbtLongArray>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of compounds mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtCompound]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableCompoundList(key: String): NbtList<NbtCompound>? = getNullableList(key)?.cast()
    /**
     * Returns the [NbtList] of lists mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped, or it is mapped to another type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtList]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    public fun getNullableListOfList(key: String): NbtList<NbtList<*>>? = getNullableList(key)?.cast()

    /**
     * Checks if the other compound have a given tag, if it has been placed it in this compound.
     *
     * The tag will be linked, so any change in the tag will also affect both compounds.
     * @param other The compound that will be checked
     * @param tagKey The name of the tag that will be mapped
     * @param default If the other compound doesn't have the tag then this parameter will be used.
     */
    public fun copyFrom(other: NbtCompound, tagKey: String, default: NbtTag? = null) {
        val tag = other[tagKey] ?: default
        if (tag != null) {
            this[tagKey] = tag
        }
    }

    /**
     * Checks if the compound have a given tag, if it has been placed it in the other compound.
     *
     * The tag will be linked, so any change in the tag will also affect both compounds.
     * @param other The compound that will be modified
     * @param tagKey The name of the tag that will be mapped
     * @param default If the compound doesn't have the tag then this parameter will be used.
     */
    public fun copyTo(other: NbtCompound, tagKey: String, default: NbtTag? = null) {
        val tag = this[tagKey] ?: default
        if (tag != null) {
            other[tagKey] = tag
        }
    }

    /**
     * Returns a new NbtCompound with all nested values copied deeply.
     */
    override fun deepCopy(): NbtCompound = NbtCompound(mapValues { it.value.deepCopy() })

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
     * appropriated for developer inspections.
     *
     * The output will be similar to a normal [Map].
     *
     * Be aware that this may be a slow operation on compounds.
     */
    override fun toTechnicalString(): String {
        if (value.isEmpty()) {
            return "NbtCompound{}"
        }
        return "NbtCompound$stringValue"
        /*return buildString {
            append("NbtCompound{")
            val iterator = value.iterator()
            while (iterator.hasNext()) {
                val (key, tag) = iterator.next()
                append(key).append('=').append(tag)
                if (iterator.hasNext()) {
                    append(", ")
                }
            }
            append('}')
        }*/
    }

    override fun equals(other: Any?): Boolean {
        return value == other
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }

}
