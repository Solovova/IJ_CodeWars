class Task02 {
    fun sumConsecutives1(s: List<Int>): List<Int> {
        var prev: Int? = null
        var sum = 0
        val result:MutableList<Int> = mutableListOf()
        s.forEach {
            if (prev==null) {
                prev = it
                sum = it
            }else{
                if (prev == it) {
                    sum += it
                }else{
                    result.add(sum)
                    prev = it
                    sum = it
                }
            }
        }
        result.add(sum)
        return result
    }

    fun sumConsecutives2(s: List<Int>): List<Int> {
        return if (s.size <= 1) s else sumConsecutives2(s.dropLastWhile { it == s.last() }) + s.takeLastWhile { it == s.last() }.sum()
    }

    fun sumConsecutives(s: List<Int>) = mutableListOf(s[0]).apply {
        (1..s.lastIndex).forEach { if (s[it] == s[it - 1]) this[lastIndex] += s[it] else add(s[it]) }
    }
}

