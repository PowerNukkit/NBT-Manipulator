---
title: NbtCompound.getShortList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getShortList](./get-short-list.html)

# getShortList

`fun getShortList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.html)`<`[`NbtShort`](../-nbt-short/index.html)`>`

Returns the [NbtList](../-nbt-list/index.html) of shorts mapped to that name. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.html) is not a [NbtList](../-nbt-list/index.html)

`TypeCastException` - If no value exists for that name

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtShort](../-nbt-short/index.html)