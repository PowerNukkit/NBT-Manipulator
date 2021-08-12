//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtByte](index.md)/[NbtByte](-nbt-byte.md)

# NbtByte

[jvm]\
fun [NbtByte](-nbt-byte.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))

Wraps a byte 1 if the value is true and 0 otherwise.

## Parameters

jvm

| | |
|---|---|
| value | The value to be checked |

[jvm]\
fun [NbtByte](-nbt-byte.md)(unsigned: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))

Converts the int value to an unsigned byte and wraps it.

## Parameters

jvm

| | |
|---|---|
| unsigned | Unsigned value from 0 to 255. |

#### Throws

| | |
|---|---|
| [kotlin.NumberFormatException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number-format-exception/index.html) | if the number is not within the 0..255 range |

[jvm]\
fun [NbtByte](-nbt-byte.md)(signed: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Parses the string value as a signed byte and wraps it.

## Parameters

jvm

| | |
|---|---|
| signed | Signed value from -128 to 127. |

#### Throws

| | |
|---|---|
| [kotlin.NumberFormatException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number-format-exception/index.html) | if the number is not within a valid range or if the string does not contains a valid number. |

[jvm]\
fun [NbtByte](-nbt-byte.md)(signed: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html))
