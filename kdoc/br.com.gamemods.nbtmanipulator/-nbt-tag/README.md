[br.com.gamemods.nbtmanipulator](../index.md) / [NbtTag](./index.md)

# NbtTag

`sealed class NbtTag`

The base class for Nbt Tags. All tag values are mutable.

Do not create new classes extending it.

### Functions

| Name | Summary |
|---|---|
| [deepCopy](deep-copy.md) | `abstract fun deepCopy(): `[`NbtTag`](./index.md)<br>Copies all this and all nested NbtTags into new objects. |

### Inheritors

| Name | Summary |
|---|---|
| [NbtByte](../-nbt-byte/index.md) | `data class NbtByte : `[`NbtTag`](./index.md)<br>A tag which wraps a byte value. |
| [NbtByteArray](../-nbt-byte-array/index.md) | `data class NbtByteArray : `[`NbtTag`](./index.md)<br>A tag which wraps a mutable byte array. |
| [NbtCompound](../-nbt-compound/index.md) | `class NbtCompound : `[`NbtTag`](./index.md)`, `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`NbtTag`](./index.md)`>`<br>A tag which contains a [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html) structure associating [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)s to [NbtTag](./index.md)s. |
| [NbtDouble](../-nbt-double/index.md) | `data class NbtDouble : `[`NbtTag`](./index.md)<br>A tag which wraps a double value. |
| [NbtEnd](../-nbt-end/index.md) | `object NbtEnd : `[`NbtTag`](./index.md)<br>A special tag which indicates the end of a compound stream or empty lists. |
| [NbtFloat](../-nbt-float/index.md) | `data class NbtFloat : `[`NbtTag`](./index.md)<br>A tag which wraps a float value. |
| [NbtInt](../-nbt-int/index.md) | `data class NbtInt : `[`NbtTag`](./index.md)<br>A tag which wraps an int value. |
| [NbtIntArray](../-nbt-int-array/index.md) | `data class NbtIntArray : `[`NbtTag`](./index.md)<br>A tag which wraps a mutable int array. |
| [NbtList](../-nbt-list/index.md) | `class NbtList<T : `[`NbtTag`](./index.md)`> : `[`NbtTag`](./index.md)`, `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`T`](../-nbt-list/index.md#T)`>`<br>A tag which contains a [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html) structure of [NbtTag](./index.md)s. All items in the list must have the same class. Null values in the list are not allowed. The tags in the list will be linked so any modification will also change this tag contents. |
| [NbtLong](../-nbt-long/index.md) | `data class NbtLong : `[`NbtTag`](./index.md)<br>A tag which wraps a long value. |
| [NbtLongArray](../-nbt-long-array/index.md) | `data class NbtLongArray : `[`NbtTag`](./index.md)<br>A tag which wraps a mutable long array. |
| [NbtShort](../-nbt-short/index.md) | `data class NbtShort : `[`NbtTag`](./index.md)<br>A tag which wraps a short value. |
| [NbtString](../-nbt-string/index.md) | `data class NbtString : `[`NbtTag`](./index.md)<br>A tag which wraps a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value. |
