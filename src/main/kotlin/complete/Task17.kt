package complete

class Task17 {
    fun interpret(program: Array<String>): Map<String, Int> {
        val reg:MutableMap<String,Int> = mutableMapOf ()

        var pointer = 0
        while (true) {
            val list = program[pointer].split(" ")
            println("$list $reg $pointer")
            when (list[0]) {
                "mov" -> {
                    if (list[2].any { it.isLetter() }) {
                        reg[list[1]] = (reg[list[2]] ?: 0)
                    }else{
                        reg[list[1]] = list[2].toInt()
                    }
                    pointer++
                }
                "inc" -> {
                    reg[list[1]] = (reg[list[1]] ?: 0) + 1
                    pointer++
                }
                "dec" -> {
                    reg[list[1]] = (reg[list[1]] ?: 0) - 1
                    pointer++
                }
                "jnz" -> {
                    if (list[1].any { it.isLetter() }) {
                        if ((reg[list[1]] ?: 0)!=0) {
                            pointer += list[2].toInt()
                        }else{
                            pointer++
                        }
                    }else{
                        if (list[1].toInt()!=0) {
                            pointer += list[2].toInt()
                        }else{
                            pointer++
                        }
                    }


                }

            }

            if (pointer>=program.size) break
            if (pointer<0) pointer=0
        }

        return reg
    }

    fun interpret1(program: Array<String>): Map<String, Int> {
        val registers = mutableMapOf<String, Int>()
        val getJustIntOrRegister = {key: String ->
            key.toIntOrNull() ?: registers.getOrDefault(key, 0)
        }

        var i = 0
        while (i < program.size) {
            val cmd = program[i].split(" ")
            val (op, dst) = cmd.take(2)

            when (op) {
                "mov" -> registers[dst] = getJustIntOrRegister(cmd[2])
                "inc" -> registers[dst] = registers.getValue(dst) + 1
                "dec" -> registers[dst] = registers.getValue(dst) - 1
                "jnz" -> {
                    if (getJustIntOrRegister(dst) != 0)
                        i += cmd[2].toInt() - 1
                }
            }

            i++
        }
        return registers
    }
}