//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtLongArray](index.md)/[NbtLongArray](-nbt-long-array.md)

# NbtLongArray

[jvm]\
fun [NbtLongArray](-nbt-long-array.md)()

Creates a new tag with an empty array.

[jvm]\
fun [NbtLongArray](-nbt-long-array.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Parses the string using the same structure which is returned by [stringValue](string-value.md).

## Parameters

jvm

| | |
|---|---|
| value | A string with a structure like [0, -32, 48, 127] |

## Throws

| | |
|---|---|
| [kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | if the string does not have the exact format outputted by [stringValue](string-value.md) |

[jvm]\
fun [NbtLongArray](-nbt-long-array.md)(value: [LongArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html))
