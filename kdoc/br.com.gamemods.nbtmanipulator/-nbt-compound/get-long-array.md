[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getLongArray](./get-long-array.md)

# getLongArray

`fun getLongArray(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`LongArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)

Returns the unwrapped long array value. The array will be linked and any modification will
also change wrapper and the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.md) is not a [NbtLongArray](../-nbt-long-array/index.md)

`TypeCastException` - If no value exists for that name