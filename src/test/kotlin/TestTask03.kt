import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TestTask03 {
    private val task: Task03 = Task03()

    private fun testing(actual:Int, expected:Int) {
        assertEquals(expected.toLong(), actual.toLong())
    }

    @Test
    fun addition() {
        println("Fixed Tests maxBall")
        testing(task.maxBall(37), 10)
        testing(task.maxBall(45), 13)
    }
}