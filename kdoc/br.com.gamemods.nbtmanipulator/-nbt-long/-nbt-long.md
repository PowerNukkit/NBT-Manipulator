//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtLong](index.md)/[NbtLong](-nbt-long.md)

# NbtLong

[jvm]\
fun [NbtLong](-nbt-long.md)(signed: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Parses the string value as a signed long and wraps it.

## Parameters

jvm

| | |
|---|---|
| signed | Signed value from -9223372036854775808 to 9223372036854775807. |

## Throws

| | |
|---|---|
| [kotlin.NumberFormatException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number-format-exception/index.html) | if the number is not within a valid range or if the string does not contain a valid number. |

[jvm]\
fun [NbtLong](-nbt-long.md)(value: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))
