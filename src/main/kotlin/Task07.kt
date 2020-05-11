class Task07 {
    fun incrementString(str: String) : String {
        if (str.isEmpty()) return "1"

        var ind = str.length-1
        while (true) {
            if (!str[ind].isDigit()) break
            ind--
            if (ind==-1) break
        }

        val strText = str.subSequence(0,ind+1).toString()
        var strDig = str.subSequence(ind+1,str.length).toString()
        println("$strText:$strDig")
        if (strDig=="") strDig="0"

        var strDigNew:String = (strDig.toInt()+1).toString()
        if (strDig.length>strDigNew.length) {
            strDigNew = strDigNew.padStart(strDig.length,'0')
        }
        println("$strDigNew")


        return "$strText$strDigNew"
    }

    fun incrementString1(str: String) : String {
        val i = str.takeLastWhile { it.isDigit() }
        return str.dropLast(i.length) + ((i.toIntOrNull() ?: 0) + 1).toString().padStart(i.length, '0')
    }
}