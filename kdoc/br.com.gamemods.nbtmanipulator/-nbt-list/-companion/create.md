//[nbt-manipulator](../../../../index.md)/[br.com.gamemods.nbtmanipulator](../../index.md)/[NbtList](../index.md)/[Companion](index.md)/[create](create.md)

# create

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)): [NbtList](../index.md)&lt;[NbtByte](../../-nbt-byte/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html)): [NbtList](../index.md)&lt;[NbtShort](../../-nbt-short/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [NbtList](../index.md)&lt;[NbtInt](../../-nbt-int/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [NbtList](../index.md)&lt;[NbtLong](../../-nbt-long/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)): [NbtList](../index.md)&lt;[NbtFloat](../../-nbt-float/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)): [NbtList](../index.md)&lt;[NbtDouble](../../-nbt-double/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [NbtList](../index.md)&lt;[NbtString](../../-nbt-string/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)): [NbtList](../index.md)&lt;[NbtByteArray](../../-nbt-byte-array/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)): [NbtList](../index.md)&lt;[NbtIntArray](../../-nbt-int-array/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [LongArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html)): [NbtList](../index.md)&lt;[NbtLongArray](../../-nbt-long-array/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [NbtTag](../../-nbt-tag/index.md)&gt;): [NbtList](../index.md)&lt;[NbtCompound](../../-nbt-compound/index.md)&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [create](create.md)(vararg tags: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)&lt;[NbtTag](../../-nbt-tag/index.md)&gt;): [NbtList](../index.md)&lt;[NbtList](../index.md)&lt;[NbtTag](../../-nbt-tag/index.md)&gt;&gt;

Returns a [NbtList](../index.md) contained all elements wrapped in the appropriated [NbtTag](../../-nbt-tag/index.md).
