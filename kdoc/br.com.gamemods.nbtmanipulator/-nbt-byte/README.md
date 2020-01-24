[br.com.gamemods.nbtmanipulator](../index.md) / [NbtByte](./index.md)

# NbtByte

`data class NbtByte : `[`NbtTag`](../-nbt-tag/index.md)

A tag which wraps a byte value.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NbtByte(value: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`)`<br>Wraps a byte `1` if the value is `true` and `0` otherwise.`NbtByte(unsigned: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)`<br>Converts the int value to an unsigned byte and wraps it.`NbtByte(value: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)`)`<br>A tag which wraps a byte value. |

### Properties

| Name | Summary |
|---|---|
| [value](value.md) | `var value: `[`Byte`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte/index.html)<br>The wrapped value |

### Functions

| Name | Summary |
|---|---|
| [deepCopy](deep-copy.md) | `fun deepCopy(): `[`NbtByte`](./index.md)<br>Returns a new wrapper with the current value. |
