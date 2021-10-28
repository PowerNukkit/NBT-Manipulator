//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[set](set.md)

# set

[jvm]\
operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [NbtTag](../-nbt-tag/index.md))

Directly maps a [NbtTag](../-nbt-tag/index.md) to a key. The value must not be [NbtEnd](../-nbt-end/index.md). The given tag will be linked, so modifications to it will also affect the compound value.

[jvm]\
operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html))

Maps a [NbtByte](../-nbt-byte/index.md)1 if the value is true and 0 otherwise.

[jvm]\
operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Byte](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html))

Maps a [NbtByte](../-nbt-byte/index.md) with the given value.

[jvm]\
operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Short](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-short/index.html))

Maps a [NbtShort](../-nbt-short/index.md) with the given value.

[jvm]\
operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))

Maps a [NbtInt](../-nbt-int/index.md) with the given value.

[jvm]\
operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html))

Maps a [NbtLong](../-nbt-long/index.md) with the given value.

[jvm]\
operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html))

Maps a [NbtFloat](../-nbt-float/index.md) with the given value.

[jvm]\
operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html))

operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Maps a [NbtDouble](../-nbt-double/index.md) with the given value.

[jvm]\
operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [ByteArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html))

operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [IntArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html))

operator fun [set](set.md)(key: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [LongArray](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long-array/index.html))

Maps a [NbtByteArray](../-nbt-byte-array/index.md) with the given value. The array instance will be linked so any modification will also change the tag value.
