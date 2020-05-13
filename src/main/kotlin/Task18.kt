class Task18 {
    fun f(s:String)=(s).map{val i="{}()<>".indexOf(it);if(i>=0)"}{)(><"[i]else it}.joinToString("")

    fun f1(s:String)=s.replace(Regex("[()><{}]")){")(<>}{"["()><{}".indexOf(it.value)]+""}
    fun f2(s:String)=s.map{"()<>{}".zip(")(><}{").toMap()[it]?:it}.joinToString("")
}