package complete

import org.junit.Test
import kotlin.test.assertEquals

class TestTask13 {
    private val task: Task13 = Task13()

    @Test
    fun basicTests() {
        assertEquals(21, task.nextBiggerNumber(12))
        assertEquals(531, task.nextBiggerNumber(513))
        assertEquals(2071, task.nextBiggerNumber(2017))
        assertEquals(441, task.nextBiggerNumber(414))
        assertEquals(414, task.nextBiggerNumber(144))
    }
}