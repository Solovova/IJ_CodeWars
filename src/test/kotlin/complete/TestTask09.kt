package complete

import complete.Task09
import java.text.DecimalFormat
import org.junit.Test
import kotlin.test.assertEquals

class TestTask09 {
    private val task: Task09 = Task09()

    private fun assertFuzzy(exp:Double, act:Double) {
        val inrange = Math.abs(act - exp) <= 1e-6
        if (!inrange)
        {
            val df = DecimalFormat("\"#.000000\"")
            println("At 1e-6: Expected must be " + df.format(exp) + ", but got " + df.format(act))
        }
        assertEquals(true, inrange)
    }
    @Test
    fun test1() {
        assertFuzzy(0.5, task.exEuler(1))
        assertFuzzy(0.026314, task.exEuler(10))
        assertFuzzy(0.015193, task.exEuler(17))

    }
}