[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getByteList](./get-byte-list.md)

# getByteList

`fun getByteList(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtByte`](../-nbt-byte/index.md)`>`

Returns the [NbtList](../-nbt-list/index.md) of bytes mapped to that key. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md)

`NoSuchElementException` - If the key is not present on the compound

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtByte](../-nbt-byte/index.md)