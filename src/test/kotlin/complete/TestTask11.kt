package complete

import org.junit.Test
import kotlin.test.assertEquals

class TestTask11 {
    private val task: Task11 = Task11()

    @Test
    fun sampleTests() {
        assertEquals(listOf("e", "d", "a"), task.top3("a a a  b  c c  d d d d  e e e e e"))
        assertEquals(listOf("e", "ddd", "aa"), task.top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e"))
        assertEquals(listOf("won't", "wont"), task.top3("  //wont won't won't "))
        assertEquals(listOf("e"), task.top3("  , e   .. "))
        assertEquals(emptyList(), task.top3("  ...  "))
        assertEquals(emptyList(), task.top3("  '  "))
        assertEquals(emptyList(), task.top3("  '''  "))
        assertEquals(listOf("a", "of", "on"), task.top3(sequenceOf(
            "In a village of La Mancha, the name of which I have no desire to call to",
            "mind, there lived not long since one of those gentlemen that keep a lance",
            "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
            "coursing. An olla of rather more beef than mutton, a salad on most",
            "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
            "on Sundays, made away with three-quarters of his income."
        ).joinToString("\n")))
    }
}