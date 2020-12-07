package complete

import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.lang.Integer.min

class GRoundA2020Bundling {

    private fun coopPrefix(word1: String, word2:String): Int {
        val minLength = min(word1.length,word2.length)
        for (i in 0 until minLength) {
            if (word1[i]!=word2[i]) {
                return i
            }
        }
        return minLength
    }

    private fun solve(N: Int, K: Int, words: List<String>): Int {
        val nWords = words.size
        val nGroups = K
        val nWordsInGroup:Int = nWords / nGroups

        val coopPrefixes = Array(nWords) {Array(nWords) {0} }
        for (wInd1 in 0 until  nWords) {
            for (wInd2 in wInd1+1 until  nWords) {
                coopPrefixes[wInd1][wInd2] =coopPrefix(words[wInd1],words[wInd1])
            }
        }

        //find max indexes
        //val max = coopPrefixes.withIndex().



        coopPrefixes.forEach {
            println(it.joinToString(":"))
        }
        //
        return 0
    }

    fun mainIO(inputStream: InputStream, outputStream: OutputStream) {
        val br = inputStream.bufferedReader()

        val n: Int = br.readLine()?.toInt() ?: return
        for (nn in 1..n) {
            val m1:Array<Int> = br.readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: return
            val mut = mutableListOf<String>()
            for (i in 0 until m1[0]) {
                val m2:String = br.readLine() ?: ""
                mut.add(m2)
            }
            PrintStream(outputStream).println("Case #$nn: ${solve(m1[0],m1[1], mut)}")
        }
    }

    fun main() {
        mainIO(System.`in`, System.out)
    }

    fun sTest() {
        println(solve(8,2, listOf("G","G","GO","GO","GOO","GOO","GOOO","GOOO")))
    }
}