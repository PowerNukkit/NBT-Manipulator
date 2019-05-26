---
title: NbtCompound.getBooleanByte - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getBooleanByte](./get-boolean-byte.html)

# getBooleanByte

`fun getBooleanByte(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Returns `true` if [getByte](get-byte.html) returns `1`, `false` otherwise.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.html) is not a [NbtByte](../-nbt-byte/index.html)

`TypeCastException` - If no value exists for that name