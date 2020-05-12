package complete

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



        println("Max size: ${entryA.size}")
        for (findLen in entryA.size downTo 1) {
            var possible = true

            val maxExcept = entryA.size - findLen
            val maxDeviation = bCrossing.length - findLen

            var countExcept = 0

            var prev = -1

            val listStack:MutableList<List<Int>> = mutableListOf() //Index,prev,this,TakeIndex,countExcept

            var index = 0
            var needBack = false
            var needBackTakeIndexPrev = -1
            while (index < entryA.size) {

                val entryPos = entryA[index].filter { it >= index-maxDeviation-countExcept && it <= index+maxDeviation-countExcept && it>prev}
                if (!needBack) {

                    if (entryPos.isEmpty()) {
                        countExcept++
                    } else {
                        listStack.add(listOf<Int>(index, prev, entryPos[0],0, countExcept))
                        if (listStack.size >= findLen) {
                            break
                        }
                        prev = entryPos[0]
                    }
                }else{
                    if (needBackTakeIndexPrev>(entryPos.size-2)) {
                        countExcept++
                        needBack=false
                    }else{
                        listStack.add(listOf<Int>(index, prev, entryPos[needBackTakeIndexPrev+1],needBackTakeIndexPrev+1, countExcept))
                        if (listStack.size >= findLen) {
                            break
                        }
                        prev = entryPos[needBackTakeIndexPrev+1]
                    }
                }

                if (countExcept>maxExcept) {
                    if (listStack.isNotEmpty()) {
                        val backRecord = listStack[listStack.size-1]
                        listStack.removeAt(listStack.size-1)
                        index=backRecord[0]
                        prev=backRecord[1]
                        needBackTakeIndexPrev=backRecord[3]
                        countExcept=backRecord[4]

                        needBack = true
                    }else{
                        possible = false
                        break
                    }
                }else{
                    index++
                }
            }

            val result = StringBuilder()
            for (el in listStack) {
                result.append(aCrossing[el[0]])
            }


            println("$findLen $possible")
            if (possible) return result.toString()
        }

        return ""
    }

    val m = mutableMapOf<Pair<String,String>,String>()

    fun lcs1(a: String, b: String): String {
        if (a.isEmpty() || b.isEmpty())
            return ""
        if (a.first() == b.first())
            return a.first() + lcs(a.drop(1),b.drop(1))
        val s1 = m.getOrPut(a to b.drop(1)) { lcs(a,b.drop(1)) }
        val s2 = m.getOrPut(a.drop(1) to b) { lcs(a.drop(1),b) }
        return if (s1.length > s2.length) s1 else s2
    }
}