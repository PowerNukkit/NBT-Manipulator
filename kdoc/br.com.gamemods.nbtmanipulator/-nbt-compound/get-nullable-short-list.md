---
title: NbtCompound.getNullableShortList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getNullableShortList](./get-nullable-short-list.html)

# getNullableShortList

`fun getNullableShortList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.html)`<`[`NbtShort`](../-nbt-short/index.html)`>?`

Returns the [NbtList](../-nbt-list/index.html) of shorts mapped to that name. The tag will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtShort](../-nbt-short/index.html)