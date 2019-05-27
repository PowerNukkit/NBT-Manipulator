[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getNullableLongList](./get-nullable-long-list.md)

# getNullableLongList

`fun getNullableLongList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtLong`](../-nbt-long/index.md)`>?`

Returns the [NbtList](../-nbt-list/index.md) of longs mapped to that name. The tag will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtLong](../-nbt-long/index.md)