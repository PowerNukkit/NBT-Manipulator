[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getList](./get-list.md)

# getList

`fun getList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<*>`

Returns the [NbtList](../-nbt-list/index.md) mapped to that name. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.md) is not a [NbtList](../-nbt-list/index.md)

`TypeCastException` - If no value exists for that name