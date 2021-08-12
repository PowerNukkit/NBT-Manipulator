//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtEnd](index.md)

# NbtEnd

[jvm]\
object [NbtEnd](index.md) : [NbtTag](../-nbt-tag/index.md)

A special tag which indicates the end of a compound stream or empty lists.

Should not be used directly.

## Functions

| Name | Summary |
|---|---|
| [deepCopy](deep-copy.md) | [jvm]<br>open override fun [deepCopy](deep-copy.md)(): [NbtEnd](index.md)<br>Returns itself. |
| [toString](../-nbt-tag/to-string.md) | [jvm]<br>override fun [toString](../-nbt-tag/to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A technical string representation of this tag, containing the tag type and it's value, appropriated for developer inspections. |

## Properties

| Name | Summary |
|---|---|
| [stringValue](string-value.md) | [jvm]<br>open override val [stringValue](string-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns an empty string. |
