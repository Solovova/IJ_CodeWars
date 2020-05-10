import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TestTask02 {
    private val task: Task02 = Task02()

    @Test
    fun addition() {
        assertEquals(listOf(1, 12, 0, 4, 6, 1), task.sumConsecutives(listOf(1, 4, 4, 4, 0, 4, 3, 3, 1)))
        assertEquals(listOf(2, 14, 3), task.sumConsecutives(listOf(1, 1, 7, 7, 3)))
        assertEquals(listOf(-10, 14, 12, 0), task.sumConsecutives(listOf(-5, -5, 7, 7, 12, 0)))
        assertEquals(listOf(12, 1), task.sumConsecutives(listOf(3, 3, 3, 3, 1)))
    }
}