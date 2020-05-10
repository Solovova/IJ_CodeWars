import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TestTask01 {
    private val task: Task01 = Task01()

    @Test
    fun addition() {
        assertEquals(2, task.add1(1))
    }
}