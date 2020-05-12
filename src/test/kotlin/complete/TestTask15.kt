package complete

import complete.Task15
import kotlin.test.assertEquals
import org.junit.Test

class TestTask15 {
    private val task: Task15 = Task15()
    @Test
    fun basicTests() {
        assertEquals(4, task.josephusSurvivor(7, 3))
        assertEquals(10, task.josephusSurvivor(11, 19))
        assertEquals(28, task.josephusSurvivor(40, 3))
        assertEquals(13, task.josephusSurvivor(14, 2))
        assertEquals(100, task.josephusSurvivor(100, 1))
        assertEquals(1, task.josephusSurvivor(1, 300))
        assertEquals(1, task.josephusSurvivor(2, 300))
        assertEquals(1, task.josephusSurvivor(5, 300))
        assertEquals(7, task.josephusSurvivor(7, 300))
        assertEquals(265, task.josephusSurvivor(300, 300))
    }
}