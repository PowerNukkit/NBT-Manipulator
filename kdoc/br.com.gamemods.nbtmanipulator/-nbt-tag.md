[br.com.gamemods.nbtmanipulator](index.md) / [NbtTag](./-nbt-tag.md)

# NbtTag

`sealed class NbtTag`

The base class for Nbt Tags. All tag values are mutable.

Do not create new classes extending it.

### Inheritors

| Name | Summary |
|---|---|
| [NbtByte](-nbt-byte/index.md) | `data class NbtByte : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps a byte value. |
| [NbtByteArray](-nbt-byte-array/index.md) | `data class NbtByteArray : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps a mutable byte array. |
| [NbtCompound](-nbt-compound/index.md) | `data class NbtCompound : `[`NbtTag`](./-nbt-tag.md)<br>A key-value mapping tag similar to [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html). |
| [NbtDouble](-nbt-double/index.md) | `data class NbtDouble : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps a double value. |
| [NbtEnd](-nbt-end.md) | `object NbtEnd : `[`NbtTag`](./-nbt-tag.md)<br>A special tag which indicates the end of a compound stream or empty lists. |
| [NbtFloat](-nbt-float/index.md) | `data class NbtFloat : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps a float value. |
| [NbtInt](-nbt-int/index.md) | `data class NbtInt : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps an int value. |
| [NbtIntArray](-nbt-int-array/index.md) | `data class NbtIntArray : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps a mutable int array. |
| [NbtList](-nbt-list/index.md) | `data class NbtList<T : `[`NbtTag`](./-nbt-tag.md)`> : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps a mutable list of [NbtTag](./-nbt-tag.md)s. All items in the list must have the same class. Null values in the list are not allowed. |
| [NbtLong](-nbt-long/index.md) | `data class NbtLong : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps a long value. |
| [NbtLongArray](-nbt-long-array/index.md) | `data class NbtLongArray : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps a mutable long array. |
| [NbtShort](-nbt-short/index.md) | `data class NbtShort : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps a short value. |
| [NbtString](-nbt-string/index.md) | `data class NbtString : `[`NbtTag`](./-nbt-tag.md)<br>A tag which wraps a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) value. |
