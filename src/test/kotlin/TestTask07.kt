import complete.Task01
import kotlin.test.assertEquals
import org.junit.Test

class TestTask07 {
    private val task: Task07 = Task07()
    @Test
    fun fixedTests() {
        assertEquals(task.incrementString("foobar000"), "foobar001")
        assertEquals(task.incrementString("foobar999"), "foobar1000")
        assertEquals(task.incrementString("foobar00999"), "foobar01000")
        assertEquals(task.incrementString("foo"), "foo1")
        assertEquals(task.incrementString("foobar001"), "foobar002")
        assertEquals(task.incrementString("foobar1"), "foobar2")
        assertEquals(task.incrementString("1"), "2")
        assertEquals(task.incrementString(""), "1")
        assertEquals(task.incrementString("009"), "010")
    }
}