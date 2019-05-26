---
title: NbtIO.writeNbtFile - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtIO](index.html) / [writeNbtFile](./write-nbt-file.html)

# writeNbtFile

`@JvmStatic fun writeNbtFile(outputStream: `[`OutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`, file: `[`NbtFile`](../-nbt-file/index.html)`, compressed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Writes the [NbtFile](../-nbt-file/index.html) in the stream.

### Parameters

`outputStream` - The stream that the file will be written

`file` - The file that will be written on the stream

`compressed` - If the file will be compressed by [GZIPOutputStream](https://docs.oracle.com/javase/6/docs/api/java/util/zip/GZIPOutputStream.html).`@JvmStatic fun writeNbtFile(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, tag: `[`NbtFile`](../-nbt-file/index.html)`, compressed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Writes the [NbtFile](../-nbt-file/index.html) in a [File](https://docs.oracle.com/javase/6/docs/api/java/io/File.html).

### Parameters

`file` - The output file

`file` - The NBT file that will be written on the output file

`compressed` - If the file will be compressed by [GZIPOutputStream](https://docs.oracle.com/javase/6/docs/api/java/util/zip/GZIPOutputStream.html)