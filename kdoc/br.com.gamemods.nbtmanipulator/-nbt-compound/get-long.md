[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getLong](./get-long.md)

# getLong

`fun getLong(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)

Returns the unwrapped long value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtLongArray](../-nbt-long-array/index.md)

`NoSuchElementException` - If the key is not present on the compound