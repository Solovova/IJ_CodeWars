package complete

class Task11 {
    fun top3(s: String): List<String> {
        println("__________________________________________________")
        println(s)

        val counter: MutableMap<String,Int> = mutableMapOf()
        val result: MutableList<String> = mutableListOf()
        val words=s.toLowerCase().split(" ","//",",",".","!","_",";","?","/","-",":","}","{")
        for (word in words) {
            var tWord= word.trim()
//            val lastDel = tWord.takeLastWhile { !it.isLetter() }
//            val startDel = tWord.takeWhile { !it.isLetter() }
//
//            if (lastDel.isNotEmpty()) tWord = tWord.removeRange(tWord.length-lastDel.length,tWord.length)
//            if (startDel.isNotEmpty()) tWord = tWord.removeRange(0,startDel.length)


            if (tWord.isNotEmpty() && tWord.any { it.isLetter() }) {
                counter[tWord] = 1 + (counter[tWord] ?: 0)
            }

        }

        println(counter)
        for (i in 0..2) {
            val maxWord:String = counter.maxBy { it.value }?.key ?: ""
            //println(maxWord)
            if (maxWord.isNotEmpty()) {
                result.add(maxWord)
                counter.remove(maxWord)
            }
        }

        return result
    }

    fun top31(s: String): List<String> =
        s.toLowerCase()
            .split("[^a-z']+".toRegex())
            .filter { it.contains("[a-z]".toRegex()) }
            .groupingBy { it }
            .eachCount()
            .entries
            .sortedByDescending { it.value }
            .take(3)
            .map { it.key }
}