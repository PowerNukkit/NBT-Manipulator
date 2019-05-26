# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
### Added
- Static methods for java users calling `NbtIO`
- Documentation to all public types, functions and properties

### Changed
- JavaDoc will not generate when building on Java 9+ due to a dokka issue
- The targetCompatibility to Java 8

## [0.0.1] - 2019-05-23
[Downloads from maven central.][Download 0.0.1]
### Added
- API to read and write to/from NBT files/streams using `NbtIO`
- API to freely manipulate NBT data loaded in memory

[Unreleased]: https://github.com/GameModsBR/NBT-Manipulator/compare/v0.0.1...HEAD
[0.0.1]: https://github.com/GameModsBR/NBT-Manipulator/compare/v0.0.0..v0.0.1

[Download 0.0.1]: http://central.maven.org/maven2/br/com/gamemods/nbt-manipulator/0.0.1/
