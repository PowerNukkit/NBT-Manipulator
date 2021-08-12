//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtIO](index.md)/[readNbtFileDirectly](read-nbt-file-directly.md)

# readNbtFileDirectly

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [readNbtFileDirectly](read-nbt-file-directly.md)(input: [DataInput](https://docs.oracle.com/javase/8/docs/api/java/io/DataInput.html)): [NbtFile](../-nbt-file/index.md)

Reads a [NbtFile](../-nbt-file/index.md) from the input. This method does not read the Bedrock Edition version and length headers.

## Parameters

jvm

| | |
|---|---|
| input | Where the file will be read, needs to handle compression and endianness. |
