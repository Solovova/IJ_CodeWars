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

//John and Mary want to travel between a few towns A, B, C ... Mary has on a sheet of paper a list of distances between these towns. ls = [50, 55, 57, 58, 60]. John is tired of driving and he says to Mary that he doesn't want to drive more than t = 174 miles and he will visit only 3 towns.
//
//Which distances, hence which towns, they will choose so that the sum of the distances is the biggest possible to please Mary and John?
//
//Example:
//
//With list ls and 3 towns to visit they can make a choice between: [50,55,57],[50,55,58],[50,55,60],[50,57,58],[50,57,60],[50,58,60],[55,57,58],[55,57,60],[55,58,60],[57,58,60].
//
//The sums of distances are then: 162, 163, 165, 165, 167, 168, 170, 172, 173, 175.
//
//The biggest possible sum taking a limit of 174 into account is then 173 and the distances of the 3 corresponding towns is [55, 58, 60].
//
//The function chooseBestSum (or choose_best_sum or ... depending on the language) will take as parameters t (maximum sum of distances, integer >= 0), k (number of towns to visit, k >= 1) and ls (list of distances, all distances are positive or null integers and this list has at least one element). The function returns the "best" sum ie the biggest possible sum of k distances less than or equal to the given limit t, if that sum exists, or otherwise nil, null, None, Nothing, depending on the language. With C++, C, Rust, Swift, Go, Kotlin return -1.
//
//Examples:
//
//ts = [50, 55, 56, 57, 58] choose_best_sum(163, 3, ts) -> 163
//
//xs = [50] choose_best_sum(163, 3, xs) -> nil (or null or ... or -1 (C++, C, Rust, Swift, Go)
//
//ys = [91, 74, 73, 85, 73, 81, 87] choose_best_sum(230, 3, ys) -> 228