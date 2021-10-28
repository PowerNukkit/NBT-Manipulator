//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[getListOfList](get-list-of-list.md)

# getListOfList

[jvm]\
fun [getListOfList](get-list-of-list.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NbtList](../-nbt-list/index.md)&lt;[NbtList](../-nbt-list/index.md)&lt;*&gt;&gt;

Returns the [NbtList](../-nbt-list/index.md) of lists mapped to that key. The tag and it's values will be linked and any modification will also change the mapped value.

## Throws

| | |
|---|---|
| [kotlin.ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html) | If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md) |
| [kotlin.NoSuchElementException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-no-such-element-exception/index.html) | If the key is not present on the compound |
| [kotlin.IllegalStateException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-state-exception/index.html) | If the list is not empty and contains any tag with class different then [NbtList](../-nbt-list/index.md) |