//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtIO](index.md)/[writeNbtFile](write-nbt-file.md)

# writeNbtFile

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

fun [writeNbtFile](write-nbt-file.md)(outputStream: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html), file: [NbtFile](../-nbt-file/index.md), compressed: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, littleEndian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Writes the [NbtFile](../-nbt-file/index.md) in the stream. This method does not write the Bedrock Edition version and length headers.

## Parameters

jvm

| | |
|---|---|
| outputStream | The stream that the file will be written |
| file | The file that will be written to the stream |
| compressed | If the file will be compressed by [GZIPOutputStream](https://docs.oracle.com/javase/8/docs/api/java/util/zip/GZIPOutputStream.html). |
| littleEndian | Uses little endian to write to the stream as in Bedrock Edition |

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

fun [writeNbtFile](write-nbt-file.md)(file: [File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html), tag: [NbtFile](../-nbt-file/index.md), compressed: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, littleEndian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, writeHeaders: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false)

Writes the [NbtFile](../-nbt-file/index.md) in a [File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html).

## Parameters

jvm

| | |
|---|---|
| file | The NBT file that will be written on the output file |
| compressed | If the file will be compressed by [GZIPOutputStream](https://docs.oracle.com/javase/8/docs/api/java/util/zip/GZIPOutputStream.html) |
| littleEndian | Uses little endian to write to the stream as in Bedrock Edition |
| writeHeaders | Writes the [NbtFile.version](../-nbt-file/version.md) and content size headers to the file. The [NbtFile.length](../-nbt-file/length.md) property will be updated when this flag is set to true. If [NbtFile.version](../-nbt-file/version.md) is null when this flag is true, 0 is assumed. The header is always written in little endian regardless of the [littleEndian](write-nbt-file.md) param. |
