//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[getNullableCompound](get-nullable-compound.md)

# getNullableCompound

[jvm]\
fun [getNullableCompound](get-nullable-compound.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NbtCompound](index.md)?

Returns the [NbtCompound](index.md) mapped to that key. The tag will be linked and any modification will also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

#### Throws

| | |
|---|---|
| [kotlin.ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html) | If the [NbtTag](../-nbt-tag/index.md) is not a [NbtCompound](index.md) |
