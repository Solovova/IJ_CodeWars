package complete

import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.lang.Integer.min

class GRoundA2020Plates {
    //все варианты сумы n на чисел k при максимальном числе maxN
    private fun sumN(n: Int, maxN: Int, ind: Int, s: Array<Int>, allSum: MutableList<Array<Int>>) {
        if (ind + 1 == s.size) {
            if (n <= maxN) {
                s[ind] = n
                allSum.add(s.copyOf())
            }
        } else {
            for (i in 0..min(n, maxN)) {
                s[ind] = i
                sumN(n - i, maxN, ind + 1, s, allSum)
            }
        }
    }

    private fun sumPlates(arr: Array<Int>, preSumPlates: List<List<Int>> ):Int {
        return arr.withIndex().sumBy {
            preSumPlates[it.index][it.value]
        }
    }

    private fun solve(n: Int, stacks: List<List<Int>>): Int {
        val allSum: MutableList<Array<Int>> = mutableListOf()
        sumN(n, stacks[0].size, 0, Array(stacks.size) {0}, allSum)

        val preSumPlates = stacks.map {stack ->
            val lis = mutableListOf<Int>()
            lis.add(0)
            stack.forEach{lis.add(lis[lis.size-1] + it)}
            lis
        }

        return allSum.map {
            sumPlates(it, preSumPlates)
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

    private fun sumPlatesOld(arr: Array<Int>, stack: List<List<Int>> ):Int {
        return arr.withIndex().sumBy {
            stack[it.index].withIndex()
                .takeWhile { plate -> plate.index<it.value }
                .sumBy { plate -> plate.value }
        }
    }

    fun sTest() {
//        val allSum: MutableList<Array<Int>> = mutableListOf()
//        val n = 5
//        val r = 3
//        val maxN = 4
//        sumN(n, maxN, 0, Array(r) {0}, allSum)
//        allSum.forEach {
//            println(it.joinToString(":"))
//        }

        println(solve(3, listOf(listOf(80,80), listOf(15,50), listOf(20,10))))
    }
}