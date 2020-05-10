import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TestTask01 {
    private val task: Task01 = Task01()

    @Test
    fun addition() {
        assertEquals("(2**10)", task.factors(1024))
        assertEquals("(2**2)(3**3)(5)(7)(11**2)(17)", task.factors(7775460))
    }
}