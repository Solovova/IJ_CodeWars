package complete

import kotlin.test.assertEquals
import org.junit.Test

class TestTask12 {
    private val task: Task12 = Task12()

    @Test
    fun basicTests() {
        assertEquals(23, task.rectangleRotation(6, 4))
        assertEquals(65, task.rectangleRotation(30, 2))
        assertEquals(49, task.rectangleRotation(8, 6))
        assertEquals(333, task.rectangleRotation(16, 20))
    }
}