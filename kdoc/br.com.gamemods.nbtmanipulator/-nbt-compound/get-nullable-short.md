//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[getNullableShort](get-nullable-short.md)

# getNullableShort

[jvm]\
fun [getNullableShort](get-nullable-short.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)?

Returns the unwrapped short value or null if no value is mapped, or it is mapped to another type tag.

## Throws

| | |
|---|---|
| [kotlin.ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html) | If the [NbtTag](../-nbt-tag/index.md) is not a [NbtShort](../-nbt-short/index.md) |
