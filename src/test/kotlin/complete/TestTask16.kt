package complete

import complete.Task16Recursive
import org.junit.Test
import kotlin.test.assertEquals

class  TestTask16 {
    private val task: Task16Recursive = Task16Recursive()


    @Test
    fun basicTests() {
        assertEquals("[1,2,4,10]", task.decompose(11))
        assertEquals("[1, 3, 5, 8, 49]", task.decompose(50))

    }
}