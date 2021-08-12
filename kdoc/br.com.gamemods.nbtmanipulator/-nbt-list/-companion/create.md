//[nbt-manipulator](../../../../index.md)/[br.com.gamemods.nbtmanipulator](../../index.md)/[NbtList](../index.md)/[Companion](index.md)/[create](create.md)

# create

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)): [NbtList](../index.md)<[NbtByte](../../-nbt-byte/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)): [NbtList](../index.md)<[NbtShort](../../-nbt-short/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [NbtList](../index.md)<[NbtInt](../../-nbt-int/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [NbtList](../index.md)<[NbtLong](../../-nbt-long/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)): [NbtList](../index.md)<[NbtFloat](../../-nbt-float/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [NbtList](../index.md)<[NbtDouble](../../-nbt-double/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NbtList](../index.md)<[NbtString](../../-nbt-string/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [NbtList](../index.md)<[NbtByteArray](../../-nbt-byte-array/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)): [NbtList](../index.md)<[NbtIntArray](../../-nbt-int-array/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [LongArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)): [NbtList](../index.md)<[NbtLongArray](../../-nbt-long-array/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)<[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [NbtTag](../../-nbt-tag/index.md)>): [NbtList](../index.md)<[NbtCompound](../../-nbt-compound/index.md)>

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)()

fun [create](create.md)(vararg tags: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)<[NbtTag](../../-nbt-tag/index.md)>): [NbtList](../index.md)<[NbtList](../index.md)<[NbtTag](../../-nbt-tag/index.md)>>

Returns a [NbtList](../index.md) contained all elements wrapped in the appropriated [NbtTag](../../-nbt-tag/index.md).
