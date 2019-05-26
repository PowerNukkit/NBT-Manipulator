---
title: NbtCompound.getList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getList](./get-list.html)

# getList

`fun getList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.html)`<*>`

Returns the [NbtList](../-nbt-list/index.html) mapped to that name. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.html) is not a [NbtList](../-nbt-list/index.html)

`TypeCastException` - If no value exists for that name