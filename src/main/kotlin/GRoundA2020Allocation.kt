import java.io.*

class GRoundA2020Allocation {
    private fun solve(money: Int, costs: List<Int>): Int {
        val sortCosts = costs.sorted()
        var moneySpend = 0
        var ind = 0
        while (moneySpend<=money && ind < sortCosts.size) {
            moneySpend += sortCosts[ind]
            ind++
        }
        return if (moneySpend>money) ind-1 else ind
    }

    fun mainIO(inputStream: InputStream, outputStream: OutputStream) {
        val br = inputStream.bufferedReader()

        val n: Int = br.readLine()?.toInt() ?: return
        for (nn in 1..n) {
            val m1:List<Int> = br.readLine()?.split(" ")?.map { it.toInt() } ?: return
            val m2:List<Int> = br.readLine()?.split(" ")?.map { it.toInt() } ?: return
            PrintStream(outputStream).println("Case #$nn: ${solve(m1[1],m2)}")
        }
    }

    fun main() {
        mainIO(System.`in`,System.out)
    }
}