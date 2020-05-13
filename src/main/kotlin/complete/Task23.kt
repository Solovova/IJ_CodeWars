package complete

import kotlin.math.sqrt


class Task23 {
    private fun isPrime(n: Int, primes: List<Int>): Boolean {
        val sqrt = sqrt(n.toDouble())
        for (i in primes.indices) {
            val prime = primes[i]
            if (prime > sqrt) {
                return true
            }
            if (n % prime == 0) {
                return false
            }
        }
        return true
    }

    private fun getPrimes(max: Int): List<Int> {
        val primes: MutableList<Int> = ArrayList()
        primes.add(2)
        var i = 3
        while (i < max) {
            if (isPrime(i, primes)) {
                primes.add(i)
            }
            i += 2
        }
        return primes
    }

    fun sumOfDivided(l: IntArray): String {
        val maxEl: Int = l.map { if (it<0) -it else it }.max()?:0
        val primes = getPrimes(maxEl)
        val result:List<List<Int>> = List(primes.size) {prime ->
            l.filter { it%primes[prime]==0 }
        }
        return result.withIndex().filter { it.value.isNotEmpty() }
            .joinToString("") { "(${primes[it.index]} ${it.value.sum()})" }
    }
}