package br.com.gamemods.nbtmanipulator

import junit.framework.TestCase
import java.io.File

class LevelDatTest: TestCase() {
    fun testReadLevelDat() {
        assertEquals(NbtList(NbtInt(1), NbtInt(2), NbtInt(3)), listOf(1, 2, 3).toNbtList())
        LevelDatTest::class.java.getResourceAsStream("/level-java-edition.dat").use { inputStream ->
            NbtIO.readNbtFile(inputStream)
        }
    }
    
    fun testReadBedrockLevelDat() {
        LevelDatTest::class.java.getResourceAsStream("/level-bedrock-edition.dat").use { inputStream ->
            val nbtFile = NbtIO.readNbtFile(inputStream, compressed = false, littleEndian = true, readHeaders = true)
            println(nbtFile)
        }
    }
    
    fun testAutoDetection() {
        val javaNbt = NbtIO.readNbtFileDetectingSettings(File("src/test/resources/level-java-edition.dat"))
        val bedrockNbt = NbtIO.readNbtFileDetectingSettings(File("src/test/resources/level-bedrock-edition.dat"))
        println(javaNbt)
        println(bedrockNbt)
    }
}
