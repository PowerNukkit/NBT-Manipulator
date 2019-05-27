[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getNullableIntList](./get-nullable-int-list.md)

# getNullableIntList

`fun getNullableIntList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.md)`<`[`NbtInt`](../-nbt-int/index.md)`>?`

Returns the [NbtList](../-nbt-list/index.md) of integers mapped to that name. The tag will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtIntArray](../-nbt-int-array/index.md)