//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtIO](index.md)/[readNbtTagDirectly](read-nbt-tag-directly.md)

# readNbtTagDirectly

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun &lt;[T](read-nbt-tag-directly.md) : [NbtTag](../-nbt-tag/index.md)&gt; [readNbtTagDirectly](read-nbt-tag-directly.md)(input: [DataInput](https://docs.oracle.com/javase/8/docs/api/java/io/DataInput.html), tagType: [Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)&lt;[T](read-nbt-tag-directly.md)&gt;? = null): [T](read-nbt-tag-directly.md)

Reads a [NbtTag](../-nbt-tag/index.md) of type [T](read-nbt-tag-directly.md) from the input directly, this is a reader for [writeNbtTagDirectly](write-nbt-tag-directly.md).

## Parameters

jvm

| | |
|---|---|
| input | Where the file will be read, needs to handle compression and endianness. |
| tagType | The type of the tag that will be read, use null if the tag was written with writeTypeId enabled |

## Throws

| | |
|---|---|
| [kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | If [T](read-nbt-tag-directly.md) is exactly [NbtTag](../-nbt-tag/index.md). |

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

inline fun &lt;[T](read-nbt-tag-directly.md) : [NbtTag](../-nbt-tag/index.md)&gt; [readNbtTagDirectly](read-nbt-tag-directly.md)(input: [DataInput](https://docs.oracle.com/javase/8/docs/api/java/io/DataInput.html)): [T](read-nbt-tag-directly.md)

Reads a [NbtTag](../-nbt-tag/index.md) of type [T](read-nbt-tag-directly.md) from the input directly, this is a reader for [writeNbtTagDirectly](write-nbt-tag-directly.md).

## Parameters

jvm

| | |
|---|---|
| input | Where the file will be read, needs to handle compression and endianness. |
| T | The type of the tag that will be read. |

## Throws

| | |
|---|---|
| [kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | If [T](read-nbt-tag-directly.md) is exactly [NbtTag](../-nbt-tag/index.md). |
