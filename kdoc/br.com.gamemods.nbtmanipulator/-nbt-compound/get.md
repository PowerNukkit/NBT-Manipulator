---
title: NbtCompound.get - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [get](./get.html)

# get

`operator fun get(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtTag`](../-nbt-tag.html)`?`

Simple access to the [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html), will return a [NbtTag](../-nbt-tag.html) if there's a value for that key.

The returned tag will be linked, so modifications to it will also affects the compound value.

