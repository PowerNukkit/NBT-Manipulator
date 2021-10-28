//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[LittleEndianDataOutputStream](index.md)

# LittleEndianDataOutputStream

[jvm]\
class [LittleEndianDataOutputStream](index.md)(out: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html)) : [FilterOutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/FilterOutputStream.html), [DataOutput](https://docs.oracle.com/javase/8/docs/api/java/io/DataOutput.html)

Implementation of [DataOutput](https://docs.oracle.com/javase/8/docs/api/java/io/DataOutput.html) that writes data to an [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html) using little endian byte order.

#### Author

joserobjr

#### Since

2020-10-20

## Parameters

jvm

| | |
|---|---|
| out | the underlying output stream. |

## Constructors

| | |
|---|---|
| [LittleEndianDataOutputStream](-little-endian-data-output-stream.md) | [jvm]<br>fun [LittleEndianDataOutputStream](-little-endian-data-output-stream.md)(out: [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html)) |

## Functions

| Name | Summary |
|---|---|
| [close](index.md#610912670%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [close](index.md#610912670%2FFunctions%2F-1216412040)() |
| [flush](index.md#-790498798%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [flush](index.md#-790498798%2FFunctions%2F-1216412040)() |
| [write](index.md#662851507%2FFunctions%2F-1216412040) | [jvm]<br>open override fun [write](index.md#662851507%2FFunctions%2F-1216412040)(p0: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html))<br>open override fun [write](index.md#-102524299%2FFunctions%2F-1216412040)(p0: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>open override fun [write](index.md#1030761299%2FFunctions%2F-1216412040)(p0: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html), p1: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), p2: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [writeBoolean](write-boolean.md) | [jvm]<br>open override fun [writeBoolean](write-boolean.md)(v: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)) |
| [writeByte](write-byte.md) | [jvm]<br>open override fun [writeByte](write-byte.md)(v: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [writeBytes](write-bytes.md) | [jvm]<br>open override fun [writeBytes](write-bytes.md)(s: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [writeChar](write-char.md) | [jvm]<br>open override fun [writeChar](write-char.md)(v: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [writeChars](write-chars.md) | [jvm]<br>open override fun [writeChars](write-chars.md)(s: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |
| [writeDouble](write-double.md) | [jvm]<br>open override fun [writeDouble](write-double.md)(v: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)) |
| [writeFloat](write-float.md) | [jvm]<br>open override fun [writeFloat](write-float.md)(v: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)) |
| [writeInt](write-int.md) | [jvm]<br>open override fun [writeInt](write-int.md)(v: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [writeLong](write-long.md) | [jvm]<br>open override fun [writeLong](write-long.md)(v: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) |
| [writeShort](write-short.md) | [jvm]<br>open override fun [writeShort](write-short.md)(v: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |
| [writeUTF](write-u-t-f.md) | [jvm]<br>open override fun [writeUTF](write-u-t-f.md)(s: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [out](index.md#-1721735352%2FProperties%2F-1216412040) | [jvm]<br>val [out](index.md#-1721735352%2FProperties%2F-1216412040): [OutputStream](https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html) |
