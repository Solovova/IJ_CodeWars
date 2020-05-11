package complete

class Task13 {
    fun nextBiggerNumber(n: Long): Long {
        val digits: MutableList<Long> = mutableListOf()
        var tn: Long = n
        while (tn > 0) {
            digits.add(tn % 10)
            tn /= 10
        }
        for (i in 1 until digits.size) {

            var minD:Long = 10
            var indMinD = -1
            for (j in 0 until i) {
                if (digits[j]>digits[i] && digits[j]<minD) {
                    minD=digits[j]
                    indMinD=j
                }
            }

            if (indMinD!=-1) {
                val tmp = digits[i]
                digits[i] = digits[indMinD]
                digits[indMinD] = tmp

                //Sort all below i
                var needRepeat = true
                while (needRepeat) {
                    needRepeat = false
                    for (j in 0 until i-1) {
                        if (digits[j]<digits[j+1]) {
                            val tmp = digits[j]
                            digits[j] = digits[j+1]
                            digits[j+1] = tmp
                            needRepeat = true
                        }
                    }
                }

                var result: Long = 0
                for (digit in digits.reversed()) result = result * 10 + digit
                return result
            }
        }
        return -1
    }

    fun nextBiggerNumber1(n: Long): Long {
        val text = n.toString().toMutableList()
        for (i in text.size - 2 downTo 0) {
            if (text[i] < text[i + 1]) {
                val tail = text.subList(i + 1, text.size)
                val min = tail.withIndex().filter { it.value > text[i] }.minBy { it.value }!!
                text[i + 1 + min.index] = text[i]
                text[i] = min.value
                tail.sort()
                return text.joinToString("").toLong()
            }
        }
        return -1
    }
}