//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtTag](index.md)

# NbtTag

[jvm]\
sealed class [NbtTag](index.md)

The base class for Nbt Tags. All tag values are mutable.

Do not create new classes extending it.

## Functions

| Name | Summary |
|---|---|
| [deepCopy](deep-copy.md) | [jvm]<br>abstract fun [deepCopy](deep-copy.md)(): [NbtTag](index.md)<br>Copies all this and all nested NbtTags into new objects. |
| [toString](to-string.md) | [jvm]<br>override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A technical string representation of this tag, containing the tag type, and it's value, appropriated for developer inspections. |

## Properties

| Name | Summary |
|---|---|
| [stringValue](string-value.md) | [jvm]<br>abstract val [stringValue](string-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a string representation of the tag's value. |

## Inheritors

| Name |
|---|
| [NbtByte](../-nbt-byte/index.md) |
| [NbtByteArray](../-nbt-byte-array/index.md) |
| [NbtCompound](../-nbt-compound/index.md) |
| [NbtDouble](../-nbt-double/index.md) |
| [NbtEnd](../-nbt-end/index.md) |
| [NbtFloat](../-nbt-float/index.md) |
| [NbtInt](../-nbt-int/index.md) |
| [NbtIntArray](../-nbt-int-array/index.md) |
| [NbtList](../-nbt-list/index.md) |
| [NbtLong](../-nbt-long/index.md) |
| [NbtLongArray](../-nbt-long-array/index.md) |
| [NbtShort](../-nbt-short/index.md) |
| [NbtString](../-nbt-string/index.md) |
