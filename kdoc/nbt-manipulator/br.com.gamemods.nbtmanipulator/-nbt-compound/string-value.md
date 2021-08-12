//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[stringValue](string-value.md)

# stringValue

[jvm]\
open override val [stringValue](string-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Returns a string representation of the tag's value.

The output will be similar to a normal [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html).

The class names of the children will exposed.

The returned string is compatible with string constructors of the same type.

Be aware that this may be a slow operation on compounds.
