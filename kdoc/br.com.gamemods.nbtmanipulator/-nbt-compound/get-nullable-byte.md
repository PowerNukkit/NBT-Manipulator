//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[getNullableByte](get-nullable-byte.md)

# getNullableByte

[jvm]\
fun [getNullableByte](get-nullable-byte.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)?

Returns the unwrapped byte value or null if no value is mapped or it is mapped to an other type tag.

#### Throws

| | |
|---|---|
| [kotlin.ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html) | If the [NbtTag](../-nbt-tag/index.md) is not a [NbtByte](../-nbt-byte/index.md) |
