package br.com.gamemods.nbtmanipulator

/**
 * A tag which wraps a mutable byte array.
 * @property value The wrapped value
 */
public data class NbtByteArray(var value: ByteArray): NbtTag() {
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
    public constructor(): this(byteArrayOf())

    /**
     * Parses the string using the same structure which is returned by [stringValue].
     *
     * The bytes should be signed, ranging from `-127` to `127`.
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
    override fun deepCopy(): NbtByteArray = copy(value = value.copyOf())
}
