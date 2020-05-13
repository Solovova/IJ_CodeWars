package complete

import complete.Task22
import kotlin.test.assertEquals
import org.junit.Test

class TestTask22 {
    private val task: Task22 = Task22()
    @Test
    fun basicTests() {
        assertEquals(61000, task.past(0, 1, 1))
        assertEquals(3661000, task.past(1, 1, 1))
        assertEquals(0, task.past(0, 0, 0))
        assertEquals(3601000, task.past(1, 0, 1))
        assertEquals(3600000, task.past(1, 0, 0))
    }
}