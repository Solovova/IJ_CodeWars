import kotlin.math.sqrt

class Task01 {
    fun factors(l: Int): String {
        var result = ""
        var tl = l
        for (i in 2..(l/2)) {
            var count = 0
            while (tl % i == 0) {
                count ++
                tl /= i
            }
            if (count>=1) result += "($i${if (count > 1) "**$count" else ""})"
            if (tl==1) break
        }

        if (result=="") result = "($l)"
        return result
    }
}