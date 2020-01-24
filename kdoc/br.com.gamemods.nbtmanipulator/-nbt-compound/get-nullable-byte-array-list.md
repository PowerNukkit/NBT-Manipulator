[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getNullableByteArrayList](./get-nullable-byte-array-list.md)

# getNullableByteArrayList

`fun getNullableByteArrayList(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtByteArray`](../-nbt-byte-array/index.md)`>?`

Returns the [NbtList](../-nbt-list/index.md) of byte arrays mapped to that key. The tag and it's value will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md)

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtByteArray](../-nbt-byte-array/index.md)