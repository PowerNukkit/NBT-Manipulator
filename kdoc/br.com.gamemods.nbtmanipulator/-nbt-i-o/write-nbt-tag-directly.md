//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtIO](index.md)/[writeNbtTagDirectly](write-nbt-tag-directly.md)

# writeNbtTagDirectly

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [writeNbtTagDirectly](write-nbt-tag-directly.md)(output: [DataOutput](https://docs.oracle.com/javase/8/docs/api/java/io/DataOutput.html), tag: [NbtTag](../-nbt-tag/index.md), writeTypeId: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true)

Writes the [NbtTag](../-nbt-tag/index.md) directly, without name and optionally without type id.

## Parameters

jvm

| | |
|---|---|
| output | Where the file will be written, needs to handle compression and endianness. |
| tag | The tag that will be written to the output |
| writeTypeId | If the first byte written should be the NBT tag type id. |
