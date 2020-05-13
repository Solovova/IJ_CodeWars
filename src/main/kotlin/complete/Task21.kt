package complete

class Task21 {
    fun expressionsMatter(a: Int, b: Int, c: Int): Int = List(2 * 2 * 2) {
        var seed = it
        List(3) {
            (seed % 2).also { seed /= 2 }
        }
    }.map {
        var res = 0
        if (it[0] == 0) {
            res = if (it[1] == 0) a + b else a * b
            res = if (it[2] == 0) res + c else res * c
        } else {
            res = if (it[2] == 0) b + c else b * c
            res = if (it[1] == 0) res + a else res * a
        }
        res
    }.max() ?: -1

    fun expressionsMatter1(a : Int, b : Int, c : Int) = intArrayOf(a + b + c, a + b * c, a * b * c, a * b + c, (a + b) * c, a * (b + c)).max()
}