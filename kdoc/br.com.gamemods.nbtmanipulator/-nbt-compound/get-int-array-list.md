[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getIntArrayList](./get-int-array-list.md)

# getIntArrayList

`fun getIntArrayList(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtIntArray`](../-nbt-int-array/index.md)`>`

Returns the [NbtList](../-nbt-list/index.md) of int arrays mapped to that key. The tag and it's value will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md)

`NoSuchElementException` - If the key is not present on the compound

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtIntArray](../-nbt-int-array/index.md)