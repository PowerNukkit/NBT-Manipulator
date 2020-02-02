package br.com.gamemods.nbtmanipulator

internal class NbtCompoundStringParser(value: String): ComplexNbtStringParser('{', '}', value) {

    private val result = LinkedHashMap<String, NbtTag>()

    internal fun parseCompound(): LinkedHashMap<String, NbtTag> {
        if (input.isEmpty()) {
            return result
        }

        check(endIndex == -2) {
            "Already processed."
        }

        endIndex = 0

        parseEntries()
        return result
    }

    private tailrec fun parseEntries() {
        require(input[endIndex] == '"') { "Invalid input. Expected an open quote." }
        startIndex = endIndex
        val key = parseKey()
        startIndex = endIndex + 2
        require(startIndex < input.length) { "Invalid input. Expected entry value." }
        val tag = parseTag()
        result[key] = tag
        if (tag.javaClass == NbtString::class.java) {
            endIndex += 2
        } else if (closeChar == ')') {
            endIndex++
        }
        if (endIndex < input.length) {
            require(endIndex + 3 < input.length) { "Invalid input. Expected more entries." }
            require(input.substring(endIndex, endIndex + 2) == ", ") { "Invalid input. Incorrect entry separator." }
            endIndex += 2
            parseEntries()
        }
    }

    private fun parseKey(): String {
        startIndex++
        return findClosingQuote("\"=")
    }
}
