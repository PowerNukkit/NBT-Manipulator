---
title: NbtCompound.<init> - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtCompound](index.html) / [&lt;init&gt;](./-init-.html)

# &lt;init&gt;

`NbtCompound()`

Creates an empty compound.

`NbtCompound(vararg tags: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`NbtTag`](../-nbt-tag.html)`>)`

Creates a compound which maps the [Pair.first](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/first.html) value to the [Pair.second](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/second.html) tag initially.

The given tags will be linked, so modifications to them will also affects the compound value.

`NbtCompound(value: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`NbtTag`](../-nbt-tag.html)`>)`

A key-value mapping tag similar to [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html).

It's the main heart of NBT files and usually contains complex structures.

