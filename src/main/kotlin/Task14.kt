import java.lang.StringBuilder

class Task14 {
    fun lcs(a: String, b: String): String {
        println("__________________________________________________")
        println(a)
        println(b)
        println("__________________________________________________")

        var aCrossing = a.filter { b.indexOf(it) != -1 }
        var bCrossing = b.filter { aCrossing.indexOf(it) != -1 }

        if (aCrossing.isEmpty() || bCrossing.isEmpty()) return ""

        if (aCrossing.length > bCrossing.length)
            aCrossing = bCrossing.also { bCrossing = aCrossing }

        val entryA:MutableList<MutableList<Int>> = MutableList(aCrossing.length) {it ->
            val result:MutableList<Int> = mutableListOf<Int>()
            var index: Int = bCrossing.indexOf(aCrossing[it])
            while (index >= 0) {
                result.add(index)
                index = bCrossing.indexOf(aCrossing[it], index + 1)
            }
            result
        }

        val bruteForceIndex:MutableList<Int> = MutableList(entryA.size) {-1}
        val maxIndex:List<Int> = List(entryA.size) {entryA[it].size - 1}

        var bruteForceIndexMax:MutableList<Int> = mutableListOf()
        var bruteForceIndexLen:Int = 0
        println(aCrossing)
        println(bCrossing)
        println(entryA)
        println(maxIndex)

        var needRepeat = true
        while (needRepeat) {
            //check
           val listCheck:MutableList<Int> = mutableListOf()
            for (el in bruteForceIndex.withIndex()){
                if (el.value!=-1) {
                    listCheck.add(entryA[el.index][el.value])
                }
            }

            if (listCheck.size > bruteForceIndexLen) {
                val check:Boolean = listCheck.asSequence().zipWithNext { a, b -> a < b }.all { it }
                if (check) {
                    bruteForceIndexLen = listCheck.size
                    bruteForceIndexMax = bruteForceIndex.toMutableList()
                    if (bruteForceIndexLen==bruteForceIndex.size) needRepeat=false
                }
            }

            //println("$bruteForceIndex $listCheck")
            //add bruteForceIndex
            for (i in bruteForceIndex.indices) {
                if (bruteForceIndex[i]<maxIndex[i]) {
                    bruteForceIndex[i]++
                    break
                }else{
                    bruteForceIndex[i] = -1
                    if (i==bruteForceIndex.size-1) needRepeat=false
                }
            }
        }

        println("$bruteForceIndexMax $bruteForceIndexLen")
        val result = StringBuilder()
        for (el in bruteForceIndexMax.withIndex()) {
            if (el.value != -1) {
                result.append(aCrossing[el.index])
            }
        }

        return result.toString()
    }
}