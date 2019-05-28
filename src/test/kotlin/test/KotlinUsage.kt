package test

import br.com.gamemods.nbtmanipulator.*


class KotlinUsage {
    fun usageTest() {
        val list = listOf(2,3,4,5,6).toNbtList()
        list += 7
        check(7 in list)
        list -= 7
        check(7 !in list)
    }
}
