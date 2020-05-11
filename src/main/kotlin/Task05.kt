class Task05 {
    private fun nextIndex(ind: MutableList<Int>, maxInd: Int): Boolean {
        var indPointer = ind.size - 1
        while (true) {
            if (ind[indPointer] < maxInd-(ind.size - 1-indPointer)) {
                ind[indPointer]++
                for (i in (indPointer+1) until ind.size) {
                    ind[i]=ind[indPointer]+i-indPointer
                }
                return true
            }else{
                indPointer--
                if (indPointer<0) return false
            }
        }
    }

    fun chooseBestSum(t: Int, k: Int, ls: List<Int>): Int {
        println("$t $k $ls")
        if (k>ls.size) return -1
        val ind: MutableList<Int> = MutableList(k) { it }
        var maxSum = 0

        var needRepeat = true
        while (needRepeat) {
            val sum = ind.map { ls[it] }.sum()
            if (sum in (maxSum + 1)..t) maxSum=sum
            needRepeat = nextIndex(ind, ls.size-1)
        }
        if (maxSum==0) return -1
        println(maxSum)
        return maxSum
    }

    fun chooseBestSum1(t:Int, k:Int, ls:List<Int>):Int {
        fun calcBest(startFrom: Int, accumulated: Int, k: Int): Int {
            if (ls.size - startFrom < k) return -1
            if (accumulated > t) return -1
            if (k == 0) return accumulated
            return calcBest(startFrom + 1, accumulated + ls[startFrom], k - 1)
                .coerceAtLeast(calcBest(startFrom + 1, accumulated, k))
        }
        return calcBest(0, 0, k)
    }

//    fun chooseBestSum2(t:Int, k:Int, ls:List<Int>, traveled: Int = 0):Int {
//        if(k == 0) return if(traveled <= t) traveled else -1
//        return ls.mapIndexed { i, d -> chooseBestSum(t, k-1, ls.subList(i+1, ls.size), traveled + d) }.max() ?: -1
//    }
}

