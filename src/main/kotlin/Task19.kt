import java.lang.StringBuilder
import java.util.*

class Task19 {
    var x = 0
    var y = 0


    fun execute(code: String): String {
        var ind = 0
        val cord: MutableList<Pair<Int, Int>> = mutableListOf()
        var x = 0
        var y = 0
        var dir = 0//0R 1D 2L 3U
        cord.add(Pair(x, y))

        while (true) {
            var com = ""
            var rep = 0
            while (true) {
                if (ind >= code.length) break
                if (com.isNotEmpty() && code[ind].isLetter()) break
                if (com.isEmpty() && code[ind].isLetter()) com = code[ind].toString()
                if (code[ind].isDigit()) rep = rep * 10 + code[ind].toString().toInt()
                ind++
            }
            if (rep == 0) rep = 1

            when (com) {
                "L" -> {
                    dir += rep
                    dir %= 4
                }
                "R" -> {
                    dir -= (rep-1)%4+1-4
                    dir %= 4

                }
                "F" -> {
                    for (i in 1..rep) {
                        when(dir) {
                            0 -> x++
                            1 -> y--
                            2 -> x--
                            3 -> y++
                        }
                        cord.add(Pair(x, y))
                    }
                }
            }

            println("$com $rep $dir")
            if (ind >= code.length) break
        }
        println("$cord")
        val minX: Int = cord.map { it.first }.min() ?: 0
        val maxX: Int = cord.map { it.first }.max() ?: 0
        val minY: Int = cord.map { it.second }.min() ?: 0
        val maxY: Int = cord.map { it.second }.max() ?: 0

        val plane:MutableList<StringBuilder> = MutableList(maxY-minY+1) { StringBuilder((minX..maxX).joinToString("") { " " }) }
        for (c in cord)
            plane[c.second-minY][c.first-minX] = '*'
        val sj = StringJoiner("\r\n")
        for (line in plane) sj.add(line.toString())
        println("$plane")
        return sj.toString()
    }
}