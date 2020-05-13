class Task20 {
    fun spreadsheet(s: String): String {
        val rx1 = Regex("""([A-Z]+)(\d+)([A-Z]+)(\d+)""")
        val rx2 = Regex("""([A-Z]+)(\d+)""")

        if (rx1.matches(s)) {
            val matches = rx1.find(s)
            if (matches != null) {
                val vA = matches.groupValues[1]
                val tA = matches.groupValues[2].toInt()
                val vB = matches.groupValues[3]
                val tB = matches.groupValues[4].toInt()

                println("A: $vA = $tA B: $vB = $tB")
            }

        }

        if (rx2.matches(s)) {
            val matches = rx2.find(s)
            if (matches != null) {
                val vA = matches.groupValues[1]
                val tA = matches.groupValues[2].toInt()
                println("A: $vA = $tA")
            }
        }

        return ""
    }
}