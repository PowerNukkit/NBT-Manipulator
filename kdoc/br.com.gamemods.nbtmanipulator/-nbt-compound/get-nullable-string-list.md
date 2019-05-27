[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getNullableStringList](./get-nullable-string-list.md)

# getNullableStringList

`fun getNullableStringList(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtString`](../-nbt-string/index.md)`>?`

Returns the [NbtList](../-nbt-list/index.md) of strings mapped to that key. The tag will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md)

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtString](../-nbt-string/index.md)