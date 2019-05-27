[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getNullableString](./get-nullable-string.md)

# getNullableString

`fun getNullableString(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?`

Returns the unwrapped string value or null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtString](../-nbt-string/index.md)