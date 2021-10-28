package br.com.gamemods.nbtmanipulator

/**
 * A tag which contains a [MutableList] structure of [NbtTag]s. All children must have the same class.
 *
 * @param T The type of the tag that will be wrapped. [NbtEnd] and [NbtTag] are not valid.
 */
public class NbtList<T: NbtTag> private constructor(private val tags: ArrayList<T>): NbtTag(), MutableList<T> by tags, RandomAccess {
    /**
     * Returns a string representation of the tag's value.
     *
     * The output will be similar to a normal [List].
     *
     * The class names of the children tags will expose.
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
    public constructor(tags: Collection<T>): this(ArrayList(tags))

    /**
     * Creates an empty list.
     */
    public constructor(): this(emptyList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    public constructor(vararg tags: T): this(tags.toList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    public constructor(tags: Iterable<T>): this(tags.toList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    public constructor(tags: Sequence<T>): this(tags.toList())

    /**
     * Uses all tags as initial value of this list. Make sure to use the same class in all values.
     */
    public constructor(tags: NbtList<T>): this(tags as Collection<T>)

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * @param value A string with a structure like `[NbtInt(0), NbtInt(-32), NbtInt(48), NbtInt(127)]`
     *
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalArgumentException::class)
    public constructor(value: String): this(NbtListStringParser(value).parseList() as ArrayList<T>)

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
    override fun deepCopy(): NbtList<T> = NbtList(map {
        @Suppress("UNCHECKED_CAST")
        it.deepCopy() as T
    })

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
     * appropriated for developer inspections.
     *
     * The output will be similar to a normal [List].
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
     * Kotlin's users may call `list(1,2,3).toNbtList()` or similar methods.
     */
    public companion object {
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Byte): NbtList<NbtByte> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Short): NbtList<NbtShort> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Int): NbtList<NbtInt> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Long): NbtList<NbtLong> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Float): NbtList<NbtFloat> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Double): NbtList<NbtDouble> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: String): NbtList<NbtString> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: ByteArray): NbtList<NbtByteArray> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: IntArray): NbtList<NbtIntArray> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: LongArray): NbtList<NbtLongArray> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Map<String, NbtTag>): NbtList<NbtCompound> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun create(vararg tags: Iterable<NbtTag>): NbtList<NbtList<NbtTag>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createByteSublist(vararg tags: Iterable<Byte>): NbtList<NbtList<NbtByte>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createByteSublist(vararg tags: Array<Byte>): NbtList<NbtList<NbtByte>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createByteSublist(vararg tags: ByteArray): NbtList<NbtList<NbtByte>> = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createShortSublist(vararg tags: Iterable<Short>): NbtList<NbtList<NbtShort>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createShortSublist(vararg tags: Array<Short>): NbtList<NbtList<NbtShort>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createShortSublist(vararg tags: ShortArray): NbtList<NbtList<NbtShort>> = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createIntSublist(vararg tags: Iterable<Int>): NbtList<NbtList<NbtInt>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createIntSublist(vararg tags: Array<Int>): NbtList<NbtList<NbtInt>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createIntSublist(vararg tags: IntArray): NbtList<NbtList<NbtInt>> = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createFloatSublist(vararg tags: Iterable<Float>): NbtList<NbtList<NbtFloat>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createFloatSublist(vararg tags: Array<Float>): NbtList<NbtList<NbtFloat>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createFloatSublist(vararg tags: FloatArray): NbtList<NbtList<NbtFloat>> = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createDoubleSublist(vararg tags: Iterable<Double>): NbtList<NbtList<NbtDouble>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createDoubleSublist(vararg tags: Array<Double>): NbtList<NbtList<NbtDouble>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createDoubleSublist(vararg tags: DoubleArray): NbtList<NbtList<NbtDouble>> = tags.map { it.asIterable() }.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createStringSublist(vararg tags: Iterable<String>): NbtList<NbtList<NbtString>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createStringSublist(vararg tags: Array<String>): NbtList<NbtList<NbtString>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createCompoundSublist(vararg tags: Iterable<Map<String, NbtTag>>): NbtList<NbtList<NbtCompound>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createCompoundSublist(vararg tags: Array<Map<String, NbtTag>>): NbtList<NbtList<NbtCompound>> = tags.toNbtList()
        /**
         * Returns a [NbtList] contained all elements wrapped in the appropriated [NbtTag].
         */
        @JvmStatic
        public fun createSublist(vararg tags: Iterable<Iterable<NbtTag>>): NbtList<NbtList<NbtList<NbtTag>>> = tags.toNbtList()
    }
}
