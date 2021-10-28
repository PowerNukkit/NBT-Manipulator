//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtFloat](index.md)/[NbtFloat](-nbt-float.md)

# NbtFloat

[jvm]\
fun [NbtFloat](-nbt-float.md)(signed: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Parses the string value as a signed float and wraps it.

## Parameters

jvm

| | |
|---|---|
| signed | Signed value from 1.4e-45 to 3.4028235e+38. NaN and Infinity are also accepted. |

## Throws

| | |
|---|---|
| [kotlin.NumberFormatException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number-format-exception/index.html) | if the number is not within a valid range or if the string does not contain a valid number. |

[jvm]\
fun [NbtFloat](-nbt-float.md)(value: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html))
