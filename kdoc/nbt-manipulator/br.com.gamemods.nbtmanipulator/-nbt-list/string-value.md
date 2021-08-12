//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtList](index.md)/[stringValue](string-value.md)

# stringValue

[jvm]\
open override val [stringValue](string-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Returns a string representation of the tag's value.

The output will be similar to a normal [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html).

The class names of the children tags will exposed.

The returned string is compatible with string constructors of the same type.

Be aware that this may be a slow operation on big lists, arrays or compounds.
