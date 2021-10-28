//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[NbtCompound](-nbt-compound.md)

# NbtCompound

[jvm]\
fun [NbtCompound](-nbt-compound.md)(value: [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [NbtTag](../-nbt-tag/index.md)&gt;)

Creates a new compound containing the same mappings as the given [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html).

The tags in the map will be linked so any modification will also change this tag contents.

[jvm]\
fun [NbtCompound](-nbt-compound.md)()

Creates an empty compound.

[jvm]\
fun [NbtCompound](-nbt-compound.md)(vararg tags: [Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [NbtTag](../-nbt-tag/index.md)&gt;)

fun [NbtCompound](-nbt-compound.md)(tags: [Iterable](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterable/index.html)&lt;[Pair](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)&lt;[String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), [NbtTag](../-nbt-tag/index.md)&gt;&gt;)

Creates a compound which maps the [Pair.first](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/first.html) value to the [Pair.second](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/second.html) tag initially.

The given tags will be linked, so modifications to them will also affect the compound value.

[jvm]\
fun [NbtCompound](-nbt-compound.md)(value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

## Throws

| | |
|---|---|
| [kotlin.IllegalArgumentException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-argument-exception/index.html) | if the string does not have the exact format outputted by [stringValue](string-value.md) |
