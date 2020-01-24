[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getByteArray](./get-byte-array.md)

# getByteArray

`fun getByteArray(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

Returns the unwrapped byte array value. The array will be linked and any modification will
also change wrapper and the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtByteArray](../-nbt-byte-array/index.md)

`NoSuchElementException` - If the key is not present on the compound