[br.com.gamemods.nbtmanipulator](../index.md) / [NbtList](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`NbtList()`

Creates a tag with an empty mutable list.

`NbtList(vararg tags: `[`T`](index.md#T)`)`

Converts the array into a mutable list and wraps it. Make sure to use the same class in all values.

`NbtList(value: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`T`](index.md#T)`>)`

A tag which wraps a mutable list of [NbtTag](../-nbt-tag.md)s. All items in the list must have the same class.
Null values in the list are not allowed.

