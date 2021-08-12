//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[LittleEndianDataInputStream](index.md)

# LittleEndianDataInputStream

[jvm]\
class [LittleEndianDataInputStream](index.md)(**in**: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html)) : [FilterInputStream](https://docs.oracle.com/javase/8/docs/api/java/io/FilterInputStream.html), [DataInput](https://docs.oracle.com/javase/8/docs/api/java/io/DataInput.html)

Implementation of [DataInput](https://docs.oracle.com/javase/8/docs/api/java/io/DataInput.html) that reads data from an [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html) using little endian byte order.

#### Author

joserobjr

#### Since

2020-10-20

## Parameters

jvm

| | |
|---|---|
| in | the underlying input stream. |

## Constructors

| | |
|---|---|
| [LittleEndianDataInputStream](-little-endian-data-input-stream.md) | [jvm]<br>fun [LittleEndianDataInputStream](-little-endian-data-input-stream.md)(in: [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html))<br>the underlying input stream. |

## Functions

| Name | Summary |
|---|---|
| [available](index.md#-725347186%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [available](index.md#-725347186%2FFunctions%2F-1216412040)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [close](index.md#-1354485441%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [close](index.md#-1354485441%2FFunctions%2F-1216412040)() |
| [mark](index.md#-930457612%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [mark](index.md#-930457612%2FFunctions%2F-1216412040)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [markSupported](index.md#-1317173002%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [markSupported](index.md#-1317173002%2FFunctions%2F-1216412040)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [read](index.md#-2105515219%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [read](index.md#-2105515219%2FFunctions%2F-1216412040)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>open override fun [read](index.md#-1118350007%2FFunctions%2F-1216412040)(p0: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>open override fun [read](index.md#110312553%2FFunctions%2F-1216412040)(p0: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), p2: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readBoolean](read-boolean.md) | [jvm]<br>open override fun [readBoolean](read-boolean.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [readByte](read-byte.md) | [jvm]<br>open override fun [readByte](read-byte.md)(): [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html) |
| [readChar](read-char.md) | [jvm]<br>open override fun [readChar](read-char.md)(): [Char](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-char/index.html) |
| [readDouble](read-double.md) | [jvm]<br>open override fun [readDouble](read-double.md)(): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [readFloat](read-float.md) | [jvm]<br>open override fun [readFloat](read-float.md)(): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [readFully](read-fully.md) | [jvm]<br>open override fun [readFully](read-fully.md)(b: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html))<br>open override fun [readFully](read-fully.md)(b: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), off: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), len: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [readInt](read-int.md) | [jvm]<br>open override fun [readInt](read-int.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readLine](read-line.md) | [jvm]<br>open override fun [readLine](read-line.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [readLong](read-long.md) | [jvm]<br>open override fun [readLong](read-long.md)(): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [readShort](read-short.md) | [jvm]<br>open override fun [readShort](read-short.md)(): [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html) |
| [readUnsignedByte](read-unsigned-byte.md) | [jvm]<br>open override fun [readUnsignedByte](read-unsigned-byte.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readUnsignedShort](read-unsigned-short.md) | [jvm]<br>open override fun [readUnsignedShort](read-unsigned-short.md)(): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [readUTF](read-u-t-f.md) | [jvm]<br>open override fun [readUTF](read-u-t-f.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [reset](index.md#1422135752%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [reset](index.md#1422135752%2FFunctions%2F-1216412040)() |
| [skip](index.md#1448064341%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [skip](index.md#1448064341%2FFunctions%2F-1216412040)(p0: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html) |
| [skipBytes](skip-bytes.md) | [jvm]<br>open override fun [skipBytes](skip-bytes.md)(n: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

## Properties

| Name | Summary |
|---|---|
| [in](index.md#-361816713%2FProperties%2F-1216412040) | [jvm]<br>val [in](index.md#-361816713%2FProperties%2F-1216412040): [InputStream](https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html) |
