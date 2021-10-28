//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtIntArray](index.md)

# NbtIntArray

[jvm]\
data class [NbtIntArray](index.md)(value: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)) : [NbtTag](../-nbt-tag/index.md)

A tag which wraps a mutable int array.

## Constructors

| | |
|---|---|
| [NbtIntArray](-nbt-int-array.md) | [jvm]<br>fun [NbtIntArray](-nbt-int-array.md)()<br>Creates a new tag with an empty array. |
| [NbtIntArray](-nbt-int-array.md) | [jvm]<br>fun [NbtIntArray](-nbt-int-array.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))<br>Parses the string using the same structure which is returned by [stringValue](string-value.md). |
| [NbtIntArray](-nbt-int-array.md) | [jvm]<br>fun [NbtIntArray](-nbt-int-array.md)(value: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [deepCopy](deep-copy.md) | [jvm]<br>open override fun [deepCopy](deep-copy.md)(): [NbtIntArray](index.md)<br>Returns a new wrapper with a copy of the current value. |
| [equals](equals.md) | [jvm]<br>open operator override fun [equals](equals.md)(other: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)?): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Properly checks the equality of the array. |
| [hashCode](hash-code.md) | [jvm]<br>open override fun [hashCode](hash-code.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Properly calculates the hashcode of the array. |
| [toString](../-nbt-tag/to-string.md) | [jvm]<br>override fun [toString](../-nbt-tag/to-string.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>A technical string representation of this tag, containing the tag type, and it's value, appropriated for developer inspections. |

## Properties

| Name | Summary |
|---|---|
| [stringValue](string-value.md) | [jvm]<br>open override val [stringValue](string-value.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Returns a string representation of the tag's value with a structure similar to a normal [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html). |
| [value](value.md) | [jvm]<br>var [value](value.md): [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)<br>The wrapped value |
