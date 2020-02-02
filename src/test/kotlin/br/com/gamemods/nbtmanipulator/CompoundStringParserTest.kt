package br.com.gamemods.nbtmanipulator

import junit.framework.TestCase

class CompoundStringParserTest: TestCase() {

    fun testCompound() {
        assertEquals(NbtCompound(), NbtCompound("{}"))
        assertEquals(NbtCompound().also {
            it["a"] = 2
        }, NbtCompound("""{"a"=NbtInt(2)}"""))

        assertEquals(NbtCompound().also {
            it["a"] = 2
            it["b"] = 3.toByte()
        }, NbtCompound("""{"a"=NbtInt(2), "b"=NbtByte(3)}"""))

        assertEquals(NbtCompound().also {
            it["abc"] = 2L
            it["dfg"] = byteArrayOf(-4, 5, 127)
            it["hij"] = listOf(1, 2, 3, 4).toNbtList()
        }, NbtCompound("""{"abc"=NbtLong(2), "dfg"=NbtByteArray[-4, 5, 127], "hij"=NbtList[NbtInt(1), NbtInt(2), NbtInt(3), NbtInt(4)]}"""))
    }

    fun testComplexCompound() {
        assertEquals(
            NbtCompound().also { main ->
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
            },
            NbtCompound("""{"Pos"=NbtList[NbtDouble(124.48), NbtDouble(65.125), NbtDouble(813.3)], "Effects"=NbtList[NbtCompound{"Id"=NbtString("minecraft:regeneration"), "Duration"=NbtInt(322)}, NbtCompound{"Id"=NbtString("minecraft:health"), "Strength"=NbtByte(2)}], "Hack Attempt\"=NbtInt(2)"=NbtList[NbtCompound{"Injection\"}, NbtByteArray[2, 3, 5]"=NbtString("[[[[]]{{{}\")\"}\"=23")}]}""")
        )
    }

}
