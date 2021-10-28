//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtFile](index.md)

# NbtFile

[jvm]\
data class [NbtFile](index.md)@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)constructor(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), tag: [NbtTag](../-nbt-tag/index.md), version: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, length: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, isCompressed: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?, isLittleEndian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)?)

The root component of a file, it contains a hint for the file name and the first tag in the file.

## Constructors

| | |
|---|---|
| [NbtFile](-nbt-file.md) | [jvm]<br>@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)<br>fun [NbtFile](-nbt-file.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), tag: [NbtTag](../-nbt-tag/index.md), version: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, length: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null, isCompressed: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null, isLittleEndian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [compound](compound.md) | [jvm]<br>var [compound](compound.md): [NbtCompound](../-nbt-compound/index.md)<br>A shortcut to read or write [NbtFile.tag](tag.md) as a [NbtCompound](../-nbt-compound/index.md). |
| [isCompressed](is-compressed.md) | [jvm]<br>var [isCompressed](is-compressed.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null<br>If the file needed to be uncompressed to load. |
| [isLittleEndian](is-little-endian.md) | [jvm]<br>var [isLittleEndian](is-little-endian.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)? = null<br>If the file's byte order is little endian instead of big endian. Will throw a [ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html) if the tag value is not a [NbtCompound](../-nbt-compound/index.md) |
| [length](length.md) | [jvm]<br>var [length](length.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null<br>The length of the file which is cached in the file's header. |
| [name](name.md) | [jvm]<br>var [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The key for the file name. Empty in most cases. |
| [tag](tag.md) | [jvm]<br>var [tag](tag.md): [NbtTag](../-nbt-tag/index.md)<br>The first tag in the file. A [NbtCompound](../-nbt-compound/index.md) in most cases. |
| [version](version.md) | [jvm]<br>var [version](version.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null<br>The version of the data stored in this file. |
