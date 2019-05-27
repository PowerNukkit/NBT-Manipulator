[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getCompoundList](./get-compound-list.md)

# getCompoundList

`fun getCompoundList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtCompound`](index.md)`>`

Returns the [NbtList](../-nbt-list/index.md) of compounds mapped to that name. The tag and it's values will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.md) is not a [NbtList](../-nbt-list/index.md)

`TypeCastException` - If no value exists for that name

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtCompound](index.md)