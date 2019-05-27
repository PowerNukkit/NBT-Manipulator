[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getByte](./get-byte.md)

# getByte

`fun getByte(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)

Returns the unwrapped byte value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtByte](../-nbt-byte/index.md)

`NoSuchElementException` - If the key is not present on the compound