[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getIntArray](./get-int-array.md)

# getIntArray

`fun getIntArray(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)

Returns the unwrapped int array value. The array will be linked and any modification will
also change wrapper and the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag/index.md) is not a [NbtIntArray](../-nbt-int-array/index.md)

`NoSuchElementException` - If the key is not present on the compound