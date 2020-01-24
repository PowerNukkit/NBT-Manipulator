[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getNullableLongArrayList](./get-nullable-long-array-list.md)

# getNullableLongArrayList

`fun getNullableLongArrayList(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtLongArray`](../-nbt-long-array/index.md)`>?`

Returns the [NbtList](../-nbt-list/index.md) of long arrays mapped to that key. The tag and it's values will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md)

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtLongArray](../-nbt-long-array/index.md)