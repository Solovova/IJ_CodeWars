class GRoundA2020_Allocation {
    private fun solve(n: Int, money: Int, costs: List<Int>): Int {
        val sortCosts = costs.sorted()
        var moneySpend = 0
        var ind = 0
        while (moneySpend<=money && ind < sortCosts.size) {
            moneySpend += sortCosts[ind]
            ind++
        }
        return if (moneySpend>money) ind-1 else ind
    }

    fun main() {
        val n: Int = readLine()?.toInt() ?: return
        for (nn in 1..n) {
            val m1:List<Int> = readLine()?.split(" ")?.map { it.toInt() } ?: return
            val m2:List<Int> = readLine()?.split(" ")?.map { it.toInt() } ?: return
            println("Case #$nn: ${solve(m1[0],m1[1],m2)}")
        }
    }

    fun run():String {
        return solve(4,50, listOf(30,30,10,10)).toString()
    }


}