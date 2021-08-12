//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtString](index.md)

# NbtString

[jvm]\
data class [NbtString](index.md)(**value**: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [NbtTag](../-nbt-tag/index.md)

A tag which wraps a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value.

## Constructors

| | |
|---|---|
| [NbtString](-nbt-string.md) | [jvm]<br>fun [NbtString](-nbt-string.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [deepCopy](deep-copy.md) | [jvm]<br>open override fun [deepCopy](deep-copy.md)(): [NbtString](index.md)<br>Returns a new wrapper with the current value. |
| [toString](../-nbt-tag/to-string.md) | [jvm]<br>override fun [toString](../-nbt-tag/to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A technical string representation of this tag, containing the tag type and it's value, appropriated for developer inspections. |

## Properties

| Name | Summary |
|---|---|
| [stringValue](string-value.md) | [jvm]<br>open override val [stringValue](string-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a string which is wrapped by this tag. |
| [value](value.md) | [jvm]<br>var [value](value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The wrapped value |
