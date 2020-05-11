package complete

import kotlin.math.abs
import kotlin.math.exp

class Task09 {
    private fun getDyx(x: Double, y:Double):Double = 2 - exp(-4*x) - 2*y
    private fun getZY(x: Double):Double = 1 + 0.5*exp(-4*x) - 0.5*exp(-2*x)

    fun exEuler(nb: Int): Double {
        var x:Double = 0.0
        var y:Double = 1.0
        var h:Double = 1.0/nb
        var aK:Double = 0.0

        for (i in 1..nb){
            val dyx = getDyx(x,y)
            x += h
            y += h*dyx
            val zy = getZY(x)
            println("$x $y $dyx $zy $h")
            aK += abs(y-zy)/zy
        }
        return aK/(nb+1)
    }
}