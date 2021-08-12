//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtIO](index.md)/[writeNbtFileDirectly](write-nbt-file-directly.md)

# writeNbtFileDirectly

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [writeNbtFileDirectly](write-nbt-file-directly.md)(output: [DataOutput](https://docs.oracle.com/javase/8/docs/api/java/io/DataOutput.html), file: [NbtFile](../-nbt-file/index.md))

Writes the [NbtFile](../-nbt-file/index.md) to the output. This method does not write the Bedrock Edition version and length headers.

## Parameters

jvm

| | |
|---|---|
| output | Where the file will be written, needs to handle compression and endianness. |
| file | The file that will be written to the output |
