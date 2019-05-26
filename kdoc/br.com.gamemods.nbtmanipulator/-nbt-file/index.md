---
title: NbtFile - 
---

[br.com.gamemods.nbtmanipulator](../index.html) / [NbtFile](./index.html)

# NbtFile

`data class NbtFile`

The root component of a file, it contains a hint for the file name and the first tag in the file.

### Constructors

| [&lt;init&gt;](-init-.html) | `NbtFile(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, tag: `[`NbtTag`](../-nbt-tag.html)`)`<br>The root component of a file, it contains a hint for the file name and the first tag in the file. |

### Properties

| [compound](compound.html) | `var compound: `[`NbtCompound`](../-nbt-compound/index.html)<br>A shortcut to read or write [NbtFile.tag](tag.html) as a [NbtCompound](../-nbt-compound/index.html). Will throw a [ClassCastException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-class-cast-exception/index.html) if the tag value is not a [NbtCompound](../-nbt-compound/index.html) |
| [name](name.html) | `var name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The key for the file name. Empty in most cases. |
| [tag](tag.html) | `var tag: `[`NbtTag`](../-nbt-tag.html)<br>The first tag in the file. A [NbtCompound](../-nbt-compound/index.html) in most cases. |

