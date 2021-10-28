//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[require](require.md)

# require

[jvm]\
fun [require](require.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NbtTag](../-nbt-tag/index.md)

Returns the value corresponding to the given [key](require.md), or throw an exception if such a key is not present in the compound.

## Throws

| | |
|---|---|
| [kotlin.NoSuchElementException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-no-such-element-exception/index.html) | If the key is not present on the compound |
