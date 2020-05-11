package complete

class Task03 {
    private fun getH(v: Double, t: Int):Double {
        return v*t*0.1 - 0.5*9.81*t*t*0.01
    }

    fun maxBall(v0:Int):Int {
        var t = 0
        var hPrev: Double = getH(v0.toDouble()/3.6,t)
        while (true){
            t++
            val hNext: Double = getH(v0.toDouble()/3.6,t)
            if(hNext<hPrev) {
                break
            }else{
                hPrev = hNext
            }
        }
        return t-1
    }

    fun maxBall1(v0:Int):Int {
        return Math.round((v0 / 3.6).toDouble() / 0.981).toInt()
    }
}