//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtByteArray](index.md)/[stringValue](string-value.md)

# stringValue

[jvm]\
open override val [stringValue](string-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Returns a string representation of the tag's value with a structure similar to a normal [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html).

The returned string is compatible with string constructors of the same type.

Like [NbtByte](../-nbt-byte/index.md), the bytes returned are signed, ranging from -128 to 127.

Be aware that this may be a slow operation on big arrays.
