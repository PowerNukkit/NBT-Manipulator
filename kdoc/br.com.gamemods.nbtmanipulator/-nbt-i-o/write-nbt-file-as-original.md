//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtIO](index.md)/[writeNbtFileAsOriginal](write-nbt-file-as-original.md)

# writeNbtFileAsOriginal

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [writeNbtFileAsOriginal](write-nbt-file-as-original.md)(outputStream: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html), file: [NbtFile](../-nbt-file/index.md))

Calls [writeNbtFile](write-nbt-file.md) using the information stored in the [NbtFile](../-nbt-file/index.md), uses the method's default when the information is missing (null).  This method does not write the Bedrock Edition version and length headers.

## Parameters

jvm

| | |
|---|---|
| outputStream | The stream that the file will be written |
| file | The file that will be written to the stream |
