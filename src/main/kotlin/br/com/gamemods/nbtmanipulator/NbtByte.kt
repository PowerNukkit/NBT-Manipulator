package br.com.gamemods.nbtmanipulator

/**
 * A tag which wraps a byte value.
 * @property signed A signed byte from `-128` to `127`
 */
public data class NbtByte(var signed: Byte) : NbtTag() {
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
    public constructor(value: Boolean): this(if (value) BYTE_TRUE else 0)

    /**
     * Converts the int value to an unsigned byte and wraps it.
     * @param unsigned Unsigned value from `0` to `255`.
     * @throws NumberFormatException if the number is not within the 0..255 range
     */
    @Throws(NumberFormatException::class)
    public constructor(unsigned: Int): this(unsigned.let {
        if(it < 0 || it > 255) {
            throw NumberFormatException("Expected an unsigned byte of range 0 to 255. Got $it.")
        }
        it.toByte()
    })

    /**
     * Parses the string value as a signed byte and wraps it.
     * @param signed Signed value from `-128` to `127`.
     * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
     */
    @Throws(NumberFormatException::class)
    public constructor(signed: String): this(signed.toByte())

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtByte = copy()

    /**
     * A technical string representation of this tag, containing the tag type, and it's [signed] value,
     * appropriated for developer inspections.
     */
    override fun toTechnicalString(): String {
        return "NbtByte($signed)"
    }

    public companion object {
        /**
         * Parses the string value as an unsigned byte and wraps it.
         * @param unsigned Unsigned value from `0` to `255`.
         * @throws NumberFormatException if the number is not within a valid range or if the string does not contain a valid number.
         */
        @JvmStatic
        public fun unsigned(unsigned: String): NbtByte = NbtByte(unsigned = unsigned.toInt())
    }
}
