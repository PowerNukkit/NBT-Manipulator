//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[getNullableIntArrayList](get-nullable-int-array-list.md)

# getNullableIntArrayList

[jvm]\
fun [getNullableIntArrayList](get-nullable-int-array-list.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NbtList](../-nbt-list/index.md)&lt;[NbtIntArray](../-nbt-int-array/index.md)&gt;?

Returns the [NbtList](../-nbt-list/index.md) of int arrays mapped to that key. The tag and it's value will be linked and any modification will also change the mapped value.

Will return null if no value is mapped, or it is mapped to another type tag.

## Throws

| | |
|---|---|
| [kotlin.ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html) | If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md) |
| [kotlin.IllegalStateException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-state-exception/index.html) | If the list is not empty and contains any tag with class different then [NbtIntArray](../-nbt-int-array/index.md) |
