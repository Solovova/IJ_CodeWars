import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.lang.Integer.max
import java.lang.Integer.min

class GRoundA2020PlatesV4 {
    private fun solve(P: Int, stacks: Array<Array<Int>>): Int {
        val nStacks = stacks.size
        val nPlates = stacks[0].size

        val sum = stacks.map {stack ->
            val lis = mutableListOf<Int>()
            lis.add(0)
            stack.forEach{lis.add(lis[lis.size-1] + it)}
            return@map lis
        }

        val dp = Array(nStacks+1) {Array(P+1) {0} }

        for (i in 1 .. nStacks)
            for (j in 0 .. P) {
                dp[i][j] = 0
                for (x in 0 .. min(j, nPlates))
                    dp[i][j] = max(dp[i][j], sum[i-1][x]+dp[i-1][j-x])
            }
        return dp.map { it.maxBy { sec -> sec }?:0 }.maxBy { it } ?:0
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
        println(solve(2, arrayOf(arrayOf(80,80), arrayOf(15,50), arrayOf(20,10))))
        println(solve(6, arrayOf(arrayOf(10,10,100,30), arrayOf(80,50,10,50))))
    }
}