package complete

import complete.Task18
import org.junit.Assert.*
import org.junit.Test

class TestTask18 {
    private val task: Task18 = Task18()


    @Test
    fun exampleTests() {
        assertEquals("You {{need}} <extra> time ( or money )", task.f("You }}need{{ >extra< time ) or money ("))
        assertEquals("<br/>", task.f(">br/<"))
    }
}