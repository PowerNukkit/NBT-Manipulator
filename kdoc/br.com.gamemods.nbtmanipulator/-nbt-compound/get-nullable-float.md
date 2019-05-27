[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getNullableFloat](./get-nullable-float.md)

# getNullableFloat

`fun getNullableFloat(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`?`

Returns the unwrapped float value or null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtFloat](../-nbt-float/index.md)