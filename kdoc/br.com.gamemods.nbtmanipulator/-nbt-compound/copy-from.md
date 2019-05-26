---
title: NbtCompound.copyFrom - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [copyFrom](./copy-from.html)

# copyFrom

`fun copyFrom(other: `[`NbtCompound`](index.html)`, tagName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, default: `[`NbtTag`](../-nbt-tag.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Checks if the other compound have a given tag, if it has then place it in this compound.

The tag will be linked, so any change in the tag will also affect both compounds.

### Parameters

`other` - The compound that will be checked

`tagName` - The name of the tag that will be mapped

`default` - If the other compound doesn't have the tag then this parameter will be used.