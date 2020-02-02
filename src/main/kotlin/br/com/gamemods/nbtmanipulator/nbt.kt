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
        @Throws(ClassCastException::class)
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
     * Returns a string representation of the tag's value.
     *
     * The [NbtList] and the array types will have an output similar to a normal [List] and [NbtCompound] to a normal [Map].
     *
     * The class names of the [NbtList]'s and [NbtCompound]'s children will exposed.
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    abstract val stringValue: String

    /**
     * Copies all this and all nested NbtTags into new objects.
     */
    abstract fun deepCopy(): NbtTag

    /**
     * A technical string representation of this tag, containing the tag type and it's value,
     * appropriated for developer inspections.
     *
     * The [NbtList] and the array types will have an output similar to a normal [List] and [NbtCompound] to a normal [Map].
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    protected open fun toTechnicalString() = "${this::class.java.simpleName}($stringValue)"

    /**
     * A technical string representation of this tag, containing the tag type and it's value,
     * appropriated for developer inspections.
     *
     * The [NbtList] and the array types will have an output similar to a normal [List] and [NbtCompound] to a normal [Map].
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    final override fun toString() = toTechnicalString()
}

/**
 * A special tag which indicates the end of a compound stream or empty lists.
 *
 * Should not be used directly.
 */
object NbtEnd : NbtTag() {
    /**
     * Returns an empty string.
     */
    override val stringValue: String
        get() = ""

    /**
     * Returns `"NbtEnd"`.
     */
    override fun toTechnicalString(): String {
        return "NbtEnd"
    }

    /**
     * Returns itself.
     */
    override fun deepCopy() = NbtEnd
}

/**
 * A tag which wraps a byte value.
 * @property signed A signed byte from `-128` to `127`
 */
data class NbtByte(var signed: Byte) : NbtTag() {
    /**
     * Read or write the [signed] as a signed byte from `0` to `255`.
     */
    var unsigned: Int
        get() = signed.toInt() and 0xFF
        set(value) {
            this.signed = (value and 0xFF).toByte()
        }

    /**
     * A signed byte from `-128` to `127`.
     */
    @Deprecated(
        "Deprecated in favor of signed and unsigned flavours. Replace with the signed property.",
        ReplaceWith("signed")
    )
    inline var value: Byte
        get() = signed
        set(value) {
            signed = value
        }

    /**
     * Returns a string representation of the tag's signed value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = signed.toString()

    /**
     * Wraps a byte `1` if the value is `true` and `0` otherwise.
     * @param value The value to be checked
     */
    constructor(value: Boolean): this(if (value) BYTE_TRUE else 0)

    /**
     * Converts the int value to an unsigned byte and wraps it.
     * @param unsigned Unsigned value from `0` to `255`.
     * @throws NumberFormatException if the number is not within the 0..255 range
     */
    @Throws(NumberFormatException::class)
    constructor(unsigned: Int): this(unsigned.let {
        if(it < 0 || it > 255) {
            throw NumberFormatException("Expected an unsigned byte of range 0 to 255. Got $it.")
        }
        it.toByte()
    })

    /**
     * Parses the string value as a signed byte and wraps it.
     * @param signed Signed value from `-128` to `127`.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contains a valid number.
     */
    @Throws(NumberFormatException::class)
    constructor(signed: String): this(signed.toByte())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy() = copy()

    /**
     * A technical string representation of this tag, containing the tag type and it's [signed] value,
     * appropriated for developer inspections.
     */
    override fun toTechnicalString(): String {
        return "NbtByte($signed)"
    }

    companion object {
        /**
         * Parses the string value as an unsigned byte and wraps it.
         * @param unsigned Unsigned value from `0` to `255`.
         * @throws NumberFormatException if the number is not within a valid range or if the string does not contains a valid number.
         */
        @JvmStatic fun unsigned(unsigned: String) = NbtByte(unsigned = unsigned.toInt())
    }
}

/**
 * A tag which wraps a short value.
 * @property value The wrapped value
 */
data class NbtShort(var value: Short) : NbtTag() {
    /**
     * Returns a string representation of the tag's value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = value.toString()

    /**
     * Parses the string value as a signed short and wraps it.
     * @param signed Signed value from `-32768` to `32767`.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contains a valid number.
     */
    @Throws(NumberFormatException::class)
    constructor(signed: String): this(signed.toShort())

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
     * Returns a string representation of the tag's value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = value.toString()

    /**
     * Parses the string value as a signed int and wraps it.
     * @param signed Signed value from `-2147483648` to `2147483647`.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contains a valid number.
     */
    @Throws(NumberFormatException::class)
    constructor(signed: String): this(signed.toInt())

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
     * Returns a string representation of the tag's value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = value.toString()

    /**
     * Parses the string value as a signed long and wraps it.
     * @param signed Signed value from `-9223372036854775808` to `9223372036854775807`.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contains a valid number.
     */
    @Throws(NumberFormatException::class)
    constructor(signed: String): this(signed.toLong())

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
     * Returns a string representation of the tag's value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = value.toString()

    /**
     * Parses the string value as a signed float and wraps it.
     * @param signed Signed value from `1.4e-45` to `3.4028235e+38`. NaN and Infinity are also accepted.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contains a valid number.
     */
    @Throws(NumberFormatException::class)
    constructor(signed: String): this(signed.toFloat())

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
     * Returns a string representation of the tag's value.
     *
     * The returned string is compatible with string constructors of the same type.
     */
    override val stringValue: String
        get() = value.toString()

    /**
     * Parses the string value as a signed double and wraps it.
     * @param signed Signed value from `4.9e-324` to `1.7976931348623157e+308`. NaN and Infinity are also accepted.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contains a valid number.
     */
    @Throws(NumberFormatException::class)
    constructor(signed: String): this(signed.toDouble())

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
     * Returns a string representation of the tag's value with a structure similar to a normal [List].
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Like [NbtByte], the bytes returned are signed, ranging from `-128` to `127`.
     *
     * Be aware that this may be a slow operation on big arrays.
     */
    override val stringValue: String
        get() = value.takeIf { it.isNotEmpty() }?.joinToString(prefix = "[", postfix = "]") ?: "[]"

    /**
     * Creates a new tag with an empty array.
     */
    constructor(): this(byteArrayOf())

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * The bytes should signed, ranging from `-127` to `127`.
     *
     * @param value A string with a structure like `[0, -32, 48, 127]`
     *
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    constructor(value: String): this(value
        .removeSurrounding("[", "]")
        .split(", ")
        .takeIf { it.size > 1 || it.firstOrNull()?.isNotEmpty() == true }
        ?.map { it.toByte() }
        ?.toByteArray()
        ?: byteArrayOf()
    )

    override fun toTechnicalString(): String {
        return "NbtByteArray$stringValue"
    }

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
     * Returns a string which is wrapped by this tag.
     */
    override val stringValue: String
        get() = value

    override fun toTechnicalString(): String {
        return buildString {
            append("NbtString(\"")
            append(
                value.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
            )
            append("\")")
        }
    }

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy() = copy()
}

/**
 * A tag which contains a [MutableList] structure of [NbtTag]s. All children must have the same class.
 *
 * @param T The type of the tag that will be wrapped. [NbtEnd] and [NbtTag] are not valid.
 */
@Suppress("UNCHECKED_CAST")
class NbtList<T: NbtTag> private constructor(private val tags: ArrayList<T>): NbtTag(), MutableList<T> by tags, RandomAccess {
    /**
     * Returns a string representation of the tag's value.
     *
     * The output will be similar to a normal [List].
     *
     * The class names of the children tags will exposed.
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    override val stringValue: String
        get() = tags.toString()

    /**
     * Constructs a [NbtList] with the same contents of the given [Collection].
     *
     * All items in the list must have the same class.
     *
     * Null values in the list are not allowed.
     *
     * The tags in the list will be linked so any modification will also change this tag contents.
     */
    constructor(tags: Collection<T>): this(ArrayList(tags))

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
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    constructor(tags: NbtList<T>): this(tags as Collection<T>)

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * @param value A string with a structure like `[NbtInt(0), NbtInt(-32), NbtInt(48), NbtInt(127)]`
     *
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    constructor(value: String): this(NbtListStringParser(value).parseList() as ArrayList<T>)

    override fun add(element: T): Boolean {
        checkTagType(element)
        return tags.add(element)
    }

    override fun add(index: Int, element: T) {
        checkTagType(element)
        return tags.add(index, element)
    }

    override fun set(index: Int, element: T): T {
        if (size > 1) {
            checkTagType(element)
        }
        return tags.set(index, element)
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<T> {
        val subList = tags.subList(fromIndex, toIndex)
        return object : MutableList<T> by subList, RandomAccess {
            override fun set(index: Int, element: T): T {
                checkTagType(element)
                return subList.set(index, element)
            }

            override fun toString(): String {
                return tags.toString()
            }

            override fun equals(other: Any?): Boolean {
                return subList == other
            }

            override fun hashCode(): Int {
                return subList.hashCode()
            }
        }
    }

    private fun checkTagType(tag: NbtTag) {
        val childrenType = firstOrNull()?.javaClass ?: return
        require(childrenType == tag.javaClass) {
            "NbtList must have all children tags of the same type. \n" +
                    "Tried to add a ${tag.javaClass.simpleName} tag in a NbtList of ${childrenType.javaClass.simpleName}"
        }
    }

    /**
     * Returns a new NbtList with all nested values copied deeply.
     */
    override fun deepCopy() = NbtList(map { it.deepCopy() as T })

    /**
     * A technical string representation of this tag, containing the tag type and it's value,
     * appropriated for developer inspections.
     *
     * The output will have be similar to a normal [List].
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    override fun toTechnicalString(): String {
        if (tags.isEmpty()) {
            return "NbtList[]"
        }
        return tags.joinToString(prefix = "NbtList[", postfix = "]")
    }

    override fun equals(other: Any?): Boolean {
        return tags == other
    }

    override fun hashCode(): Int {
        return tags.hashCode()
    }


    /**
     * Contains useful methods to create [NbtList]s from Java.
     *
     * Kotlin users may call `list(1,2,3).toNbtList()` or similar methods.
     */
    companion object {
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: Byte) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: Short) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: Int) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: Long) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: Float) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: Double) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: String) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: ByteArray) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: IntArray) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: LongArray) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: Map<String, NbtTag>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun create(vararg tags: Iterable<NbtTag>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createByteSublist(vararg tags: Iterable<Byte>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createByteSublist(vararg tags: Array<Byte>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createByteSublist(vararg tags: ByteArray) = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createShortSublist(vararg tags: Iterable<Short>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createShortSublist(vararg tags: Array<Short>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createShortSublist(vararg tags: ShortArray) = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createIntSublist(vararg tags: Iterable<Int>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createIntSublist(vararg tags: Array<Int>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createIntSublist(vararg tags: IntArray) = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createFloatSublist(vararg tags: Iterable<Float>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createFloatSublist(vararg tags: Array<Float>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createFloatSublist(vararg tags: FloatArray) = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createDoubleSublist(vararg tags: Iterable<Double>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createDoubleSublist(vararg tags: Array<Double>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createDoubleSublist(vararg tags: DoubleArray) = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createStringSublist(vararg tags: Iterable<String>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createStringSublist(vararg tags: Array<String>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createCompoundSublist(vararg tags: Iterable<Map<String, NbtTag>>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createCompoundSublist(vararg tags: Array<Map<String, NbtTag>>) = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic fun createSublist(vararg tags: Iterable<Iterable<NbtTag>>) = tags.toNbtList()
    }
}

/**
 * A tag which contains a [MutableMap] structure associating [String]s to [NbtTag]s.
 *
 * It's the main heart of NBT files and usually contains complex structures.
 *
 * The returned tags by this class will be linked, so modifications to it will also affects the compound value.
 * 
 * All get functions which are not prefixed with `Nullable` and `get` will throw a [ClassCastException]
 * if the tag is mapped to a different class then the method used. For example if a given compound
 * have a example=NbtInt(2) and you try to read it using [NbtCompound.getShort], an exception will be thrown.
 *
 * All get functions which are not prefixed with `Nullable` and `get` will throw [NoSuchElementException]
 * if no value is mapped to the given name. This will change in future.
 *
 * All get list functions which returns lists of specific types will throw [IllegalStateException] if the list content
 * does not match the requested type.
 *
 * @param value A [Map] which contains all key-value mappings.
 */
class NbtCompound private constructor(private val value: LinkedHashMap<String, NbtTag>) : NbtTag(), MutableMap<String, NbtTag> by value {
    /**
     * Returns a string representation of the tag's value.
     *
     * The output will be similar to a normal [Map].
     *
     * The class names of the children will exposed.
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
    constructor(value: Map<String, NbtTag>): this(LinkedHashMap(value))

    /**
     * Creates an empty compound.
     */
    constructor(): this(emptyMap())

    /**
     * Creates a compound which maps the [Pair.first] value to the [Pair.second] tag initially.
     *
     * The given tags will be linked, so modifications to them will also affects the compound value.
     */
    constructor(vararg tags: Pair<String, NbtTag>): this(mapOf(*tags))

    /**
     * Creates a compound which maps the [Pair.first] value to the [Pair.second] tag initially.
     *
     * The given tags will be linked, so modifications to them will also affects the compound value.
     */
    constructor(tags: Iterable<Pair<String, NbtTag>>): this(tags.toMap())

    /**
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    constructor(value: String): this(NbtCompoundStringParser(value).parseCompound())

    /**
     * Directly maps a [NbtTag] to a key. The value must not be [NbtEnd].
     * The given tag will be linked, so modifications to it will also affects the compound value.
     */
    operator fun set(key: String, value: NbtTag) {
        put(key, value)
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
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     */
    @Throws(ClassCastException::class)
    fun getNullableBooleanByte(key: String) = getNullableByte(key) == BYTE_TRUE
    /**
     * Returns `true` if [getByte] returns `1`, `false` otherwise.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getBooleanByte(key: String) = getByte(key) == BYTE_TRUE

    /**
     * Returns the value corresponding to the given [key], or throw an exception if such a key is not present in the compound.
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(NoSuchElementException::class)
    fun require(key: String) = get(key) ?: throw NoSuchElementException(key)
    
    /**
     * Returns the unwrapped byte value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getByte(key: String) = (require(key) as NbtByte).signed
    /**
     * Returns the unwrapped short value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtShort]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getShort(key: String) = (require(key) as NbtShort).value
    /**
     * Returns the unwrapped int value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtInt]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getInt(key: String) = (require(key) as NbtInt).value
    /**
     * Returns the unwrapped long value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getLong(key: String) = (require(key) as NbtLong).value
    /**
     * Returns the unwrapped float value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtFloat]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getFloat(key: String) = (require(key) as NbtFloat).value
    /**
     * Returns the unwrapped double value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtDouble]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getDouble(key: String) = (require(key) as NbtDouble).value
    /**
     * Returns the unwrapped byte array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByteArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getByteArray(key: String) = (require(key) as NbtByteArray).value
    /**
     * Returns the unwrapped string value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtString]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getString(key: String) = (require(key) as NbtString).value
    /**
     * Returns the unwrapped int array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtIntArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getIntArray(key: String) = (require(key) as NbtIntArray).value
    /**
     * Returns the unwrapped long array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getLongArray(key: String) = (require(key) as NbtLongArray).value
    /**
     * Returns the [NbtCompound] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtCompound]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getCompound(key: String) = require(key) as NbtCompound
    /**
     * Returns the [NbtList] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     */
    @Throws(ClassCastException::class, NoSuchElementException::class)
    fun getList(key: String) = require(key) as NbtList<*>

    /**
     * Returns the [NbtList] of bytes mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByte]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getByteList(key: String) = getList(key).cast<NbtByte>()
    /**
     * Returns the [NbtList] of shorts mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtShort]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getShortList(key: String) = getList(key).cast<NbtShort>()
    /**
     * Returns the [NbtList] of integers mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getIntList(key: String) = getList(key).cast<NbtInt>()
    /**
     * Returns the [NbtList] of longs mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLong]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getLongList(key: String) = getList(key).cast<NbtLong>()
    /**
     * Returns the [NbtList] of floats mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtFloat]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getFloatList(key: String) = getList(key).cast<NbtFloat>()
    /**
     * Returns the [NbtList] of doubles mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtDouble]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getDoubleList(key: String) = getList(key).cast<NbtDouble>()
    /**
     * Returns the [NbtList] of byte arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByteArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getByteArrayList(key: String) = getList(key).cast<NbtByteArray>()
    /**
     * Returns the [NbtList] of strings mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtString]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getStringList(key: String) = getList(key).cast<NbtString>()
    /**
     * Returns the [NbtList] of int arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getIntArrayList(key: String) = getList(key).cast<NbtIntArray>()
    /**
     * Returns the [NbtList] of long arrays mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLongArray]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getLongArrayList(key: String) = getList(key).cast<NbtLongArray>()
    /**
     * Returns the [NbtList] of compounds mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtCompound]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getCompoundList(key: String) = getList(key).cast<NbtCompound>()
    /**
     * Returns the [NbtList] of lists mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws NoSuchElementException If the key is not present on the compound
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtList]
     */
    @Throws(ClassCastException::class, NoSuchElementException::class, IllegalStateException::class)
    fun getListOfList(key: String) = getList(key).cast<NbtList<*>>()

    /**
     * Returns the unwrapped byte value or null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByte]
     */
    @Throws(ClassCastException::class)
    fun getNullableByte(key: String) = this[key]?.let { it as NbtByte }?.signed
    /**
     * Returns the unwrapped short value or null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtShort]
     */
    @Throws(ClassCastException::class)
    fun getNullableShort(key: String) = this[key]?.let { it as NbtShort }?.value
    /**
     * Returns the unwrapped int value or null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtInt]
     */
    @Throws(ClassCastException::class)
    fun getNullableInt(key: String) = this[key]?.let { it as NbtInt }?.value
    /**
     * Returns the unwrapped long value or null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLong]
     */
    @Throws(ClassCastException::class)
    fun getNullableLong(key: String) = this[key]?.let { it as NbtLong }?.value
    /**
     * Returns the unwrapped float value or null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtFloat]
     */
    @Throws(ClassCastException::class)
    fun getNullableFloat(key: String) = this[key]?.let { it as NbtFloat }?.value
    /**
     * Returns the unwrapped double value or null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtDouble]
     */
    @Throws(ClassCastException::class)
    fun getNullableDouble(key: String) = this[key]?.let { it as NbtDouble }?.value
    /**
     * Returns the unwrapped byte array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtByteArray]
     */
    @Throws(ClassCastException::class)
    fun getNullableByteArray(key: String) = this[key]?.let { it as NbtByteArray }?.value
    /**
     * Returns the unwrapped string value or null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtString]
     */
    @Throws(ClassCastException::class)
    fun getNullableString(key: String) = this[key]?.let { it as NbtString }?.value
    /**
     * Returns the unwrapped int array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtIntArray]
     */
    @Throws(ClassCastException::class)
    fun getNullableIntArray(key: String) = this[key]?.let { it as NbtIntArray }?.value
    /**
     * Returns the unwrapped long array value. The array will be linked and any modification will
     * also change wrapper and the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtLongArray]
     */
    @Throws(ClassCastException::class)
    fun getNullableLongArray(key: String) = this[key]?.let { it as NbtLongArray }?.value
    /**
     * Returns the [NbtCompound] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtCompound]
     */
    @Throws(ClassCastException::class)
    fun getNullableCompound(key: String) = this[key]?.let { it as NbtCompound }
    /**
     * Returns the [NbtList] mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     */
    @Throws(ClassCastException::class)
    fun getNullableList(key: String) = this[key]?.let { it as NbtList<*> }

    /**
     * Returns the [NbtList] of bytes mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByte]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableByteList(key: String) = getNullableList(key)?.cast<NbtByte>()
    /**
     * Returns the [NbtList] of shorts mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtShort]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableShortList(key: String) = getNullableList(key)?.cast<NbtShort>()
    /**
     * Returns the [NbtList] of integers mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableIntList(key: String) = getNullableList(key)?.cast<NbtInt>()
    /**
     * Returns the [NbtList] of longs mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLong]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableLongList(key: String) = getNullableList(key)?.cast<NbtLong>()
    /**
     * Returns the [NbtList] of floats mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtFloat]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableFloatList(key: String) = getNullableList(key)?.cast<NbtFloat>()
    /**
     * Returns the [NbtList] of doubles mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtDouble]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableDoubleList(key: String) = getNullableList(key)?.cast<NbtDouble>()
    /**
     * Returns the [NbtList] of byte arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtByteArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableByteArrayList(key: String) = getNullableList(key)?.cast<NbtByteArray>()
    /**
     * Returns the [NbtList] of strings mapped to that key. The tag will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtString]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableStringList(key: String) = getNullableList(key)?.cast<NbtString>()
    /**
     * Returns the [NbtList] of int arrays mapped to that key. The tag and it's value will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtIntArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableIntArrayList(key: String) = getNullableList(key)?.cast<NbtIntArray>()
    /**
     * Returns the [NbtList] of long arrays mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtLongArray]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableLongArrayList(key: String) = getNullableList(key)?.cast<NbtLongArray>()
    /**
     * Returns the [NbtList] of compounds mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtCompound]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
    fun getNullableCompoundList(key: String) = getNullableList(key)?.cast<NbtCompound>()
    /**
     * Returns the [NbtList] of lists mapped to that key. The tag and it's values will be linked and any modification will
     * also change the mapped value.
     *
     * Will return null if no value is mapped or it is mapped to an other type tag.
     * @throws ClassCastException If the [NbtTag] is not a [NbtList]
     * @throws IllegalStateException If the list is not empty and contains any tag with class different then [NbtList]
     */
    @Throws(ClassCastException::class, IllegalStateException::class)
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

    /**
     * Returns a new NbtCompound with all nested values copied deeply.
     */
    override fun deepCopy() = NbtCompound(mapValues { it.value.deepCopy() })

    /**
     * A technical string representation of this tag, containing the tag type and it's value,
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

/**
 * A tag which wraps a mutable int array.
 * @property value The wrapped value
 */
data class NbtIntArray(var value: IntArray): NbtTag() {
    /**
     * Returns a string representation of the tag's value with a structure similar to a normal [List].
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on big arrays.
     */
    override val stringValue: String
        get() = value.takeIf { it.isNotEmpty() }?.joinToString(prefix = "[", postfix = "]") ?: "[]"

    /**
     * Creates a new tag with an empty array.
     */
    constructor(): this(intArrayOf())

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * @param value A string with a structure like `[0, -32, 48, 127]`
     *
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    constructor(value: String): this(value
        .removeSurrounding("[", "]")
        .split(", ")
        .takeIf { it.size > 1 || it.firstOrNull()?.isNotEmpty() == true }
        ?.map { it.toInt() }
        ?.toIntArray()
        ?: intArrayOf()
    )

    /**
     * A technical string representation of this tag, containing the tag type and it's value,
     * appropriated for developer inspections.
     *
     * The output will be similar to a normal [List].
     *
     * Be aware that this may be a slow operation on big arrays.
     */
    override fun toTechnicalString(): String {
        return "NbtIntArray$stringValue"
    }

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

    /**
     * Returns a new wrapper with a copy of the current value.
     */
    override fun deepCopy() = copy(value = value.copyOf())
}

/**
 * A tag which wraps a mutable long array.
 * @property value The wrapped value
 */
data class NbtLongArray(var value: LongArray) : NbtTag() {
    /**
     * Returns a string representation of the tag's value with a structure similar to a normal [List].
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on big arrays.
     */
    override val stringValue: String
        get() = value.takeIf { it.isNotEmpty() }?.joinToString(prefix = "[", postfix = "]") ?: "[]"

    /**
     * Creates a new tag with an empty array.
     */
    constructor(): this(longArrayOf())

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * @param value A string with a structure like `[0, -32, 48, 127]`
     *
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    constructor(value: String): this(value
        .removeSurrounding("[", "]")
        .split(", ")
        .takeIf { it.size > 1 || it.firstOrNull()?.isNotEmpty() == true }
        ?.map { it.toLong() }
        ?.toLongArray()
        ?: longArrayOf()
    )

    /**
     * A technical string representation of this tag, containing the tag type and it's value,
     * appropriated for developer inspections.
     *
     * The output will be similar to a normal [List].
     *
     * Be aware that this may be a slow operation on big arrays.
     */
    override fun toTechnicalString(): String {
        return "NbtLongArray$stringValue"
    }

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

    /**
     * Returns a new wrapper with a copy of the current value.
     */
    override fun deepCopy() = copy(value = value.copyOf())
}
