---
title: NbtCompound.getNullableStringList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getNullableStringList](./get-nullable-string-list.html)

# getNullableStringList

`fun getNullableStringList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.html)`<`[`NbtString`](../-nbt-string/index.html)`>?`

Returns the [NbtList](../-nbt-list/index.html) of strings mapped to that name. The tag will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtString](../-nbt-string/index.html)