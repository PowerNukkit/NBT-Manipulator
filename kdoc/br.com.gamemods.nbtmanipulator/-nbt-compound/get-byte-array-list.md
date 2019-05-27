[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getByteArrayList](./get-byte-array-list.md)

# getByteArrayList

`fun getByteArrayList(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtByteArray`](../-nbt-byte-array/index.md)`>`

Returns the [NbtList](../-nbt-list/index.md) of byte arrays mapped to that key. The tag and it's value will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md)

`NoSuchElementException` - If the key is not present on the compound

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtByteArray](../-nbt-byte-array/index.md)