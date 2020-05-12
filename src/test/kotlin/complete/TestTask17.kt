package complete

import org.junit.Test
import kotlin.test.assertEquals

class TestTask17 {
    private val task: Task17 = Task17()

    @Test
    fun simple1() {
        assertEquals(
            mapOf("a" to 1),
            task.interpret(arrayOf("mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a"))
        )
    }

    @Test
    fun simple2() {
        assertEquals(
            mapOf("a" to 0, "b" to -20),
            task.interpret(arrayOf("mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"))
        )
    }
}