package br.com.gamemods.nbtmanipulator

/**
 * A tag which wraps a [String] value.
 * @property value The wrapped value
 */
public data class NbtString(var value: String): NbtTag() {
    /**
     * Returns a string which is wrapped by this tag.
     */
    override val stringValue: String
        get() = value

    override fun toTechnicalString(): String {
        return buildString {
            append("NbtString(\"")
            append(
                value.replace("\\", "\\\\")
                    .replace("\"", "\\\"")
            )
            append("\")")
        }
    }

    /**
     * Returns a new wrapper with the current value.
     */
    override fun deepCopy(): NbtString = copy()
}
