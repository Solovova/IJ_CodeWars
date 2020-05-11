package complete

import complete.Task10
import org.junit.Test

import org.junit.Assert.assertEquals

class TestTask10 {
    private val task: Task10 = Task10()

    @Test
    fun fixedTests() {
        assertEquals(task.encode("test"), "fPNKd")
        assertEquals(task.encode("Hello World!"), ">OwJh>Io0Tv!8PE")
        assertEquals(task.decode("fPNKd"), "test")
        assertEquals(task.decode(">OwJh>Io0Tv!8PE"), "Hello World!")
    }

}