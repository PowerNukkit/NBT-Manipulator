package br.com.gamemods.nbtmanipulator

/**
 * A tag which wraps a short value.
 * @property value The wrapped value
 */
public data class NbtShort(var value: Short) : NbtTag() {
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
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toShort())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtShort = copy()
}
