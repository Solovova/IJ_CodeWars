package complete

import complete.Task20
import kotlin.test.assertEquals
import org.junit.Test

class TestTask20 {
    private val task: Task20 = Task20()
    @Test
    fun testFixed() {
        assertEquals("R1C1", task.spreadsheet("A1"))
        assertEquals("A1", task.spreadsheet("R1C1"))
        assertEquals("D5", task.spreadsheet("R5C4"))
        assertEquals("R48C27", task.spreadsheet("AA48"))
        assertEquals("R12C63", task.spreadsheet("BK12"))
        assertEquals("BK12", task.spreadsheet("R12C63"))
        assertEquals("Z85", task.spreadsheet("R85C26"))
        assertEquals("BZ31", task.spreadsheet("R31C78"))
        assertEquals("R31C78", task.spreadsheet("BZ31"))
    }
}