import java.awt.Point

class Task08 {
    private fun formatRange(start: Int, end: Int): String {
        if (end==start) return "$end"
        if (end-start==1) return "$start,$end"
        return "$start-$end"
    }

    fun rangeExtraction(arr: IntArray): String {
        var result =""
        var ind = 0
        var indSt = 0
        while (true) {
            if (arr[indSt] != (arr[ind] - (ind-indSt))) {
                println("${arr[indSt]}:${arr[ind-1]}")
                result = "$result${formatRange(arr[indSt],arr[ind-1])},"
                indSt = ind
            }
            if (ind<(arr.size-1)) {
                ind++
            }else{
                println("${arr[indSt]}:${arr[ind]}")
                result = "$result${formatRange(arr[indSt],arr[ind])}"
                break
            }
        }

        return result
    }

    fun rangeExtraction1(arr: IntArray): String {
        val ranges = mutableListOf<Point>()
        for (n in arr) {
            val last = ranges.lastOrNull() ?: Point(n, n).also { ranges += it }
            if (n - last.y <= 1) last.y = n
            else ranges.add(Point(n, n))
        }

        return ranges.joinToString(",") {
            it.x.toString() + when {
                it.y - it.x >= 2 -> "-${it.y}"
                it.y - it.x >= 1 -> ",${it.y}"
                else -> ""
            }
        }
    }
}