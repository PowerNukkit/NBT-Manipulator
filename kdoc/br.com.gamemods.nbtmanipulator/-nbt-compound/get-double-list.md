---
title: NbtCompound.getDoubleList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [getDoubleList](./get-double-list.html)

# getDoubleList

`fun getDoubleList(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtList`](../-nbt-list/index.html)`<`[`NbtDouble`](../-nbt-double/index.html)`>`

Returns the [NbtList](../-nbt-list/index.html) of doubles mapped to that name. The tag will be linked and any modification will
also change the mapped value.

### Exceptions

`ClassCastException` - If the [NbtTag](../-nbt-tag.html) is not a [NbtList](../-nbt-list/index.html)

`TypeCastException` - If no value exists for that name

`IllegalStateException` - If the list is not empty and contains any tag with class different then [NbtDouble](../-nbt-double/index.html)