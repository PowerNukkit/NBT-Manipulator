[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [get](./get.md)

# get

`operator fun get(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`NbtTag`](../-nbt-tag.md)`?`

Simple access to the [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html), will return a [NbtTag](../-nbt-tag.md) if there's a value for that key.

The returned tag will be linked, so modifications to it will also affects the compound value.

