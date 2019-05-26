---
title: NbtCompound.getCompound - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getCompound](./get-compound.html)

# getCompound

`fun getCompound(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtCompound`](index.html)

Returns the [NbtCompound](index.html) mapped to that name. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.html) is not a [NbtCompound](index.html)

`TypeCastException` - If no value exists for that name