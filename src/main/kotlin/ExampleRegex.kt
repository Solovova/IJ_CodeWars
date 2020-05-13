class ExampleRegex {

    fun ex1() {
        val str = "rtt6781fggf667"
        val rx = Regex(pattern = """\d{3}""")
        println("matches:" + rx.matches(str))
        println("containsMatchIn:"+rx.containsMatchIn(str))
        println("split:"+rx.split(str))
        println("split 1:"+rx.split(str,1))
        println("replace:"+rx.replace(str,"1"))

        val text = "Hello Alice.. Hello Bob. Hello Eve."
        val regex = Regex("Hello (.*?)[.]+")
        val matches = regex.findAll(text)
        val names = matches.map { it.groupValues[1] }.joinToString()
        println("findAll:$names") // Alice, Bob, Eve

        val rx1 = Regex(pattern = """\w{0,50}""")
        println(rx1.matchEntire(str) ?: 0)


        val str2 = "A34B56 Z3Y556"
        val rx2 = Regex("""([A-Z]+)(\d+)([A-Z]+)(\d+)\s*""")
        println("matches str2:" + rx2.matches(str2))
        val matches2 = rx2.findAll(str2)
        val names2 = matches2.map { it.groupValues[0]}.joinToString ( "|" )
        println("findAll 2:$names2")

        val matches3 = rx2.find(str2,7)
        println(matches3?.groups)
    }

}

//https://www.fandroid.info/6-5-osnovy-kotlin-doktor-regexp/
//https://riptutorial.com/ru/kotlin/example/32686/%D0%B2%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B2-%D1%80%D0%B5%D0%B3%D1%83%D0%BB%D1%8F%D1%80%D0%BD%D1%8B%D0%B5-%D0%B2%D1%8B%D1%80%D0%B0%D0%B6%D0%B5%D0%BD%D0%B8%D1%8F-%D0%B2-%D0%BA%D0%BE%D1%82%D0%BB%D0%B8%D0%BD%D0%B5