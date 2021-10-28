package br.com.gamemods.nbtmanipulator

/**
 * A special tag which indicates the end of a compound stream or empty lists.
 *
 * Should not be used directly.
 */
public object NbtEnd : NbtTag() {
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
    override fun deepCopy(): NbtEnd = NbtEnd
}
