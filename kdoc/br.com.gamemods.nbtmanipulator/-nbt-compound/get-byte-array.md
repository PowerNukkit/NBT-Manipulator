---
title: NbtCompound.getByteArray - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getByteArray](./get-byte-array.html)

# getByteArray

`fun getByteArray(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)

Returns the unwrapped byte array value. The array will be linked and any modification will
also change wrapper and the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.html) is not a [NbtByteArray](../-nbt-byte-array/index.html)

`TypeCastException` - If no value exists for that name