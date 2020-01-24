[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getNullableDouble](./get-nullable-double.md)

# getNullableDouble

`fun getNullableDouble(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`?`

Returns the unwrapped double value or null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtDouble](../-nbt-double/index.md)