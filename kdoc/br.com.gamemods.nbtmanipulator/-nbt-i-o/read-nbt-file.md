//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtIO](index.md)/[readNbtFile](read-nbt-file.md)

# readNbtFile

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

fun [readNbtFile](read-nbt-file.md)(inputStream: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html), compressed: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, littleEndian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, readHeaders: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [NbtFile](../-nbt-file/index.md)

Read a [NbtFile](../-nbt-file/index.md) from the [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html).

## Parameters

jvm

| | |
|---|---|
| inputStream | The input stream that will be read |
| compressed | If the file needs to be decompressed by [GZIPInputStream](https://docs.oracle.com/javase/8/docs/api/java/util/zip/GZIPInputStream.html) |
| littleEndian | Reads the NBT file using little endian byte order |
| readHeaders | Reads the NBT version and length headers before the content These data are read in little endian byte order regardless of the [littleEndian](read-nbt-file.md) parameter. |

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

@[JvmOverloads](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-overloads/index.html)()

fun [readNbtFile](read-nbt-file.md)(file: [File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html), compressed: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = true, littleEndian: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false, readHeaders: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) = false): [NbtFile](../-nbt-file/index.md)

Read a [NbtFile](../-nbt-file/index.md) from a [File](https://docs.oracle.com/javase/8/docs/api/java/io/File.html).

## Parameters

jvm

| | |
|---|---|
| file | The input file that will be read |
| compressed | If the file needs to be decompressed by [GZIPInputStream](https://docs.oracle.com/javase/8/docs/api/java/util/zip/GZIPInputStream.html) |
| littleEndian |  |
| readHeaders |  |
