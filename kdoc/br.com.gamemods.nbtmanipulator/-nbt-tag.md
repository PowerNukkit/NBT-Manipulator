---
title: NbtTag - 
---

[br.com.gamemods.nbtmanipulator](index.html) / [NbtTag](./-nbt-tag.html)

# NbtTag

`sealed class NbtTag`

The base class for Nbt Tags. All tag values are mutable.

Do not create new classes extending it.

### Inheritors

| [NbtByte](-nbt-byte/index.html) | `data class NbtByte : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps a byte value. |
| [NbtByteArray](-nbt-byte-array/index.html) | `data class NbtByteArray : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps a mutable byte array. |
| [NbtCompound](-nbt-compound/index.html) | `data class NbtCompound : `[`NbtTag`](./-nbt-tag.html)<br>A key-value mapping tag similar to [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html). |
| [NbtDouble](-nbt-double/index.html) | `data class NbtDouble : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps a double value. |
| [NbtEnd](-nbt-end.html) | `object NbtEnd : `[`NbtTag`](./-nbt-tag.html)<br>A special tag which indicates the end of a compound stream or empty lists. |
| [NbtFloat](-nbt-float/index.html) | `data class NbtFloat : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps a float value. |
| [NbtInt](-nbt-int/index.html) | `data class NbtInt : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps an int value. |
| [NbtIntArray](-nbt-int-array/index.html) | `data class NbtIntArray : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps a mutable int array. |
| [NbtList](-nbt-list/index.html) | `data class NbtList<T : `[`NbtTag`](./-nbt-tag.html)`> : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps a mutable list of [NbtTag](./-nbt-tag.html)s. All items in the list must have the same class. Null values in the list are not allowed. |
| [NbtLong](-nbt-long/index.html) | `data class NbtLong : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps a long value. |
| [NbtLongArray](-nbt-long-array/index.html) | `data class NbtLongArray : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps a mutable long array. |
| [NbtShort](-nbt-short/index.html) | `data class NbtShort : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps a short value. |
| [NbtString](-nbt-string/index.html) | `data class NbtString : `[`NbtTag`](./-nbt-tag.html)<br>A tag which wraps a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value. |

