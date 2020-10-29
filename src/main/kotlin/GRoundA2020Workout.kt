import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream

class GRoundA2020Workout {
    private fun isOpt(diffs: List<Int>,dOpt: Int,K: Int):Boolean {
        var needK = 0
        for (diff in diffs) {
            needK += diff / dOpt - 1 + (if (diff % dOpt > 0) 1 else 0)
            if (needK>K) {break}
        }
        return (needK<=K)
    }

    private fun solve(N: Int, K: Int, trains: List<Int>): Int {
        val diffs = trains.mapIndexedNotNull { index, i ->
            return@mapIndexedNotNull if (index==0) {
                null
            }else{
                i-trains[index-1]
            }
        }
        var maxDiff: Int = diffs.max() ?: 0
        var minDiff = 1

        while ((maxDiff - minDiff) > 1) {
            val checkDiff = (maxDiff + minDiff) / 2
            if (isOpt(diffs,checkDiff, K)) {
                maxDiff = checkDiff
            }else{
                minDiff = checkDiff
            }
        }
        return if (isOpt(diffs,minDiff, K))  minDiff else maxDiff
    }

    fun mainIO(inputStream: InputStream, outputStream: OutputStream) {
        val br = inputStream.bufferedReader()

        val n: Int = br.readLine()?.toInt() ?: return
        for (nn in 1..n) {
            val m1:Array<Int> = br.readLine()?.split(" ")?.map { it.toInt() }?.toTypedArray() ?: return
            val m2:List<Int> = br.readLine()?.split(" ")?.map { it.toInt() } ?: return
            PrintStream(outputStream).println("Case #$nn: ${solve(m1[0],m1[1], m2)}")
        }
    }

    fun main() {
        mainIO(System.`in`, System.out)
    }

    fun sTest() {
        //println(solve(5,2, listOf(10,13,15,16,17)))
        println(solve(5,6, listOf(9,10,20,26,30)))
        //println(solve(8,2, listOf(1,2,3,4,5,6,7,11)))

        //        val mTrains = trains.toMutableList()
//        var intervals = K
//        while (intervals>0) {
//            for (i in 1 until mTrains.size) {
//                val diff = mTrains[i] - mTrains[i-1]
//                if (diff>dOpt) {
//                    intervals--
//                    mTrains.add(i,mTrains[i-1]+dOpt)
//                }
//            }
//        }
//
//        pri
    }
}