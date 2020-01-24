[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getList](./get-list.md)

# getList

`fun getList(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<*>`

Returns the [NbtList](../-nbt-list/index.md) mapped to that key. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md)

`NoSuchElementException` - If the key is not present on the compound