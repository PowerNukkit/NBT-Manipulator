---
title: NbtCompound.getByteArrayList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getByteArrayList](./get-byte-array-list.html)

# getByteArrayList

`fun getByteArrayList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.html)`<`[`NbtByteArray`](../-nbt-byte-array/index.html)`>`

Returns the [NbtList](../-nbt-list/index.html) of byte arrays mapped to that name. The tag and it's value will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.html) is not a [NbtList](../-nbt-list/index.html)

`TypeCastException` - If no value exists for that name

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtByteArray](../-nbt-byte-array/index.html)