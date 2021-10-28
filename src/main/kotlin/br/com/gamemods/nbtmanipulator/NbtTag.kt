package br.com.gamemods.nbtmanipulator

/**
 * The base class for Nbt Tags. All tag values are mutable.
 *
 * Do not create new classes extending it.
 */
public sealed class NbtTag {
    /**
     * Returns a string representation of the tag's value.
     *
     * The [NbtList] and the array types will have an output similar to a normal [List] and [NbtCompound] to a normal [Map].
     *
     * The class names of the [NbtList]'s and [NbtCompound]'s children will expose.
     *
     * The returned string is compatible with string constructors of the same type.
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    public abstract val stringValue: String

    /**
     * Copies all this and all nested NbtTags into new objects.
     */
    public abstract fun deepCopy(): NbtTag

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
     * appropriated for developer inspections.
     *
     * The [NbtList] and the array types will have an output similar to a normal [List] and [NbtCompound] to a normal [Map].
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    protected open fun toTechnicalString(): String = "${this::class.java.simpleName}($stringValue)"

    /**
     * A technical string representation of this tag, containing the tag type, and it's value,
     * appropriated for developer inspections.
     *
     * The [NbtList] and the array types will have an output similar to a normal [List] and [NbtCompound] to a normal [Map].
     *
     * Be aware that this may be a slow operation on big lists, arrays or compounds.
     */
    final override fun toString(): String = toTechnicalString()
}
