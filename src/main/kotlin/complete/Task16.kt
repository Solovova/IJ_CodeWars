package complete

import java.util.*
import kotlin.math.sqrt

class Task16 {
    fun decompose(n: Long): String {
        val list:MutableList<Long> = mutableListOf()
        val correction = MutableList(100) {0}
        correction[0]=1
        var lastCorrected = 0

        while (true) {
            var prevSq:Long = n*n
            list.clear()
            while (true) {
                val nextDigit: Long = sqrt(prevSq.toDouble()).toLong() - correction[list.size]
                list.add(nextDigit)
                prevSq -= nextDigit * nextDigit
                if (prevSq == 0L) break
            }
            if (list.asSequence().zipWithNext{a,b -> a>b}.all { it }) break

            if(list.asSequence().zipWithNext{a,b -> a>=b}.all { it }){
                lastCorrected++
                correction[lastCorrected]=1
            }else{
                correction[lastCorrected]=0
                lastCorrected--
                if (lastCorrected<0) return "null"
                correction[lastCorrected]++
            }

        }

        val result =StringJoiner(" ")
        list.asReversed().forEach { result.add(it.toString()) }
        return result.toString()
    }

    fun Long.sqrt(): Long = sqrt(this.toDouble()).toLong()
    fun Long.sqr(): Long = this * this
    fun Long.isSquare(): Boolean = this == this.sqrt().sqr()
    fun decompose1(n: Long): String {
        val result = decomposeSquare1(n.sqr(), true)
        return if(result.isEmpty()) "null" else result.sorted().joinToString(" ")
    }
    fun decomposeSquare1(number: Long, firstIt: Boolean = false) : Set<Long> {
        val startIt = number.sqrt() - if (firstIt) 1 else 0
        if (number.isSquare() && !firstIt) return setOf(number.sqrt())
        for (probe in startIt downTo 2) {
            val profile = decomposeSquare1(number - probe.sqr())
            if (profile.isEmpty() || probe in profile) continue
            return profile.union(setOf(probe))
        }
        return setOf()
    }
}