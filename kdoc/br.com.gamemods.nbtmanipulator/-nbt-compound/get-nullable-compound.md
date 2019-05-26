---
title: NbtCompound.getNullableCompound - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getNullableCompound](./get-nullable-compound.html)

# getNullableCompound

`fun getNullableCompound(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtCompound`](index.html)`?`

Returns the [NbtCompound](index.html) mapped to that name. The tag will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

