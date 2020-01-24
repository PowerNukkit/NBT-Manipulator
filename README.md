# NBT Manipulator

This is a Kotlin/Java library that allows you to read and write NBT files and data in a clean and simple way.

Here you can find the library documentation:
* [Java Documentation](https://gamemodsbr.github.io/NBT-Manipulator/javadoc)
* [Kotlin Documentation](https://gamemodsbr.github.io/NBT-Manipulator/kdoc/br.com.gamemods.nbtmanipulator/index.html)

You may also want to see the [changelog](CHANGELOG.md) file to be aware of all changes in the tool that may impact you.

**TIP:** If you are using `NbtList` with Kotlin, add a `import br.com.gamemods.nbtmanipulator.*` for easy list management.

For example:
```kotlin
val list = listOf(2,3,4,5,6).toNbtList()
list += 7
check(7 in list)
list -= 7
check(7 !in list)
```

## Adding to your project

The library is shared in the maven center, so you don't need to declare any custom repository.

### Gradle

```groovy
repositories {
    mavenCentral() // or jcenter()
}

dependencies {
    compile 'br.com.gamemods:nbt-manipulator:2.0.0'
}
```

### Maven

```xml
<dependencies>
    <dependency>
      <groupId>br.com.gamemods</groupId>
      <artifactId>nbt-manipulator</artifactId>
      <version>2.0.0</version>
    </dependency>
</dependencies>
```

### Ivy

```xml
<dependency org="br.com.gamemods" name="nbt-manipulator" rev="2.0.0"/>
```

### Direct JAR
Download it from [maven central](http://central.maven.org/maven2/br/com/gamemods/nbt-manipulator/).

## Examples

```kotlin
val compound = NbtCompound()
compound["A string tag"] = "The string tag value"
compound["An int tag"] = 2
val byteValue: Byte = 3
compound["An byte tag"] = byteValue

println(compound.getString("A string tag"))
println(compound.getInt("A string tag"))
println(compound.getInt("An int tag"))
println(compound.getNullableByte("An byte tag"))

println(compound.getNullableStringList("This is missing.."))

val otherConstructor = NbtCompound(
    "a" to NbtString("string"),
    "b" to NbtList(listOf(NbtDouble(0.0), NbtDouble(1.1)))
)
println(otherConstructor["a"])
println(otherConstructor.getDoubleList("b"))
```

```kotlin
internal fun convertLevelFile(from: File, to: File) {
    val input = NbtIO.readNbtFile(from)
    val inputData = input.compound.getCompound("Data")

    val outputData = NbtCompound()
    outputData.copyFrom(inputData, "GameRules")
    outputData.copyFrom(inputData, "DayTime")
    outputData.copyFrom(inputData, "GameType")
    outputData.copyFrom(inputData, "generatorName")
    outputData.copyFrom(inputData, "generatorVersion")
    outputData.copyFrom(inputData, "generatorVersion")
    outputData.copyFrom(inputData, "generatorOptions", NbtString(""))
    outputData["hardcore"] = false
    outputData["initialized"] = false
    outputData.copyFrom(inputData, "LastPlayed")
    outputData.copyFrom(inputData, "LevelName")
    outputData.copyFrom(inputData, "raining")
    outputData.copyFrom(inputData, "rainTime")
    outputData.copyFrom(inputData, "RandomSeed")
    outputData.copyFrom(inputData, "SizeOnDisk")
    outputData.copyFrom(inputData, "SpawnX")
    outputData.copyFrom(inputData, "SpawnY")
    outputData.copyFrom(inputData, "SpawnZ")
    outputData.copyFrom(inputData, "thundering")
    outputData.copyFrom(inputData, "thunderTime")
    outputData.copyFrom(inputData, "Time")
    outputData.copyFrom(inputData, "version")

    val output = NbtCompound("Data" to outputData)
    val file = NbtFile("", output)
    NbtIO.writeNbtFile(to, file)
}
```
