//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtDouble](index.md)/[NbtDouble](-nbt-double.md)

# NbtDouble

[jvm]\
fun [NbtDouble](-nbt-double.md)(signed: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Parses the string value as a signed double and wraps it.

## Parameters

jvm

| | |
|---|---|
| signed | Signed value from 4.9e-324 to 1.7976931348623157e+308. NaN and Infinity are also accepted. |

#### Throws

| | |
|---|---|
| [kotlin.NumberFormatException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number-format-exception/index.html) | if the number is not within a valid range or if the string does not contains a valid number. |

[jvm]\
fun [NbtDouble](-nbt-double.md)(value: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))
