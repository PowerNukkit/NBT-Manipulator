//[nbt-manipulator](../../../../index.md)/[br.com.gamemods.nbtmanipulator](../../index.md)/[NbtByte](../index.md)/[Companion](index.md)/[unsigned](unsigned.md)

# unsigned

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [unsigned](unsigned.md)(unsigned: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NbtByte](../index.md)

Parses the string value as an unsigned byte and wraps it.

## Parameters

jvm

| | |
|---|---|
| unsigned | Unsigned value from 0 to 255. |

#### Throws

| | |
|---|---|
| [kotlin.NumberFormatException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number-format-exception/index.html) | if the number is not within a valid range or if the string does not contains a valid number. |
