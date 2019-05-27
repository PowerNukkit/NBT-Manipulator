[br.com.gamemods.nbtmanipulator](../index.md) / [NbtFile](./index.md)

# NbtFile

`data class NbtFile`

The root component of a file, it contains a hint for the file name and the first tag in the file.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `NbtFile(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, tag: `[`NbtTag`](../-nbt-tag.md)`)`<br>The root component of a file, it contains a hint for the file name and the first tag in the file. |

### Properties

| Name | Summary |
|---|---|
| [compound](compound.md) | `var compound: `[`NbtCompound`](../-nbt-compound/index.md)<br>A shortcut to read or write [NbtFile.tag](tag.md) as a [NbtCompound](../-nbt-compound/index.md). Will throw a [ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html) if the tag value is not a [NbtCompound](../-nbt-compound/index.md) |
| [name](name.md) | `var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The key for the file name. Empty in most cases. |
| [tag](tag.md) | `var tag: `[`NbtTag`](../-nbt-tag.md)<br>The first tag in the file. A [NbtCompound](../-nbt-compound/index.md) in most cases. |
