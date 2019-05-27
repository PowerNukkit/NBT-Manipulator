[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getFloatList](./get-float-list.md)

# getFloatList

`fun getFloatList(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtFloat`](../-nbt-float/index.md)`>`

Returns the [NbtList](../-nbt-list/index.md) of floats mapped to that key. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md)

`NoSuchElementException` - If the key is not present on the compound

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtFloat](../-nbt-float/index.md)