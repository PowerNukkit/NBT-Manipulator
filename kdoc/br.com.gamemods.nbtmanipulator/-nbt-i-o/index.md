[br.com.gamemods.nbtmanipulator](../index.md) / [NbtIO](./index.md)

# NbtIO

`object NbtIO`

Contains useful methods do read and write [NbtFile](../-nbt-file/index.md) from [File](https://docs.oracle.com/javase/6/docs/api/java/io/File.html) and [InputStream](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)/[OutputStream](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html).

### Functions

| Name | Summary |
|---|---|
| [readNbtFile](read-nbt-file.md) | `fun readNbtFile(inputStream: `[`InputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html)`, compressed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`NbtFile`](../-nbt-file/index.md)<br>Read a [NbtFile](../-nbt-file/index.md) from the [InputStream](https://docs.oracle.com/javase/6/docs/api/java/io/InputStream.html).`fun readNbtFile(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, compressed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`NbtFile`](../-nbt-file/index.md)<br>Read a [NbtFile](../-nbt-file/index.md) from a [File](https://docs.oracle.com/javase/6/docs/api/java/io/File.html). |
| [writeNbtFile](write-nbt-file.md) | `fun writeNbtFile(outputStream: `[`OutputStream`](https://docs.oracle.com/javase/6/docs/api/java/io/OutputStream.html)`, file: `[`NbtFile`](../-nbt-file/index.md)`, compressed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Writes the [NbtFile](../-nbt-file/index.md) in the stream.`fun writeNbtFile(file: `[`File`](https://docs.oracle.com/javase/6/docs/api/java/io/File.html)`, tag: `[`NbtFile`](../-nbt-file/index.md)`, compressed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)` = true): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Writes the [NbtFile](../-nbt-file/index.md) in a [File](https://docs.oracle.com/javase/6/docs/api/java/io/File.html). |
