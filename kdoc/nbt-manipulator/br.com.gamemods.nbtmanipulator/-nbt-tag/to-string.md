//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtTag](index.md)/[toString](to-string.md)

# toString

[jvm]\
override fun [toString](to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

A technical string representation of this tag, containing the tag type and it's value, appropriated for developer inspections.

The [NbtList](../-nbt-list/index.md) and the array types will have an output similar to a normal [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html) and [NbtCompound](../-nbt-compound/index.md) to a normal [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html).

Be aware that this may be a slow operation on big lists, arrays or compounds.
