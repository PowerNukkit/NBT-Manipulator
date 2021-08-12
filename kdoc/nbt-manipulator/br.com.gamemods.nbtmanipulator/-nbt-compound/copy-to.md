//[nbt-manipulator](../../../index.md)/[br.com.gamemods.nbtmanipulator](../index.md)/[NbtCompound](index.md)/[copyTo](copy-to.md)

# copyTo

[jvm]\
fun [copyTo](copy-to.md)(other: [NbtCompound](index.md), tagKey: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), default: [NbtTag](../-nbt-tag/index.md)? = null)

Checks if the this compound have a given tag, if it has then place it in the other compound.

The tag will be linked, so any change in the tag will also affect both compounds.

## Parameters

jvm

| | |
|---|---|
| other | The compound that will be modified |
| tagKey | The name of the tag that will be mapped |
| default | If the this compound doesn't have the tag then this parameter will be used. |
