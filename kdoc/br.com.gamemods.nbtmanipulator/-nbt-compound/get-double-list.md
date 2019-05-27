[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getDoubleList](./get-double-list.md)

# getDoubleList

`fun getDoubleList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtDouble`](../-nbt-double/index.md)`>`

Returns the [NbtList](../-nbt-list/index.md) of doubles mapped to that name. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.md) is not a [NbtList](../-nbt-list/index.md)

`TypeCastException` - If no value exists for that name

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtDouble](../-nbt-double/index.md)