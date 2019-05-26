---
title: NbtIO - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtIO](./index.html)

# NbtIO

`object NbtIO`

Contains usefull methods do read and write [NbtFile](../-nbt-file/index.html) from [File](https://docs.oracle.com/javase/6/docs/api/java/io/File.html) and [InputStream](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)/[OutputStream](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html).

### Functions

| [readNbtFile](read-nbt-file.html) | `fun readNbtFile(inputStream: `[`InputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, compressed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`NbtFile`](../-nbt-file/index.html)<br>Read a [NbtFile](../-nbt-file/index.html) from the [InputStream](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html).`fun readNbtFile(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, compressed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`NbtFile`](../-nbt-file/index.html)<br>Read a [NbtFile](../-nbt-file/index.html) from a [File](https://docs.oracle.com/javase/6/docs/api/java/io/File.html). |
| [writeNbtFile](write-nbt-file.html) | `fun writeNbtFile(outputStream: `[`OutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`, file: `[`NbtFile`](../-nbt-file/index.html)`, compressed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Writes the [NbtFile](../-nbt-file/index.html) in the stream.`fun writeNbtFile(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, tag: `[`NbtFile`](../-nbt-file/index.html)`, compressed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Writes the [NbtFile](../-nbt-file/index.html) in a [File](https://docs.oracle.com/javase/6/docs/api/java/io/File.html). |

