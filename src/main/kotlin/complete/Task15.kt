package complete

class Task15 {
    fun josephusSurvivor(n: Int, k: Int): Int {
        val list:MutableList<Int> = MutableList(n) {it+1}
        var deletedIndex = 1
        while (list.size>1) {
            deletedIndex = deletedIndex+k-1
            while (deletedIndex>list.size) deletedIndex -=list.size
            list.removeAt(deletedIndex-1)
        }
        return list[0]
    }

    fun josephusSurvivor1(n: Int, k: Int): Int = if (n == 1) 1 else (josephusSurvivor(n - 1, k) + k - 1) % n + 1
}