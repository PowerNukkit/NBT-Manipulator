package br.com.gamemods.nbtmanipulator

/**
 * A tag which wraps a float value.
 * @property value The wrapped value
 */
public data class NbtFloat(var value: Float) : NbtTag() {
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
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toFloat())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtFloat = copy()
}
