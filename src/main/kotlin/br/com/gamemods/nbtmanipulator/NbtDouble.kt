package br.com.gamemods.nbtmanipulator

/**
 * A tag which wraps a double value.
 * @property value The wrapped value
 */
public data class NbtDouble(var value: Double) : NbtTag() {
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
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toDouble())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtDouble = copy()
}
