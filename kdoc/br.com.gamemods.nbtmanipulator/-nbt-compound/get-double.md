[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getDouble](./get-double.md)

# getDouble

`fun getDouble(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Returns the unwrapped double value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtDouble](../-nbt-double/index.md)

`NoSuchElementException` - If the key is not present on the compound