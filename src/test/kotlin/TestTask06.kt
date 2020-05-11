import org.junit.Assert.*
import java.util.ArrayList
import org.junit.Test
class TestTask06 {
    private val task: Task06 = Task06()

    @Test
    fun test() {
        assertEquals(3, task.findEvenIndex(intArrayOf(1, 2, 3, 4, 3, 2, 1)))
        assertEquals(1, task.findEvenIndex(intArrayOf(1, 100, 50, -51, 1, 1)))
        assertEquals(-1, task.findEvenIndex(intArrayOf(1, 2, 3, 4, 5, 6)))
        assertEquals(3, task.findEvenIndex(intArrayOf(20, 10, 30, 10, 10, 15, 35)))
        assertEquals(-1, task.findEvenIndex(intArrayOf(-8505, -5130, 1926, -9026)))
        assertEquals(1, task.findEvenIndex(intArrayOf(2824, 1774, -1490, -9084, -9696, 23094)))
        assertEquals(6, task.findEvenIndex(intArrayOf(4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4)))
    }
}