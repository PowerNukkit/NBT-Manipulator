package br.com.gamemods.nbtmanipulator

import org.junit.Assert.*
import org.junit.Test

class ToStringTest {
    @Test
    fun testList() {
        assertEquals("NbtList[NbtInt(1), NbtInt(2), NbtInt(3)]", listOf(1,2,3).toNbtList().toString())
        assertEquals("NbtList[]", emptyList<String>().toNbtList().toString())
    }

    @Test
    fun testArrays() {
        assertEquals("NbtByteArray[1, 2, 3]", NbtByteArray(byteArrayOf(1, 2, 3)).toString())
    }

    @Test
    fun testCompounds() {
        assertEquals("NbtCompound{}", NbtCompound().toString())
        assertEquals("""NbtCompound{"id"=NbtString("minecraft:dirt"), "data"=NbtByte(1)}""",
            NbtCompound().also {
                it["id"] = "minecraft:dirt"
                it["data"] = 1.toByte()
            }.toString()
        )
    }

    @Test
    fun testStrings() {
        assertEquals("NbtString(\"Hi \\\"PlayerName\\\".\")",NbtString("""Hi "PlayerName".""").toString())
    }
}
