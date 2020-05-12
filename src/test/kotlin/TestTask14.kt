import complete.Task13
import org.junit.Test

import java.util.Arrays
import java.util.Random

import org.junit.Assert.*

class TestTask14 {
    private val task: Task14 = Task14()

    @Test
    fun fixedTests() {
        assertEquals("", task.lcs("", ""))
        assertEquals("", task.lcs("abc", ""))
        assertEquals("", task.lcs("", "abc"))
        assertEquals("", task.lcs("a", "b"))
        assertEquals("a", task.lcs("a", "a"))
        assertEquals("ac", task.lcs("abc", "ac"))
        assertEquals("abc", task.lcs("abcdef", "abc"))
        assertEquals("acf", task.lcs("abcdef", "acf"))
        assertEquals("nottest", task.lcs("anothertest", "notatest"))
        assertEquals("12356", task.lcs("132535365", "123456789"))
        assertEquals("final", task.lcs("nothardlythefinaltest", "zzzfinallyzzz"))
        assertEquals("acdefghijklmnoq", task.lcs("abcdefghijklmnopq", "apcdefghijklmnobq"))
    }

}