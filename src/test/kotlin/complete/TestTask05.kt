package complete

import complete.Task05
import org.junit.Assert.*
import org.junit.Test
import java.util.ArrayList

class TestTask05 {
    private val task: Task05 = Task05()
    //----------------
    @Test
    fun basicTests1() {
        println("****** Basic Tests small numbers******")
        var ts = ArrayList<Int>(listOf<Int>(50, 55, 56, 57, 58))
        val n = task.chooseBestSum(163, 3, ts)
        assertEquals(163, n.toLong())
        ts = ArrayList<Int>(listOf<Int>(50))
        val m = task.chooseBestSum(163, 3, ts)
        assertEquals(-1, m)

    }

}