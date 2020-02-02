package br.com.gamemods.nbtmanipulator

import junit.framework.TestCase

class ListStringParserTest: TestCase() {

    fun testListOfSimpleTags() {
        assertEquals(NbtList<NbtInt>(), NbtList<NbtInt>("[]"))
        assertEquals(listOf<Byte>(1, 2, -128).toNbtList(), NbtList<NbtByte>("[NbtByte(1), NbtByte(2), NbtByte(-128)]"))
        assertEquals(listOf<Short>(1, 2, -128).toNbtList(), NbtList<NbtShort>("[NbtShort(1), NbtShort(2), NbtShort(-128)]"))
        assertEquals(listOf(1, 2, -128).toNbtList(), NbtList<NbtInt>("[NbtInt(1), NbtInt(2), NbtInt(-128)]"))
        assertEquals(listOf<Long>(1, 2, -128).toNbtList(), NbtList<NbtLong>("[NbtLong(1), NbtLong(2), NbtLong(-128)]"))
        assertEquals(listOf(1.1F, 2.1F, -128.1F).toNbtList(), NbtList<NbtFloat>("[NbtFloat(1.1), NbtFloat(2.1), NbtFloat(-128.1)]"))
        assertEquals(listOf(1.1, 2.1, -128.1).toNbtList(), NbtList<NbtDouble>("[NbtDouble(1.1), NbtDouble(2.1), NbtDouble(-128.1)]"))
    }

    fun testListOfArrayTags() {
        assertEquals(listOf(listOf(1,2,3), listOf(4,5,6)).toNbtList(), NbtList<NbtList<NbtInt>>(
            "[NbtList[NbtInt(1), NbtInt(2), NbtInt(3)], NbtList[NbtInt(4), NbtInt(5), NbtInt(6)]]"
        ))

        assertEquals(listOf(byteArrayOf(1, 2, 3), byteArrayOf(4, 5, 6)).toNbtList(), NbtList<NbtByteArray>(
            "[NbtByteArray[1, 2, 3], NbtByteArray[4, 5, 6]]"
        ))

        assertEquals(listOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6)).toNbtList(), NbtList<NbtIntArray>(
            "[NbtIntArray[1, 2, 3], NbtIntArray[4, 5, 6]]"
        ))

        assertEquals(listOf(longArrayOf(1, 2, 3), longArrayOf(4, 5, 6)).toNbtList(), NbtList<NbtLongArray>(
            "[NbtLongArray[1, 2, 3], NbtLongArray[4, 5, 6]]"
        ))
    }

    fun testListOfStrings() {
        assertEquals(listOf("abc", "def").toNbtList(), NbtList<NbtString>(
            """[NbtString("abc"), NbtString("def")]"""
        ))

        assertEquals(listOf("Injection attempt \")Injected").toNbtList(), NbtList<NbtString>(
            """[NbtString("Injection attempt \")Injected")]"""
        ))

        assertEquals(listOf("Injection attempt \")]Injected", "after[[[").toNbtList(), NbtList<NbtString>(
            """[NbtString("Injection attempt \")]Injected"), NbtString("after[[[")]"""
        ))
    }
}
