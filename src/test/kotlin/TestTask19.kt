import org.junit.Test
import kotlin.test.assertEquals

class TestTask19 {
    private val task: Task19 = Task19()

    @Test
    fun sampleTests() {
        assertPathEquals("", "*")
        assertPathEquals("FFFFF", "******")
        assertPathEquals("FFFFFLFFFFFLFFFFFLFFFFFL", "******\r\n*    *\r\n*    *\r\n*    *\r\n*    *\r\n******")
        assertPathEquals("LFFFFFRFFFRFFFRFFFFFFF", "    ****\r\n    *  *\r\n    *  *\r\n********\r\n    *   \r\n    *   ")
        assertPathEquals("LF5RF3RF3RF7", "    ****\r\n    *  *\r\n    *  *\r\n********\r\n    *   \r\n    *   ")
    }

    private fun assertPathEquals(code: String, expected: String) {
        val actual = task.execute(code)
        assertEquals(expected, actual, "--------------\nCode: $code\nYou returned:\n$actual\nExpected path of robot:\n$expected\n--------------\n")
    }
}