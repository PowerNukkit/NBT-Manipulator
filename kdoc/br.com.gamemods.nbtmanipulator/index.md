[br.com.gamemods.nbtmanipulator](./index.md)

## Package br.com.gamemods.nbtmanipulator

### Types

| Name | Summary |
|---|---|
| [NbtByte](-nbt-byte/index.md) | `data class NbtByte : `[`NbtTag`](-nbt-tag/index.md)<br>A tag which wraps a byte value. |
| [NbtByteArray](-nbt-byte-array/index.md) | `data class NbtByteArray : `[`NbtTag`](-nbt-tag/index.md)<br>A tag which wraps a mutable byte array. |
| [NbtCompound](-nbt-compound/index.md) | `class NbtCompound : `[`NbtTag`](-nbt-tag/index.md)`, `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`NbtTag`](-nbt-tag/index.md)`>`<br>A tag which contains a [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html) structure associating [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)s to [NbtTag](-nbt-tag/index.md)s. |
| [NbtDouble](-nbt-double/index.md) | `data class NbtDouble : `[`NbtTag`](-nbt-tag/index.md)<br>A tag which wraps a double value. |
| [NbtEnd](-nbt-end/index.md) | `object NbtEnd : `[`NbtTag`](-nbt-tag/index.md)<br>A special tag which indicates the end of a compound stream or empty lists. |
| [NbtFile](-nbt-file/index.md) | `data class NbtFile`<br>The root component of a file, it contains a hint for the file name and the first tag in the file. |
| [NbtFloat](-nbt-float/index.md) | `data class NbtFloat : `[`NbtTag`](-nbt-tag/index.md)<br>A tag which wraps a float value. |
| [NbtInt](-nbt-int/index.md) | `data class NbtInt : `[`NbtTag`](-nbt-tag/index.md)<br>A tag which wraps an int value. |
| [NbtIntArray](-nbt-int-array/index.md) | `data class NbtIntArray : `[`NbtTag`](-nbt-tag/index.md)<br>A tag which wraps a mutable int array. |
| [NbtIO](-nbt-i-o/index.md) | `object NbtIO`<br>Contains useful methods do read and write [NbtFile](-nbt-file/index.md) from [File](https://docs.oracle.com/javase/6/docs/api/java/io/File.html) and [InputStream](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)/[OutputStream](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html). |
| [NbtList](-nbt-list/index.md) | `class NbtList<T : `[`NbtTag`](-nbt-tag/index.md)`> : `[`NbtTag`](-nbt-tag/index.md)`, `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`T`](-nbt-list/index.md#T)`>`<br>A tag which contains a [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html) structure of [NbtTag](-nbt-tag/index.md)s. All items in the list must have the same class. Null values in the list are not allowed. The tags in the list will be linked so any modification will also change this tag contents. |
| [NbtLong](-nbt-long/index.md) | `data class NbtLong : `[`NbtTag`](-nbt-tag/index.md)<br>A tag which wraps a long value. |
| [NbtLongArray](-nbt-long-array/index.md) | `data class NbtLongArray : `[`NbtTag`](-nbt-tag/index.md)<br>A tag which wraps a mutable long array. |
| [NbtShort](-nbt-short/index.md) | `data class NbtShort : `[`NbtTag`](-nbt-tag/index.md)<br>A tag which wraps a short value. |
| [NbtString](-nbt-string/index.md) | `data class NbtString : `[`NbtTag`](-nbt-tag/index.md)<br>A tag which wraps a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value. |
| [NbtTag](-nbt-tag/index.md) | `sealed class NbtTag`<br>The base class for Nbt Tags. All tag values are mutable. |
