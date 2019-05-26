---
title: NbtCompound.getNullableByteList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getNullableByteList](./get-nullable-byte-list.html)

# getNullableByteList

`fun getNullableByteList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.html)`<`[`NbtByte`](../-nbt-byte/index.html)`>?`

Returns the [NbtList](../-nbt-list/index.html) of bytes mapped to that name. The tag will be linked and any modification will
also change the mapped value.

Will return null if no value is mapped or it is mapped to an other type tag.

### Exceptions

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtByte](../-nbt-byte/index.html)