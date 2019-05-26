---
title: NbtCompound.getIntArray - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getIntArray](./get-int-array.html)

# getIntArray

`fun getIntArray(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)

Returns the unwrapped int array value. The array will be linked and any modification will
also change wrapper and the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.html) is not a [NbtIntArray](../-nbt-int-array/index.html)

`TypeCastException` - If no value exists for that name