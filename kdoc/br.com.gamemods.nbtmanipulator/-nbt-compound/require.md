[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [require](./require.md)

# require

`fun require(key: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtTag`](../-nbt-tag/index.md)

Returns the value corresponding to the given [key](require.md#br.com.gamemods.nbtmanipulator.NbtCompound$require(kotlin.String)/key), or throw an exception if such a key is not present in the compound.

### Exceptions

`NoSuchElementException` - If the key is not present on the compound