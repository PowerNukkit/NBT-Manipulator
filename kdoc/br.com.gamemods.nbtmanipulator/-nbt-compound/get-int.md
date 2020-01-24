[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getInt](./get-int.md)

# getInt

`fun getInt(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Returns the unwrapped int value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtInt](../-nbt-int/index.md)

`NoSuchElementException` - If the key is not present on the compound