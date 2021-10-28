//[nbt-manipulator](../../../../index.md)/[br.com.gamemods.nbtmanipulator](../../index.md)/[NbtList](../index.md)/[Companion](index.md)/[createCompoundSublist](create-compound-sublist.md)

# createCompoundSublist

[jvm]\

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [createCompoundSublist](create-compound-sublist.md)(vararg tags: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)&lt;[Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [NbtTag](../../-nbt-tag/index.md)&gt;&gt;): [NbtList](../index.md)&lt;[NbtList](../index.md)&lt;[NbtCompound](../../-nbt-compound/index.md)&gt;&gt;

@[JvmStatic](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.jvm/-jvm-static/index.html)

fun [createCompoundSublist](create-compound-sublist.md)(vararg tags: [Array](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)&lt;[Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [NbtTag](../../-nbt-tag/index.md)&gt;&gt;): [NbtList](../index.md)&lt;[NbtList](../index.md)&lt;[NbtCompound](../../-nbt-compound/index.md)&gt;&gt;

Returns a [NbtList](../index.md) contained all elements wrapped in the appropriated [NbtTag](../../-nbt-tag/index.md).
