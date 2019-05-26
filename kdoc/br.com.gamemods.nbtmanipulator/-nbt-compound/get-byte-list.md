[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getByteList](./get-byte-list.md)

# getByteList

`fun getByteList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtByte`](../-nbt-byte/index.md)`>`

Returns the [NbtList](../-nbt-list/index.md) of bytes mapped to that name. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.md) is not a [NbtList](../-nbt-list/index.md)

`TypeCastException` - If no value exists for that name

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtByte](../-nbt-byte/index.md)