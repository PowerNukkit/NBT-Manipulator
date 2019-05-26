---
title: br.com.gamemods.nbtmanipulator - 
---

[br.com.gamemods.nbtmanipulator](./index.html)

## Package br.com.gamemods.nbtmanipulator

### Types

| [NbtByte](-nbt-byte/index.html) | `data class NbtByte : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps a byte value. |
| [NbtByteArray](-nbt-byte-array/index.html) | `data class NbtByteArray : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps a mutable byte array. |
| [NbtCompound](-nbt-compound/index.html) | `data class NbtCompound : `[`NbtTag`](-nbt-tag.html)<br>A key-value mapping tag similar to [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html). |
| [NbtDouble](-nbt-double/index.html) | `data class NbtDouble : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps a double value. |
| [NbtEnd](-nbt-end.html) | `object NbtEnd : `[`NbtTag`](-nbt-tag.html)<br>A special tag which indicates the end of a compound stream or empty lists. |
| [NbtFile](-nbt-file/index.html) | `data class NbtFile`<br>The root component of a file, it contains a hint for the file name and the first tag in the file. |
| [NbtFloat](-nbt-float/index.html) | `data class NbtFloat : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps a float value. |
| [NbtInt](-nbt-int/index.html) | `data class NbtInt : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps an int value. |
| [NbtIntArray](-nbt-int-array/index.html) | `data class NbtIntArray : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps a mutable int array. |
| [NbtIO](-nbt-i-o/index.html) | `object NbtIO`<br>Contains usefull methods do read and write [NbtFile](-nbt-file/index.html) from [File](https://docs.oracle.com/javase/6/docs/api/java/io/File.html) and [InputStream](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)/[OutputStream](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html). |
| [NbtList](-nbt-list/index.html) | `data class NbtList<T : `[`NbtTag`](-nbt-tag.html)`> : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps a mutable list of [NbtTag](-nbt-tag.html)s. All items in the list must have the same class. Null values in the list are not allowed. |
| [NbtLong](-nbt-long/index.html) | `data class NbtLong : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps a long value. |
| [NbtLongArray](-nbt-long-array/index.html) | `data class NbtLongArray : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps a mutable long array. |
| [NbtShort](-nbt-short/index.html) | `data class NbtShort : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps a short value. |
| [NbtString](-nbt-string/index.html) | `data class NbtString : `[`NbtTag`](-nbt-tag.html)<br>A tag which wraps a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value. |
| [NbtTag](-nbt-tag.html) | `sealed class NbtTag`<br>The base class for Nbt Tags. All tag values are mutable. |

### Functions

| [NbtList](-nbt-list.html) | `fun <T : `[`NbtTag`](-nbt-tag.html)`> NbtList(list: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`T`](-nbt-list.html#T)`>): `[`NbtList`](-nbt-list/index.html)`<`[`T`](-nbt-list.html#T)`>`<br>Creates a new mutable list based on the given list and then wrappes it into a [NbtList](-nbt-list/index.html). |

