[br.com.gamemods.nbtmanipulator](../index.md) / [NbtCompound](index.md) / [value](./value.md)

# value

`var value: `[`MutableMap`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, `[`NbtTag`](../-nbt-tag.md)`>`

The wrapped [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html) which contains all key-value mappings.
The map instance will be linked so any modification will also change the tag mappings.

All get functions which are not prefixed with `Nullable` and [NbtCompound.get](get.md) will throw a [ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html)
if the tag is mapped to a different class then the method used. For example if a given compound
have a example=NbtInt(2) and you try to read it using [NbtCompound.getShort](get-short.md), an exception will be thrown.

All get functions which are not prefixed with `Nullable` and [NbtCompound.get](get.md) will throw [TypeCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-type-cast-exception/index.html)
if no value is mapped to the given name. This will change in future.

### Property

`value` -

The wrapped [MutableMap](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-map/index.html) which contains all key-value mappings.
The map instance will be linked so any modification will also change the tag mappings.




All get functions which are not prefixed with `Nullable` and [NbtCompound.get](get.md) will throw a [ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html)
if the tag is mapped to a different class then the method used. For example if a given compound
have a example=NbtInt(2) and you try to read it using [NbtCompound.getShort](get-short.md), an exception will be thrown.




All get functions which are not prefixed with `Nullable` and [NbtCompound.get](get.md) will throw [TypeCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-type-cast-exception/index.html)
if no value is mapped to the given name. This will change in future.

