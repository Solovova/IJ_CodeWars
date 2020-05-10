class Task04 {
    private fun getAtomsUp(formula: String): MutableMap<String, Int> {
        val result: MutableMap<String, Int> = mutableMapOf()

        var element = ""
        var quantity = 0

        var elNameStart = false
        var elNameStartWith = ""
        var elNameStartWithNumBre = 0
        var elNameEnd = false
        var ind = 0
        var trys = 0
        while (ind < formula.length) {
            trys++
            if (trys>400) throw  IllegalArgumentException()

            val char = formula[ind]
            println("$char $element $quantity $elNameStart $elNameStartWith $elNameEnd")
            //if (ind == 1) break
            if (elNameStart && elNameEnd) {
                if (char.isDigit()) {
                    quantity = quantity * 10 + char.toString().toInt()
                    ind++
                } else {
                    if (quantity == 0) quantity = 1
                    result[element] = (result[element]?:0)+quantity
                    element = ""
                    quantity = 0
                    elNameStart = false
                    elNameStartWith = ""
                    elNameEnd = false
                    elNameStartWithNumBre = 0
                }
            }

            if (!elNameStart) {
                if (char == '(') {
                    elNameStart = true
                    elNameEnd = false
                    elNameStartWith = "("
                    element = ""
                    ind++
                }

                if (char == '{') {
                    elNameStart = true
                    elNameEnd = false
                    elNameStartWith = "{"
                    element = ""
                    ind++
                }

                if (char == '[') {
                    elNameStart = true
                    elNameEnd = false
                    elNameStartWith = "["
                    element = ""
                    ind++
                }
                if (char.isLetter() && char.isUpperCase()) {
                    elNameStart = true
                    elNameEnd = false
                    elNameStartWith = ""
                    element = char.toString()
                    ind++
                }
            } else {
                if (!elNameEnd) {
                    if (elNameStartWith == "(" && char == '(') {
                        elNameStartWithNumBre ++
                    }

                    if (elNameStartWith == "(" && char == ')') {
                        elNameStartWithNumBre --
                    }

                    if (elNameStartWith == "[" && char == '[') {
                        elNameStartWithNumBre ++
                    }

                    if (elNameStartWith == "[" && char == ']') {
                        elNameStartWithNumBre --
                    }

                    if (elNameStartWith == "{" && char == '{') {
                        elNameStartWithNumBre ++
                    }

                    if (elNameStartWith == "{" && char == '}') {
                        elNameStartWithNumBre --
                    }


                    if (elNameStartWith == "(") {
                        if (char == ')' && elNameStartWithNumBre < 0) {
                            elNameEnd = true
                            ind++
                        } else {
                            element += char.toString()
                            ind++
                        }
                    }
                    if (elNameStartWith == "[") {
                        if (char == ']'  && elNameStartWithNumBre < 0) {
                            elNameEnd = true
                            ind++
                        } else {
                            element += char.toString()
                            ind++
                        }
                    }

                    if (elNameStartWith == "{") {
                        if (char == '}'  && elNameStartWithNumBre < 0) {
                            elNameEnd = true
                            ind++
                        } else {
                            element += char.toString()
                            ind++
                        }
                    }

                    if (elNameStartWith == "") {
                        if (!char.isLetter()||(char.isLetter() && char.isUpperCase())) {
                            elNameEnd = true
                        } else {
                            element += char.toString()
                            ind++
                        }
                    }

                }
            }
        }

        if (quantity == 0) quantity = 1
        result[element] = (result[element]?:0)+quantity

        return result
    }

    fun getAtoms(formula: String): Map<String, Int> {
        println(formula)
        if (formula.none { it.isLetter() && it.isUpperCase() }) throw  IllegalArgumentException()

        if (formula.filter { it == '(' }.length != formula.filter { it == ')' }.length) throw  IllegalArgumentException()
        if (formula.filter { it == '[' }.length != formula.filter { it == ']' }.length) throw  IllegalArgumentException()
        if (formula.filter { it == '{' }.length != formula.filter { it == '}' }.length) throw  IllegalArgumentException()

        val result = getAtomsUp(formula)
        println(result)

        var needRepeat=true

        while (needRepeat) {
            needRepeat = false
            for (key in result.keys) {
                if (result[key] == 0) continue
                if (key.indexOf('(') != -1 || key.indexOf('[') != -1 || key.indexOf('{') != -1  || key.any { it.isDigit() }||key.filter { (it.isLetter() && it.isUpperCase()) }.length>1) {
                    println(key)
                    needRepeat = true
                    val tmpResult = getAtomsUp(key)
                    for (tmpKey in tmpResult.keys) {
                        result[tmpKey] = (result[tmpKey] ?: 0) + (tmpResult[tmpKey] ?: 0) * (result[key] ?: 0)
                    }
                    result[key] = 0
                    break
                }
            }
        }

        val keysForDel: MutableList<String> = mutableListOf()
        for (key in result.keys) {
            if (result[key] == 0) keysForDel.add(key)
        }

        for(keyForDel in keysForDel) result.remove(keyForDel)

        return result
    }


    fun getAtoms1(formula: String): Map<String, Int> {
        val result = mutableMapOf<String, Int>()
        val numbers = mutableListOf(1)
        var atom = ""; var digit = ""

        if ("\\{\\w*[\\]\\)]|\\(\\w*[\\]\\}]|\\[\\w*[\\}\\)]".toRegex().containsMatchIn(formula) ||
            formula.replace("\\w".toRegex(), "").length % 2 != 0) throw IllegalArgumentException()

        for (char in formula.reversed()) {
            when {
                char == ')' || char == ']' || char == '}' -> { numbers.add(digit.toIntOrNull() ?: 1); digit = "" }
                char == '(' || char == '[' || char == '{' -> numbers.removeAt(numbers.lastIndex)
                char.isDigit() -> digit = "$char$digit"
                char.isLowerCase() -> atom = "$char$atom"
                char.isUpperCase() -> {
                    atom = "$char$atom"
                    val count = numbers.reduce(Int::times) * (digit.toIntOrNull() ?: 1)
                    result[atom] = result[atom]?.let { it + count } ?: count
                    atom = ""; digit = ""
                }
            }
        }
        return result.takeIf { it.isNotEmpty() } ?: throw IllegalArgumentException()
    }
}