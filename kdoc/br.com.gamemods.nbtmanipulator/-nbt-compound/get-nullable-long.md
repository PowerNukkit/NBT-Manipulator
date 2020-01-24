[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getNullableLong](./get-nullable-long.md)

# getNullableLong

`fun getNullableLong(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`?`

Returns the unwrapped long value or null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtLong](../-nbt-long/index.md)