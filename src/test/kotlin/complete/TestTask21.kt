package complete

import complete.Task21
import kotlin.test.assertEquals
import org.junit.Test

class TestTask21 {
    private val task: Task21 = Task21()
    
    @Test
    fun checkSmallValues() {
        assertEquals(6, task.expressionsMatter(2, 1, 2))
        assertEquals(3, task.expressionsMatter(1, 1, 1))
        assertEquals(4, task.expressionsMatter(2, 1, 1))
        assertEquals(9, task.expressionsMatter(1, 2, 3))
        assertEquals(5, task.expressionsMatter(1, 3, 1))
        assertEquals(8, task.expressionsMatter(2, 2, 2))
    }

    @Test
    fun checkIntermediateValues() {
        assertEquals( 20, task.expressionsMatter(5, 1, 3))
        assertEquals(105, task.expressionsMatter(3, 5, 7))
        assertEquals( 35, task.expressionsMatter(5, 6, 1))
        assertEquals(  8, task.expressionsMatter(1, 6, 1))
        assertEquals( 14, task.expressionsMatter(2, 6, 1))
        assertEquals( 48, task.expressionsMatter(6, 7, 1))
    }

    @Test
    fun checkMixedValues() {
        assertEquals( 60, task.expressionsMatter( 2, 10,  3))
        assertEquals( 27, task.expressionsMatter( 1,  8,  3))
        assertEquals(126, task.expressionsMatter( 9,  7,  2))
        assertEquals( 20, task.expressionsMatter( 1,  1, 10))
        assertEquals( 18, task.expressionsMatter( 9,  1,  1))
        assertEquals(300, task.expressionsMatter(10,  5,  6))
        assertEquals( 12, task.expressionsMatter( 1, 10,  1))
    }
}