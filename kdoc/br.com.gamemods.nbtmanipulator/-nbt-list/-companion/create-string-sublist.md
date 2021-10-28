//[nbt-manipulator](../../../../index.md)/[br.com.gamemods.nbtmanipulator](../../index.md)/[NbtList](../index.md)/[Companion](index.md)/[createStringSublist](create-string-sublist.md)

# createStringSublist

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [createStringSublist](create-string-sublist.md)(vararg tags: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;): [NbtList](../index.md)&lt;[NbtList](../index.md)&lt;[NbtString](../../-nbt-string/index.md)&gt;&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [createStringSublist](create-string-sublist.md)(vararg tags: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)&gt;): [NbtList](../index.md)&lt;[NbtList](../index.md)&lt;[NbtString](../../-nbt-string/index.md)&gt;&gt;

Returns a [NbtList](../index.md) contained all elements wrapped in the appropriated [NbtTag](../../-nbt-tag/index.md).
