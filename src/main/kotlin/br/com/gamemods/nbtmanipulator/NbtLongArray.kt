package br.com.gamemods.nbtmanipulator

/**
 * A tag which wraps a mutable long array.
 * @property value The wrapped value
 */
public data class NbtLongArray(var value: LongArray) : NbtTag() {
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
    public constructor(): this(longArrayOf())

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * @param value A string with a structure like `[0, -32, 48, 127]`
     *
     * @throws IllegalArgumentException if the string does not have the exact format outputted by [stringValue]
     */
    @Throws(IllegalArgumentException::class)
    public constructor(value: String): this(value
        .removeSurrounding("[", "]")
        .split(", ")
        .takeIf { it.size > 1 || it.firstOrNull()?.isNotEmpty() == true }
        ?.map { it.toLong() }
        ?.toLongArray()
        ?: longArrayOf()
    )

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
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
    override fun deepCopy(): NbtLongArray = copy(value = value.copyOf())
}
