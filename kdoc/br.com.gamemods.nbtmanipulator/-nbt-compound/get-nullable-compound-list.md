---
title: NbtCompound.getNullableCompoundList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getNullableCompoundList](./get-nullable-compound-list.html)

# getNullableCompoundList

`fun getNullableCompoundList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.html)`<`[`NbtCompound`](index.html)`>?`

Returns the [NbtList](../-nbt-list/index.html) of compounds mapped to that name. The tag and it's values will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtCompound](index.html)