//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[getFloat](get-float.md)

# getFloat

[jvm]\
fun [getFloat](get-float.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)

Returns the unwrapped float value.

#### Throws

| | |
|---|---|
| [kotlin.ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html) | If the [NbtTag](../-nbt-tag/index.md) is not a [NbtFloat](../-nbt-float/index.md) |
| [kotlin.NoSuchElementException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-no-such-element-exception/index.html) | If the key is not present on the compound |
