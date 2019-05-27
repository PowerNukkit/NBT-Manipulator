[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getString](./get-string.md)

# getString

`fun getString(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Returns the unwrapped string value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtString](../-nbt-string/index.md)

`NoSuchElementException` - If the key is not present on the compound