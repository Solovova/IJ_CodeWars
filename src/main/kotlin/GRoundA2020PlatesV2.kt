import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.lang.Integer.min

class GRoundA2020PlatesV2 {
    //все варианты сумы n на чисел k при максимальном числе maxN от максимального к минимальному
    private fun sumN(n: Int, maxN: Int, ind: Int, s: Array<Int>, allSum: MutableList<Array<Int>>) {
        if (ind + 1 == s.size) {
            if (n <= maxN && ((ind !=0 && s[ind-1]>=n) || (ind ==0))) {
                s[ind] = n
                allSum.add(s.copyOf())
            }
        } else {
            val fromI = if (ind ==0) min(n, maxN) else min(min(n, maxN), s[ind-1])

            for (i in fromI downTo 0) {
                s[ind] = i
                sumN(n - i, maxN, ind + 1, s, allSum)
            }
        }
    }

    private fun sumPlates(arr: Array<Int>, stacks: List<List<Int>> ):Int {
        var result = 0

        val usedStack = mutableListOf<Int>()
        //println(arr.joinToString(":"))

        arr.forEach {
            if (it != 0) {
                val mi = stacks.withIndex().maxBy { stack ->
                    if (usedStack.indexOf(stack.index) != -1) {
                        0
                    } else {
                        stack.value.withIndex().takeWhile { plate -> plate.index < it }.sumBy { plate -> plate.value }
                    }
                }

                if (mi!=null) {
                    //println(mi)
                    //println(usedStack)

                    result += mi.value.withIndex().takeWhile { plate -> plate.index < it }.sumBy { plate -> plate.value }
                    usedStack.add(mi.index)
                }
            }
        }

        return result
    }

    private fun solve(n: Int, stack: List<List<Int>>): Int {
        val allSum: MutableList<Array<Int>> = mutableListOf()
        sumN(n, stack[0].size, 0, Array(stack.size) {0}, allSum)

        return allSum.map {
            sumPlates(it, stack)
        }.max() ?: 0
    }

    fun mainIO(inputStream: InputStream, outputStream: OutputStream) {
        val br = inputStream.bufferedReader()

        val n: Int = br.readLine()?.toInt() ?: return
        for (nn in 1..n) {
            val m1:List<Int> = br.readLine()?.split(" ")?.map { it.toInt() } ?: return
            val mut = mutableListOf<List<Int>>()
            for (i in 0 until m1[0]) {
                val m2:List<Int> = br.readLine()?.split(" ")?.map { it.toInt() } ?: return
                mut.add(m2)
            }
            PrintStream(outputStream).println("Case #$nn: ${solve(m1[2], mut)}")
        }
    }

    fun main() {
        mainIO(System.`in`, System.out)
    }

    fun sTest() {
        val allSum: MutableList<Array<Int>> = mutableListOf()
        val n = 5
        val r = 2
        val maxN = 4
        sumN(n, maxN, 0, Array(r) {0}, allSum)
        allSum.forEach {
            println(it.joinToString(":"))
        }

        //println(solve(4, listOf(listOf(80,80), listOf(15,50), listOf(20,10))))
        println(solve(5, listOf(listOf(10,10,100,30), listOf(80,50,10,50))))
    }
}