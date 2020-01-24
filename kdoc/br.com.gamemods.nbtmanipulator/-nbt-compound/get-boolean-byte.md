[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getBooleanByte](./get-boolean-byte.md)

# getBooleanByte

`fun getBooleanByte(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns `true` if [getByte](get-byte.md) returns `1`, `false` otherwise.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtByte](../-nbt-byte/index.md)

`NoSuchElementException` - If the key is not present on the compound