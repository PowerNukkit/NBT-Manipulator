---
title: NbtList - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtList](./index.html)

# NbtList

`data class NbtList<T : `[`NbtTag`](../-nbt-tag.html)`> : `[`NbtTag`](../-nbt-tag.html)

A tag which wraps a mutable list of [NbtTag](../-nbt-tag.html)s. All items in the list must have the same class.
Null values in the list are not allowed.

### Constructors

| [&lt;init&gt;](-init-.html) | `NbtList()`<br>Creates a tag with an empty mutable list.`NbtList(vararg tags: `[`T`](index.html#T)`)`<br>Converts the array into a mutable list and wraps it. Make sure to use the same class in all values.`NbtList(value: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`T`](index.html#T)`>)`<br>A tag which wraps a mutable list of [NbtTag](../-nbt-tag.html)s. All items in the list must have the same class. Null values in the list are not allowed. |

### Properties

| [value](value.html) | `var value: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`T`](index.html#T)`>`<br>The wrapped mutable list. It must implement all optional methods. The list instance will be linked so any modification will also change the tag value. |

