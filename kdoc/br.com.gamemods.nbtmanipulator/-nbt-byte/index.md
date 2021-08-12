//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtByte](index.md)

# NbtByte

[jvm]\
data class [NbtByte](index.md)(**signed**: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)) : [NbtTag](../-nbt-tag/index.md)

A tag which wraps a byte value.

## Constructors

| | |
|---|---|
| [NbtByte](-nbt-byte.md) | [jvm]<br>fun [NbtByte](-nbt-byte.md)(value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))<br>Wraps a byte 1 if the value is true and 0 otherwise. |
| [NbtByte](-nbt-byte.md) | [jvm]<br>fun [NbtByte](-nbt-byte.md)(unsigned: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Converts the int value to an unsigned byte and wraps it. |
| [NbtByte](-nbt-byte.md) | [jvm]<br>fun [NbtByte](-nbt-byte.md)(signed: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Parses the string value as a signed byte and wraps it. |
| [NbtByte](-nbt-byte.md) | [jvm]<br>fun [NbtByte](-nbt-byte.md)(signed: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [jvm]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [deepCopy](deep-copy.md) | [jvm]<br>open override fun [deepCopy](deep-copy.md)(): [NbtByte](index.md)<br>Returns a new wrapper with the current value. |
| [toString](../-nbt-tag/to-string.md) | [jvm]<br>override fun [toString](../-nbt-tag/to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A technical string representation of this tag, containing the tag type and it's value, appropriated for developer inspections. |

## Properties

| Name | Summary |
|---|---|
| [signed](signed.md) | [jvm]<br>var [signed](signed.md): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)<br>A signed byte from -128 to 127 |
| [stringValue](string-value.md) | [jvm]<br>open override val [stringValue](string-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a string representation of the tag's signed value. |
| [unsigned](unsigned.md) | [jvm]<br>var [unsigned](unsigned.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Read or write the [signed](signed.md) as a signed byte from 0 to 255. |
| [value](value.md) | [jvm]<br>~~var~~ [~~value~~](value.md)~~:~~ [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)<br>A signed byte from -128 to 127. |
