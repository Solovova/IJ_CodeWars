import java.lang.StringBuilder

class Task20 {
    fun spreadsheet(s: String): String {
        val rx1 = Regex("""([R])(\d+)([C])(\d+)""")
        val rx2 = Regex("""([A-Z]+)(\d+)""")
        val nl:Int = 'Z'.toInt()-'A'.toInt()+1

        if (rx1.matches(s)) {
            val matches = rx1.find(s)
            if (matches != null) {
                val tA = matches.groupValues[2].toInt()
                var tB = matches.groupValues[4].toInt()


                val result = StringBuilder()
                while (true) {
                    result.append(((tB-1) % nl + 'A'.toInt()).toChar())
                    tB = (tB-1)/nl
                    if (tB==0) break
                }
                return "${result.reverse()}$tA"
            }
        }

        if (rx2.matches(s)) {
            val matches = rx2.find(s)
            if (matches != null) {
                val vA = matches.groupValues[1]
                val tA = matches.groupValues[2].toInt()
                var result: Int = 0
                vA.forEach { result = result*nl+(it.toInt()-'A'.toInt()+1) }
                return "R${tA}C${result}"
            }
        }
        return ""
    }

    fun spreadsheet2(s: String): String {
        val result = Regex("R(\\d+)C(\\d+)|(\\p{Alpha}+)(\\d+)").matchEntire(s)!!
        return if (result.groupValues[1].isNotEmpty()) {
            val r = result.groupValues[1]
            var c = result.groupValues[2].toInt() - 1
            val col = StringBuilder()
            while (c >= 0) {
                col.insert(0, (c % 26 + 'A'.toInt()).toChar())
                c = c / 26 - 1
            }
            col.toString() + r
        } else {
            val c = result.groupValues[3].map { it - '@' }.reduce { a, b -> a * 26 + b }
            val r = result.groupValues[4]
            "R${r}C$c"
        }
    }
}