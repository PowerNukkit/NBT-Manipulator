[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [&lt;init&gt;](./-init-.md)

# &lt;init&gt;

`NbtCompound()`

Creates an empty compound.

`NbtCompound(vararg tags: `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`NbtTag`](../-nbt-tag/index.md)`>)`

Creates a compound which maps the [Pair.first](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/first.html) value to the [Pair.second](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/second.html) tag initially.

The given tags will be linked, so modifications to them will also affects the compound value.

`NbtCompound(value: `[`Map`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`NbtTag`](../-nbt-tag/index.md)`>)`

A tag which contains a [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html) structure associating [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)s to [NbtTag](../-nbt-tag/index.md)s.

It's the main heart of NBT files and usually contains complex structures.

### Parameters

`value` -

A [Map](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map/index.html) which contains all key-value mappings.
The tags in the map will be linked so any modification will also change this tag contents.




The returned tags by this class will be linked, so modifications to it will also affects the compound value.




All get functions which are not prefixed with `Nullable` and `get` will throw a [ClassCastException](https://docs.oracle.com/javase/6/docs/api/java/lang/ClassCastException.html)
if the tag is mapped to a different class then the method used. For example if a given compound
have a example=NbtInt(2) and you try to read it using [NbtCompound.getShort](get-short.md), an exception will be thrown.




All get functions which are not prefixed with `Nullable` and `get` will throw [NoSuchElementException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-no-such-element-exception/index.html)
if no value is mapped to the given name. This will change in future.




All get list functions which returns lists of specific types will throw [IllegalStateException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-illegal-state-exception/index.html) if the list content
does not match the requested type.

