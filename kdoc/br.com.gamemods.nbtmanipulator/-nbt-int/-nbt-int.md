//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtInt](index.md)/[NbtInt](-nbt-int.md)

# NbtInt

[jvm]\
fun [NbtInt](-nbt-int.md)(signed: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Parses the string value as a signed int and wraps it.

## Parameters

jvm

| | |
|---|---|
| signed | Signed value from -2147483648 to 2147483647. |

## Throws

| | |
|---|---|
| [kotlin.NumberFormatException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number-format-exception/index.html) | if the number is not within a valid range or if the string does not contain a valid number. |

[jvm]\
fun [NbtInt](-nbt-int.md)(value: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))
