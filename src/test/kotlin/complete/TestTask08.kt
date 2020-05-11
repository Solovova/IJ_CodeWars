package complete

import complete.Task08
import org.junit.Test
import kotlin.test.assertEquals

class TestTask08 {
    private val task: Task08 = Task08()
    @Test
    fun basicTests() {
        assertEquals("-6,-3-1,3-5,7-11,14,15,17-20", task.rangeExtraction(intArrayOf(-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20)))
        assertEquals("-3--1,2,10,15,16,18-20", task.rangeExtraction(intArrayOf(-3, -2, -1, 2, 10, 15, 16, 18, 19, 20)))
    }
}