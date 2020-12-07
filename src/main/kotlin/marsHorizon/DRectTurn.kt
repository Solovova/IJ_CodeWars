package marsHorizon


class DRectTurn(
    val recStart: DRect,
    val recNeed: DRect,
    val ops: MutableList<DRectOp>,
    val maxTurns: Int,
    val maxTurnsStep: Int,
    val turnForce: Int,
    val turnHeat: Int,
    val turnEmploy: Int,
    val steep: Int
) {
    fun getBestTurn(prevList: MutableList<Int>): DResult? {
        var bestSteps: MutableList<Int>? = null
        var bestRec: DRect? = null

        for (op in ops.withIndex()) {
            val recNext: DRect? = DRectLogic().op(recStart, op.value)

            if (recNext != null) {
                val nextSteep = steep + 1

                if ((nextSteep % maxTurnsStep == 0 && nextSteep !=0 && nextSteep != (maxTurns*maxTurnsStep)) ) {
                    recNext.force = recNext.force + turnForce
                    recNext.heat = recNext.heat + turnHeat
                    if (recNext.heat > recNeed.heat) {
                        return null
                    }
                    recNext.empl = turnEmploy
                }



                if (nextSteep < maxTurnsStep * maxTurns) {
                    val myPrevList:MutableList<Int> = prevList.toMutableList()
                    myPrevList.add(op.index)
                    val result = DRectTurn(recNext, recNeed, ops, maxTurns, maxTurnsStep, turnForce, turnHeat, turnEmploy, nextSteep).getBestTurn(myPrevList)
                    if (result != null) {
                        if (DRectLogic().better(result.rec, bestRec, recNeed)) {
                            bestSteps = result.steeps
                            bestSteps.add(op.index)
                            bestRec = result.rec
                        }
                    }
                } else {
                    if (DRectLogic().better(recNext, bestRec, recNeed)) {
                        bestSteps = mutableListOf()
                        bestSteps.add(op.index)
                        bestRec = recNext.copy()
                    }
                }
            }
        }

        if (bestSteps != null && bestRec != null && bestRec.energy >= 5) {
            println("$prevList $bestSteps $bestRec")
        }

        return if (bestRec != null && bestSteps != null) {
            DResult(bestSteps, bestRec)
        } else {
            null
        }
    }
}