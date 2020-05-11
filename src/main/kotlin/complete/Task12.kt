package complete

import kotlin.math.cos
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

class Task12 {
    fun rectangleRotation(a: Int, b: Int): Int {
        val ta:Double = a * cos(Math.PI/4)
        val tb:Double = b * cos(Math.PI/4)
        val td: Int = ((a+b)/2*cos(Math.PI/4)).toInt()

        println("$a   $b")
        println("$ta  $tb  $td")
        var sum = 0

        for (x in -td..td) {
            val upY = min((1-x/ta)*ta,(1+x/tb)*tb)
            val downY = max(-(1+x/ta)*ta,-(1-x/tb)*tb)

            //println("$x $downY $upY")
            val intUpY:Int = if (upY<0) upY.toInt()-1 else upY.toInt()
            val intDownY:Int = if (downY>0) downY.toInt()+1 else downY.toInt()

            //println("$x $intDownY $intUpY")
            sum += (intUpY-intDownY)+1
        }
        return sum
    }
}