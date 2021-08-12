//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtIntArray](index.md)/[NbtIntArray](-nbt-int-array.md)

# NbtIntArray

[jvm]\
fun [NbtIntArray](-nbt-int-array.md)()

Creates a new tag with an empty array.

[jvm]\
fun [NbtIntArray](-nbt-int-array.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Parses the string using the same structure which is returned by [stringValue](string-value.md).

## Parameters

jvm

| | |
|---|---|
| value | A string with a structure like [0, -32, 48, 127] |

#### Throws

| | |
|---|---|
| [kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | if the string does not have the exact format outputted by [stringValue](string-value.md) |

[jvm]\
fun [NbtIntArray](-nbt-int-array.md)(value: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html))
