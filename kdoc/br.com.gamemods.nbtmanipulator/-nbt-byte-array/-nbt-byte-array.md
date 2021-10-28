//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtByteArray](index.md)/[NbtByteArray](-nbt-byte-array.md)

# NbtByteArray

[jvm]\
fun [NbtByteArray](-nbt-byte-array.md)()

Creates a new tag with an empty array.

[jvm]\
fun [NbtByteArray](-nbt-byte-array.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Parses the string using the same structure which is returned by [stringValue](string-value.md).

The bytes should be signed, ranging from -127 to 127.

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
fun [NbtByteArray](-nbt-byte-array.md)(value: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html))
