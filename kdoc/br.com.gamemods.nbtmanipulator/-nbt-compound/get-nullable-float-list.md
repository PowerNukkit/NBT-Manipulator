//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[getNullableFloatList](get-nullable-float-list.md)

# getNullableFloatList

[jvm]\
fun [getNullableFloatList](get-nullable-float-list.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NbtList](../-nbt-list/index.md)&lt;[NbtFloat](../-nbt-float/index.md)&gt;?

Returns the [NbtList](../-nbt-list/index.md) of floats mapped to that key. The tag will be linked and any modification will also change the mapped value.

Will return null if no value is mapped, or it is mapped to another type tag.

## Throws

| | |
|---|---|
| [kotlin.ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html) | If the [NbtTag](../-nbt-tag/index.md) is not a [NbtList](../-nbt-list/index.md) |
| [kotlin.IllegalStateException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-state-exception/index.html) | If the list is not empty and contains any tag with class different then [NbtFloat](../-nbt-float/index.md) |
