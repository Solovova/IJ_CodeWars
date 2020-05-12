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

        val entryA: MutableList<MutableList<Int>> = MutableList(aCrossing.length) { it ->
            val result: MutableList<Int> = mutableListOf<Int>()
            var index: Int = bCrossing.indexOf(aCrossing[it])
            while (index >= 0) {
                result.add(index)
                index = bCrossing.indexOf(aCrossing[it], index + 1)
            }
            result
        }

        println(aCrossing)
        println(bCrossing)
        println(entryA)



        //method 2
        println("Max size: ${entryA.size}")
        for (findLen in entryA.size downTo 1) {
            val result = StringBuilder()

            val entry = entryA.toMutableList()
            var possible = true

            val maxExcept = entryA.size - findLen
            val maxDeviation = bCrossing.length - findLen

            var countExcept = 0
            var prev = -1
            for (i in entry.indices) {
                val entryPos = entry[i].filter { it >= i-maxDeviation && it <= i+maxDeviation && it>prev}
                if (entryPos.isEmpty()) {
                    countExcept++
                }else{
                    prev = entryPos[0]
                    print("$prev|")
                    result.append(bCrossing[prev])
                }
                if (countExcept>maxExcept) {
                    possible = false
                    break
                }

            }


            println("$findLen $possible")
            if (possible) return result.toString()
        }

        return ""

        //method 1 bruteForce long work

        val bruteForceIndex: MutableList<Int> = MutableList(entryA.size) { -1 }
        val maxIndex: List<Int> = List(entryA.size) { entryA[it].size - 1 }

        var bruteForceIndexMax: MutableList<Int> = mutableListOf()
        var bruteForceIndexLen = 0

        println(maxIndex)

        var needRepeat = true
        var iterations = 0
        while (needRepeat) {
            iterations++
            //check 1
            var check = true
            val listCheck: MutableList<Int> = mutableListOf()
            if (bruteForceIndex.filter { it != -1 }.size<bruteForceIndexLen)
                check = false

            //check 2
            if (check) {
                for (el in bruteForceIndex.withIndex()) {
                    if (el.value != -1) {
                        listCheck.add(entryA[el.index][el.value])

                        if (listCheck.size > 1 && (listCheck[listCheck.size - 2] >= listCheck[listCheck.size - 1])) {
                            check = false
                            break
                        }
                    }
                }
            }

            if (check && listCheck.size > bruteForceIndexLen) {
                bruteForceIndexLen = listCheck.size
                bruteForceIndexMax = bruteForceIndex.toMutableList()
                if (bruteForceIndexLen == bruteForceIndex.size) needRepeat = false
            }

            //println("$bruteForceIndex $listCheck")
            //add bruteForceIndex
            for (i in bruteForceIndex.indices) {
                if (bruteForceIndex[i] < maxIndex[i]) {
                    bruteForceIndex[i]++
                    break
                } else {
                    bruteForceIndex[i] = -1
                    if (i == bruteForceIndex.size - 1) needRepeat = false
                }
            }
        }

        println("$bruteForceIndexMax $bruteForceIndexLen")
        println("iterations: $iterations")

        val result = StringBuilder()
        for (el in bruteForceIndexMax.withIndex()) {
            if (el.value != -1) {
                result.append(aCrossing[el.index])
            }
        }

        return result.toString()
    }
}