package br.com.gamemods.nbtmanipulator

import junit.framework.TestCase

class StringValueWithStringConstructorTest: TestCase() {

    private fun <V: Any, T: NbtTag> testEquality(value: V, typed: (V) -> T, string: (String) -> T, getter: (T) -> V) {
        assertEquals(value, getter(string(typed(value).stringValue)))
    }

    fun testSimpleTags() {
        testEquality((-28).toByte(), ::NbtByte, ::NbtByte, NbtByte::signed)
        testEquality((-3255).toShort(), ::NbtShort, ::NbtShort, NbtShort::value)
        testEquality(32558887, ::NbtInt, ::NbtInt, NbtInt::value)
        testEquality(-32558887L, ::NbtLong, ::NbtLong, NbtLong::value)
        testEquality(-3225.0, ::NbtDouble, ::NbtDouble, NbtDouble::value)
        testEquality(-3225F, ::NbtFloat, ::NbtFloat, NbtFloat::value)
        testEquality("Hello \"123\")Injection?", ::NbtString, ::NbtString, NbtString::value)
    }

    fun testArrays() {
        assertTrue(byteArrayOf(-28 ,0 , 127).contentEquals(NbtByteArray(NbtByteArray(byteArrayOf(-28 ,0 , 127)).stringValue).value))
        assertTrue(intArrayOf(-28 ,0 , 127).contentEquals(NbtIntArray(NbtIntArray(intArrayOf(-28 ,0 , 127)).stringValue).value))
        assertTrue(longArrayOf(-28 ,0 , 127).contentEquals(NbtLongArray(NbtLongArray(longArrayOf(-28 ,0 , 127)).stringValue).value))
    }

    fun testLists() {
        val constructor1 = { input: Collection<NbtTag> -> NbtList(input) }
        val constructor2 = { input: String -> NbtList<NbtTag>(input) }
        val getter: (NbtList<*>) -> Collection<NbtTag> = { list: NbtList<*> -> list }
        fun testEquality(list: NbtList<*>) = testEquality(list, constructor1, constructor2, getter)

        testEquality(listOf(1, 2, 3).toNbtList())
        testEquality(listOf<Byte>(1, 2, 3).toNbtList())

        val complexCompound = NbtCompound().also { main ->
            main["Pos"] = listOf(124.48, 65.125, 813.3).toNbtList()
            main["Effects"] = listOf(
                NbtCompound().also {
                    it["Id"] = "minecraft:regeneration"
                    it["Duration"] = 322
                },
                NbtCompound().also {
                    it["Id"] = "minecraft:health"
                    it["Strength"] = 2.toByte()
                }
            ).toNbtList()
            main["Hack Attempt\"=NbtInt(2)"] = listOf(
                NbtCompound().also {
                    it["Injection\"}, NbtByteArray[2, 3, 5]"] = "[[[[]]{{{}\")\"}\"=23"
                }
            ).toNbtList()
        }

        testEquality(listOf(complexCompound, complexCompound, complexCompound).toNbtList())
    }

}
