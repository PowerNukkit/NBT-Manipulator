package br.com.gamemods.nbtmanipulator

internal abstract class ComplexNbtStringParser(fatherOpenChar: Char, fatherCloseChar: Char, input: String) {
    protected val input = input.let {
        require(it.isNotEmpty() && it.first() == fatherOpenChar && it.last() == fatherCloseChar) {
            "Invalid input. Missing open and close chars."
        }
        it.removeSurrounding(fatherOpenChar.toString(), fatherCloseChar.toString())
    }

    protected var startIndex = 0
    protected lateinit var type: String
    protected lateinit var constructor: (String) -> NbtTag
    protected var openChar = '\u0000'
    protected var closeChar = '\u0000'
    protected var endIndex = -2

    protected var openBlocks = 0
    protected var openString = false
    private val scanChars = charArrayOf('"', openChar, closeChar)

    protected fun parseBeginning() {
        val startingAt = startIndex
        startIndex = input.indexOfAny(charArrayOf('(', '[', '{'), startingAt).also {
            require(it > 0) { "Invalid input. Unable to determine the beginning of the next tag" }
        }

        type = input.substring(startingAt, startIndex)
        constructor =
            requireNotNull(constructors[type]) {
                "Invalid input. Unexpected children tag type: $type"
            }

        openChar =
            if (type == "NbtList" || type.endsWith("Array")) '['
            else if (type == "NbtCompound") '{'
            else '('

        closeChar =
            if (type == "NbtList" || type.endsWith("Array")) ']'
            else if (type == "NbtCompound") '}'
            else ')'

        scanChars[1] = openChar
        scanChars[2] = closeChar
    }

    protected fun parseTag(): NbtTag {
        parseBeginning()

        return when(type) {
            "NbtByteArray", "NbtIntArray", "NbtLongArray" -> parseTag(includeSurrounding = true)
            "NbtString" -> parseStringTag()
            "NbtList", "NbtCompound" -> parseTag(includeSurrounding = true, father = true)
            else -> parseTag(includeSurrounding = false)
        }
    }

    protected tailrec fun findClosingQuote(closingQuote: String, startIndex: Int = this.startIndex): String {
        endIndex = input.indexOf(closingQuote, startIndex)
        require(endIndex >= startIndex) { "Invalid input. Wrong string format." }
        if (input[endIndex - 1] == '\\') {
            val newStart = endIndex + closingQuote.length
            require(newStart < input.length) { "Invalid input. A string is not closed." }
            return findClosingQuote(closingQuote, newStart)
        }
        return input.substring(this.startIndex, endIndex)
            .replace("\\\"", "\"")
            .replace("\\\\", "\\")
    }

    protected fun parseStringTag(): NbtString {
        startIndex += 2
        return NbtString(findClosingQuote("\")"))
    }

    protected fun parseTag(includeSurrounding: Boolean, father: Boolean = false): NbtTag {
        if (includeSurrounding) {
            if (father) {
                openBlocks++
                endIndex = startIndex
                require(endIndex + 1 < input.length) { "Invalid input. Unexpected ending." }
                findTheCloseBracket()
            } else {
                endIndex = input.indexOf(closeChar, startIndex + 1)
            }
            require(endIndex >= startIndex + 1) { "Invalid input. Unexpected ending." }
            endIndex++
        } else {
            startIndex++
            endIndex = input.indexOf(closeChar, startIndex)
            require(endIndex > startIndex) { "Invalid input. Unexpected ending." }
        }
        try {
            return constructor(input.substring(startIndex, endIndex))
        } catch (e: Exception) {
            throw IllegalArgumentException("Invalid input. Failed to create an instance of a child tag.", e)
        }
    }

    protected tailrec fun findTheCloseBracket() {
        val index = input.indexOfAny(scanChars, endIndex + 1)
        require(index > endIndex) { "Invalid input. Could not find the close bracket." }
        endIndex = index
        when (input[index]) {
            openChar -> {
                if (!openString) {
                    openBlocks++
                }
            }
            closeChar -> {
                if (!openString && --openBlocks == 0) {
                    return
                }
            }
            '"' -> {
                when(input[index - 1]) {
                    '(' -> {
                        require(!openString) { "Invalid input. Unbalanced string tag." }
                        openString = true
                    }
                    '\\' -> {
                        require(openString) { "Invalid input. Unexpected escaped quotes." }
                    }
                    else -> {
                        require(index + 1 < input.length) { "Invalid input. Premature input ending." }
                        when (input[index + 1]) {
                            ')', '=' -> {
                                require(openString) { "Invalid input. Unbalanced string tag." }
                                openString = false
                                endIndex++
                            }
                            else -> {
                                require(!openString) { "Invalid input. Unbalanced string tag." }
                                openString = true
                            }
                        }
                    }
                }
            }
        }
        findTheCloseBracket()
    }

    private companion object {
        private val constructors = mapOf(
            "NbtByte" to ::NbtByte,
            "NbtShort" to ::NbtShort,
            "NbtInt" to ::NbtInt,
            "NbtLong" to ::NbtLong,
            "NbtFloat" to ::NbtFloat,
            "NbtDouble" to ::NbtDouble,
            "NbtByteArray" to { value: String -> NbtByteArray(value) },
            "NbtString" to ::NbtString,
            "NbtList" to { value: String -> NbtList<NbtTag>(value) },
            "NbtCompound" to { value: String -> NbtCompound(value) },
            "NbtIntArray" to { value: String -> NbtIntArray(value) },
            "NbtLongArray" to { value: String -> NbtLongArray(value) }
        )
    }
}
