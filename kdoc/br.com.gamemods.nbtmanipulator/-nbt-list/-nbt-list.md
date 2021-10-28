//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtList](index.md)/[NbtList](-nbt-list.md)

# NbtList

[jvm]\
fun &lt;[T](index.md) : [NbtTag](../-nbt-tag/index.md)&gt; [NbtList](-nbt-list.md)(tags: [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html)&lt;[T](index.md)&gt;)

Constructs a [NbtList](index.md) with the same contents of the given [Collection](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-collection/index.html).

All items in the list must have the same class.

Null values in the list are not allowed.

The tags in the list will be linked so any modification will also change this tag contents.

[jvm]\
fun [NbtList](-nbt-list.md)()

Creates an empty list.

[jvm]\
fun &lt;[T](index.md) : [NbtTag](../-nbt-tag/index.md)&gt; [NbtList](-nbt-list.md)(vararg tags: [T](index.md))

fun &lt;[T](index.md) : [NbtTag](../-nbt-tag/index.md)&gt; [NbtList](-nbt-list.md)(tags: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)&lt;[T](index.md)&gt;)

fun &lt;[T](index.md) : [NbtTag](../-nbt-tag/index.md)&gt; [NbtList](-nbt-list.md)(tags: [Sequence](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.sequences/-sequence/index.html)&lt;[T](index.md)&gt;)

fun &lt;[T](index.md) : [NbtTag](../-nbt-tag/index.md)&gt; [NbtList](-nbt-list.md)(tags: [NbtList](index.md)&lt;[T](index.md)&gt;)

Uses all tags as initial value of this list. Make sure to use the same class in all values.

[jvm]\
fun [NbtList](-nbt-list.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Parses the string using the same structure which is returned by [stringValue](string-value.md).

## Parameters

jvm

| | |
|---|---|
| value | A string with a structure like [NbtInt(0), NbtInt(-32), NbtInt(48), NbtInt(127)] |

## Throws

| | |
|---|---|
| [kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | if the string does not have the exact format outputted by [stringValue](string-value.md) |
