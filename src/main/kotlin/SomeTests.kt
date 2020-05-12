class SomeTests {
    fun testMutableListDefaultValue() {
        val registers = mutableMapOf<String, Int>()
        val getJustIntOrRegister = {key: String ->
            key.toIntOrNull() ?: registers.getOrDefault(key, 0)
        }
        println(registers.getOrDefault("rer",0))
    }
}