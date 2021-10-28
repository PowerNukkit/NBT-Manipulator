package br.com.gamemods.nbtmanipulator

/**
 * The root component of a file, it contains a hint for the file name and the first tag in the file.
 * @property name The key for the file name. Empty in most cases.
 * @property tag The first tag in the file. A [NbtCompound] in most cases.
 * @property compound A shortcut to read or write [NbtFile.tag] as a [NbtCompound].
 * @property version The version of the data stored in this file.
 * @property length The length of the file which is cached in the file's header.
 * @property isCompressed If the file needed to be uncompressed to load.
 * @property isLittleEndian If the file's byte order is little endian instead of big endian.
 * Will throw a [ClassCastException] if the tag value is not a [NbtCompound]
 */
public data class NbtFile @JvmOverloads constructor(
    var name: String,
    var tag: NbtTag,
    var version: Int? = null,
    var length: Int? = null,
    var isCompressed: Boolean? = null,
    var isLittleEndian: Boolean? = null
) {
    @Suppress("MemberVisibilityCanBePrivate")
    public var compound: NbtCompound
        @Throws(ClassCastException::class)
        get() = tag as NbtCompound
        set(value) {
            tag = value
        }
}
