//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtTag](index.md)/[stringValue](string-value.md)

# stringValue

[jvm]\
abstract val [stringValue](string-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Returns a string representation of the tag's value.

The [NbtList](../-nbt-list/index.md) and the array types will have an output similar to a normal [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) and [NbtCompound](../-nbt-compound/index.md) to a normal [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html).

The class names of the [NbtList](../-nbt-list/index.md)'s and [NbtCompound](../-nbt-compound/index.md)'s children will exposed.

The returned string is compatible with string constructors of the same type.

Be aware that this may be a slow operation on big lists, arrays or compounds.
