//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtFloat](index.md)

# NbtFloat

[jvm]\
data class [NbtFloat](index.md)(**value**: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)) : [NbtTag](../-nbt-tag/index.md)

A tag which wraps a float value.

## Constructors

| | |
|---|---|
| [NbtFloat](-nbt-float.md) | [jvm]<br>fun [NbtFloat](-nbt-float.md)(signed: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Parses the string value as a signed float and wraps it. |
| [NbtFloat](-nbt-float.md) | [jvm]<br>fun [NbtFloat](-nbt-float.md)(value: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [deepCopy](deep-copy.md) | [jvm]<br>open override fun [deepCopy](deep-copy.md)(): [NbtFloat](index.md)<br>Returns a new wrapper with the current value. |
| [toString](../-nbt-tag/to-string.md) | [jvm]<br>override fun [toString](../-nbt-tag/to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A technical string representation of this tag, containing the tag type and it's value, appropriated for developer inspections. |

## Properties

| Name | Summary |
|---|---|
| [stringValue](string-value.md) | [jvm]<br>open override val [stringValue](string-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a string representation of the tag's value. |
| [value](value.md) | [jvm]<br>var [value](value.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>The wrapped value |
