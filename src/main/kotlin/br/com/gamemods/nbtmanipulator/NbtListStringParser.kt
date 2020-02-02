package br.com.gamemods.nbtmanipulator

internal class NbtListStringParser(value: String): ComplexNbtStringParser('[', ']', value) {

    private val result = ArrayList<NbtTag>()

    internal fun parseList(): ArrayList<NbtTag> {
        if (input.isEmpty()) {
            return result
        }

        check(endIndex == -2) {
            "Already processed."
        }

        parseBeginning()

        return when(type) {
            "NbtByteArray", "NbtIntArray", "NbtLongArray" -> parse(includeSurrounding = true)
            "NbtString" -> parseStringList()
            "NbtList", "NbtCompound" -> parse(includeSurrounding = true, father = true)
            else -> parse(includeSurrounding = false)
        }
    }

    private tailrec fun parse(includeSurrounding: Boolean, father: Boolean = false): ArrayList<NbtTag> {
        val tag = parseTag(includeSurrounding, father)
        result += tag
        if (!includeSurrounding) {
            endIndex++
        }
        if (endIndex < input.length) {
            startIndex = input.indexOf(openChar, endIndex)
            require(startIndex > 0) { "Invalid input: $input" }
            require(input.substring(endIndex, startIndex) == ", $type") {
                "Invalid input. NbtList can have only one type. Input: $input"
            }
            return parse(includeSurrounding, father)
        }
        return result
    }

    private tailrec fun parseStrings() {
        result += parseStringTag()
        endIndex += 2
        if (endIndex < input.length) {
            startIndex = input.indexOf("(\"", endIndex)
            require(startIndex > 0) { "Invalid input. Expected more strings." }
            val mid = input.substring(endIndex, startIndex)
            val newType = mid.substring(2)
            require(", $type" == mid) {
                "Invalid input. NbtList can have only one type. Tried to add a tag of $newType to a list of $type"
            }
            parseStrings()
        }
    }

    private fun parseStringList(): ArrayList<NbtTag> {
        require(startIndex + 3 < input.length) {
            "Invalid input. Unexpected string format. Too short."
        }
        require(input[startIndex + 1] == '"') {
            "Invalid input. Unexpected string format. No quotes."
        }

        parseStrings()
        return result
    }

}
