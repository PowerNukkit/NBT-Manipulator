package br.com.gamemods.nbtmanipulator

import junit.framework.TestCase

class LevelDatTest: TestCase() {
    fun testReadLevelDat() {
        assertEquals(NbtList(NbtInt(1), NbtInt(2), NbtInt(3)), listOf(1, 2, 3).toNbtList())
        LevelDatTest::class.java.getResourceAsStream("/level.dat").use { inputStream ->
            NbtIO.readNbtFile(inputStream)
        }
    }
}
