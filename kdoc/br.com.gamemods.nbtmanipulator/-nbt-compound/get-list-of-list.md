[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getListOfList](./get-list-of-list.md)

# getListOfList

`fun getListOfList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtList`](../-nbt-list/index.md)`<*>>`

Returns the [NbtList](../-nbt-list/index.md) of lists mapped to that name. The tag and it's values will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.md) is not a [NbtList](../-nbt-list/index.md)

`TypeCastException` - If no value exists for that name

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtList](../-nbt-list/index.md)