# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
Click the link above to see the future.

## [2.0.0] - 2020-01-24
[Downloads from maven central.][Download 2.0.0]

[Kotlin Documentation][KDoc 2.0.0]

### Changed
- Upgraded to Kotlin 1.3.61
- `NbtIO.writeNbtFile` and `NbtIO.readNbtFile` now throws `IOException` in Java **(Breaking Change)** 

## [1.1.0] - 2019-06-02
[Downloads from maven central.][Download 1.1.0]

[Kotlin Documentation][KDoc 1.1.0]

### Added
- New constructor to `NbtList` which accepts an other `NbtList` to resolve an ambiguity call in this scenario.
- `toNbtList()` extension function to many combinations of `Iterable` and `Array` which contains valid values for `NbtList`, including list of list.
- `NbtList.create` and it's sublist flavours to simplify list creations for Java users
- `add`, `remove`, `contains`, `minusAssign` and `plusAssign` extension functions to many possible `NbtList` for easy usage by Kotlin users

## [1.0.1] - 2019-05-27
[Downloads from maven central.][Download 1.0.1]

[Kotlin Documentation][KDoc 1.0.1]

### Fixes
- StackOverflowException on `NbtCompound.set(String, NbtTag)`

## [1.0.0] - 2019-05-27
[Downloads from maven central.][Download 1.0.0]

[Kotlin Documentation][KDoc 1.0.0]
### Added
- `deepClone` method to all tags
- `require` method to `NbtCompound`

### Changed
- `NbtList` is now a `MutableList` and not a `data class` anymore. This completely changes how API users interacts with them.
- `NbtCompound` is now a `MutableMap` and not a `data class` anymore. This completely changes how API users interacts with them.
- Renamed the parameter `name` to `key` in all methods of `NbtCompound`
- Renamed the parameter `tagName` to `tagKey` in all copy methods of `NbtCompound`
- All get methods from `NbtCompound` will now throw `NoSuchElementException` if the requested key does not exists in the compound
- All methods which throws exceptions now have the exception which is thrown registered in the binary files. 
Useful for Java users and who couldn't get the sources or javadoc.


## [0.0.2] - 2019-05-27 
[Downloads from maven central.][Download 0.0.2]
### Added
- Static methods for java users calling `NbtIO`
- Documentation to all public types, functions and properties
- The methods `NbtCompound.remove(String)`, `NbtCompound.remove(String, NbtTag)` and `NbtCompound.minusAssign(String)`

### Changed
- JavaDoc will not generate when building on Java 9+ due to a dokka issue
- The targetCompatibility to Java 8

## [0.0.1] - 2019-05-23
[Downloads from maven central.][Download 0.0.1]
### Added
- API to read and write to/from NBT files/streams using `NbtIO`
- API to freely manipulate NBT data loaded in memory

[Unreleased]: https://github.com/GameModsBR/NBT-Manipulator/compare/v2.0.0...HEAD
[2.0.0]: https://github.com/GameModsBR/NBT-Manipulator/compare/v1.1.1...v2.0.0
[1.1.0]: https://github.com/GameModsBR/NBT-Manipulator/compare/v1.0.1...v1.1.0
[1.0.1]: https://github.com/GameModsBR/NBT-Manipulator/compare/v1.0.0...v1.0.1
[1.0.0]: https://github.com/GameModsBR/NBT-Manipulator/compare/v0.0.2...v1.0.0
[0.0.2]: https://github.com/GameModsBR/NBT-Manipulator/compare/v0.0.1...v0.0.2
[0.0.1]: https://github.com/GameModsBR/NBT-Manipulator/compare/v0.0.0...v0.0.1

[Download 2.0.0]: http://central.maven.org/maven2/br/com/gamemods/nbt-manipulator/2.0.0/
[Download 1.1.0]: http://central.maven.org/maven2/br/com/gamemods/nbt-manipulator/1.1.0/
[Download 1.0.1]: http://central.maven.org/maven2/br/com/gamemods/nbt-manipulator/1.0.1/
[Download 1.0.0]: http://central.maven.org/maven2/br/com/gamemods/nbt-manipulator/1.0.0/
[Download 0.0.2]: http://central.maven.org/maven2/br/com/gamemods/nbt-manipulator/0.0.2/
[Download 0.0.1]: http://central.maven.org/maven2/br/com/gamemods/nbt-manipulator/0.0.1/

[KDoc 2.0.0]: https://github.com/GameModsBR/NBT-Manipulator/blob/144c1aec6b9fbb2ce7996e200a9637f9b868c8d9/kdoc/br.com.gamemods.nbtmanipulator/index.md
[KDoc 1.1.0]: https://github.com/GameModsBR/NBT-Manipulator/blob/f188707e1d9a5616db1ccd45e892171349ee5a62/kdoc/br.com.gamemods.nbtmanipulator/index.md
[KDoc 1.0.1]: https://github.com/GameModsBR/NBT-Manipulator/blob/51f0f36511b8d4979d5d3e322f2fb766095a174c/kdoc/br.com.gamemods.nbtmanipulator/index.md
[KDoc 1.0.0]: https://github.com/GameModsBR/NBT-Manipulator/blob/0ef42323681f9960cb2c9698d7b8b1d02632691b/kdoc/br.com.gamemods.nbtmanipulator/index.md
