package br.com.gamemods.nbtmanipulator

/**
 * A tag which wraps a long value.
 * @property value The wrapped value
 */
public data class NbtLong(var value: Long) : NbtTag() {
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
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toLong())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtLong = copy()
}
