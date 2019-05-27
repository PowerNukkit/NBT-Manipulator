[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [getCompound](./get-compound.md)

# getCompound

`fun getCompound(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtCompound`](index.md)

Returns the [NbtCompound](index.md) mapped to that name. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.md) is not a [NbtCompound](index.md)

`TypeCastException` - If no value exists for that name