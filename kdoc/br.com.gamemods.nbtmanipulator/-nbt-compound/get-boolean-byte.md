[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getBooleanByte](./get-boolean-byte.md)

# getBooleanByte

`fun getBooleanByte(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns `true` if [getByte](get-byte.md) returns `1`, `false` otherwise.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.md) is not a [NbtByte](../-nbt-byte/index.md)

`TypeCastException` - If no value exists for that name