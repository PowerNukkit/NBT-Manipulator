[br.com.gamemods.nbtmanipulator](../index.md) / [NbtList](./index.md)

# NbtList

`data class NbtList<T : `[`NbtTag`](../-nbt-tag.md)`> : `[`NbtTag`](../-nbt-tag.md)

A tag which wraps a mutable list of [NbtTag](../-nbt-tag.md)s. All items in the list must have the same class.
Null values in the list are not allowed.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NbtList()`<br>Creates a tag with an empty mutable list.`NbtList(vararg tags: `[`T`](index.md#T)`)`<br>Converts the array into a mutable list and wraps it. Make sure to use the same class in all values.`NbtList(value: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`T`](index.md#T)`>)`<br>A tag which wraps a mutable list of [NbtTag](../-nbt-tag.md)s. All items in the list must have the same class. Null values in the list are not allowed. |

### Properties

| Name | Summary |
|---|---|
| [value](value.md) | `var value: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`T`](index.md#T)`>`<br>The wrapped mutable list. It must implement all optional methods. The list instance will be linked so any modification will also change the tag value. |
