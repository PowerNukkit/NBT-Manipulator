package br.com.gamemods.nbtmanipulator

/**
 * A tag which wraps an int value.
 * @property value The wrapped value
 */
public data class NbtInt(var value: Int) : NbtTag() {
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
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toInt())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtInt = copy()
}
