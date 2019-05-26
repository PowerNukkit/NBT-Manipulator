---
title: NbtCompound.getNullableFloatList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getNullableFloatList](./get-nullable-float-list.html)

# getNullableFloatList

`fun getNullableFloatList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.html)`<`[`NbtFloat`](../-nbt-float/index.html)`>?`

Returns the [NbtList](../-nbt-list/index.html) of floats mapped to that name. The tag will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtFloat](../-nbt-float/index.html)