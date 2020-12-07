package complete

import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream

class GRoundB2020BikeTour {
    private fun solve(N: Int, mass: Array<Int>): Int {
        var result = 0
        for (i in 1 until  mass.size-1) {
            if (mass[i-1] < mass[i] && mass[i+1] < mass[i]) {
                result++
            }
        }
        return result
    }

    fun mainIO(inputStream: InputStream, outputStream: OutputStream) {
        val br = inputStream.bufferedReader()

        val n: Int = br.readLine()?.toInt() ?: return
        for (nn in 1..n) {
            val m1:Array<Int> = br.readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: return
            val m2:Array<Int> = br.readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: return
            PrintStream(outputStream).println("Case #$nn: ${solve(m1[0], m2)}")
        }
    }

    fun main() {
        mainIO(System.`in`, System.out)
    }

    fun sTest() {
        println(solve(3, arrayOf(10,20,14)))
    }
}