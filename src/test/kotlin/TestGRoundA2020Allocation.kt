import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.ByteArrayOutputStream

internal class TestGRoundA2020Allocation {
    private val task: GRoundA2020Allocation = GRoundA2020Allocation()


    @Test
    fun addition() {
        val input = "3\n" +
                "4 100\n" +
                "20 90 40 90\n" +
                "4 50\n" +
                "30 30 10 10\n" +
                "3 300\n" +
                "999 999 999"
        val outputCorrect = "Case #1: 2\r\n" +
                "Case #2: 3\r\n" +
                "Case #3: 0\r\n"

        val inputStream = input.byteInputStream()
        val outputStream = ByteArrayOutputStream()

        task.mainIO(inputStream, outputStream)
        assertEquals(String(outputStream.toByteArray()), outputCorrect)
    }
}