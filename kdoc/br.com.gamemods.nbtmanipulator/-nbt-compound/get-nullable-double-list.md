---
title: NbtCompound.getNullableDoubleList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getNullableDoubleList](./get-nullable-double-list.html)

# getNullableDoubleList

`fun getNullableDoubleList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.html)`<`[`NbtDouble`](../-nbt-double/index.html)`>?`

Returns the [NbtList](../-nbt-list/index.html) of doubles mapped to that name. The tag will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtDouble](../-nbt-double/index.html)