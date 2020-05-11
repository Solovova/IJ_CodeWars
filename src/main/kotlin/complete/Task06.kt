package complete

class Task06 {
    fun findEvenIndex(arr: IntArray): Int {
        var sumLeftSide = 0
        var sumRightSide = arr.filterIndexed { index, _ -> index > 0 }.sum()
        var ind = 0
        while (true) {
            println("$sumLeftSide  $ind $sumRightSide")
            if (sumLeftSide == sumRightSide) return ind
            if (ind == (arr.size - 1)) break
            ind++
            sumLeftSide += arr[ind - 1]
            sumRightSide -= arr[ind]
        }
        return -1
    }

    fun findEvenIndex1(arr: IntArray) = arr.indices.indexOfFirst { arr.take(it).sum() == arr.drop(it + 1).sum() }
}