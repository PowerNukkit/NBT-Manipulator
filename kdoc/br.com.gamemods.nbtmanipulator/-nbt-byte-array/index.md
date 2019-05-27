[br.com.gamemods.nbtmanipulator](../index.md) / [NbtByteArray](./index.md)

# NbtByteArray

`data class NbtByteArray : `[`NbtTag`](../-nbt-tag/index.md)

A tag which wraps a mutable byte array.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NbtByteArray(value: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`)`<br>A tag which wraps a mutable byte array. |

### Properties

| Name | Summary |
|---|---|
| [value](value.md) | `var value: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>The wrapped value |

### Functions

| Name | Summary |
|---|---|
| [deepCopy](deep-copy.md) | `fun deepCopy(): `[`NbtByteArray`](./index.md)<br>Returns a new wrapper with a copy of the current value. |
| [equals](equals.md) | `fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Properly checks the equality of the array. |
| [hashCode](hash-code.md) | `fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Properly calculates the hashcode of the array. |
