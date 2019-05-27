[br.com.gamemods.nbtmanipulator](../index.md) / [NbtList](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`NbtList()`

Creates a empty list.

`NbtList(vararg tags: `[`T`](index.md#T)`)`
`NbtList(tags: `[`Iterable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)`<`[`T`](index.md#T)`>)`
`NbtList(tags: `[`Sequence`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)`<`[`T`](index.md#T)`>)`

Uses all tags as initial value of this list. Make sure to use the same class in all values.

`NbtList(tags: `[`Collection`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)`<`[`T`](index.md#T)`>)`

A tag which contains a [MutableList](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html) structure of [NbtTag](../-nbt-tag/index.md)s. All items in the list must have the same class.
Null values in the list are not allowed.

### Parameters

`tags` - The tags that will be in this list initially. May be read-only.
The tags in the list will be linked so any modification will also change this tag contents.

`T` - The type of the tag that will be wrapped. [NbtEnd](../-nbt-end/index.md) and [NbtTag](../-nbt-tag/index.md) are not valid.