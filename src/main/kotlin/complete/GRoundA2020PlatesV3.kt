import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream

class GRoundA2020PlatesV3 {


    private fun takePlate(oldSum: Int, taked: Array<Int>, needTake: Int, stacks: Array<Array<Int>>): Int {
        var maxSum = 0
        val nStacks = stacks.size
        val nPlates = stacks[0].size

        if (needTake == 1) {
            val maxStack = stacks.withIndex().maxBy { if (taked[it.index]>=nPlates) 0 else it.value[taked[it.index]] }
            return if (maxStack!= null) {
                 oldSum + maxStack.value[taked[maxStack.index]]
            } else -1
        }

        for (i in 0 until nStacks) {
            if (taked[i]>=nPlates) continue
            val newTaked = taked.copyOf()
            newTaked[i] = newTaked[i] + 1
            val tmpSum = takePlate(oldSum + stacks[i][taked[i]], newTaked, needTake - 1,stacks)
            if (tmpSum>maxSum) {
                maxSum = tmpSum
            }
        }
        return maxSum
    }


    private fun solve(n: Int, stacks: Array<Array<Int>>): Int {
        return takePlate(0, Array(stacks.size){0},n,stacks)
    }

    fun mainIO(inputStream: InputStream, outputStream: OutputStream) {
        val br = inputStream.bufferedReader()

        val n: Int = br.readLine()?.toInt() ?: return
        for (nn in 1..n) {
            val m1:Array<Int> = br.readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: return
            val mut = mutableListOf<Array<Int>>()
            for (i in 0 until m1[0]) {
                val m2:Array<Int> = br.readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: return
                mut.add(m2)
            }
            PrintStream(outputStream).println("Case #$nn: ${solve(m1[2], mut.toTypedArray())}")
        }
    }

    fun main() {
        mainIO(System.`in`, System.out)
    }

    fun sTest() {
        println(solve(5, arrayOf(arrayOf(80,80), arrayOf(15,50), arrayOf(20,10))))
        println(solve(0, arrayOf(arrayOf(10,10,100,30), arrayOf(80,50,10,50))))
    }
}