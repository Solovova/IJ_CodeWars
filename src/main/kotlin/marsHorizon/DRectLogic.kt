package marsHorizon

class DRectLogic {
    fun op(dRect: DRect, dRectOp: DRectOp): DRect? {
        if (dRect.energy < dRectOp.recMinus.energy ||
            dRect.wifi < dRectOp.recMinus.wifi ||
            dRect.storage < dRectOp.recMinus.storage ||
            dRect.magnetic < dRectOp.recMinus.magnetic ||
            dRect.empl < dRectOp.recMinus.empl ||
            dRect.heat < dRectOp.recMinus.heat
        ) {
            return null
        }

        return DRect(
            dRect.energy - dRectOp.recMinus.energy + dRectOp.recPlus.energy,
            dRect.wifi - dRectOp.recMinus.wifi + dRectOp.recPlus.wifi,
            dRect.storage - dRectOp.recMinus.storage + dRectOp.recPlus.storage,
            dRect.magnetic - dRectOp.recMinus.magnetic + dRectOp.recPlus.magnetic,
            dRect.drafe - dRectOp.recMinus.drafe + dRectOp.recPlus.drafe,
            dRect.force - dRectOp.recMinus.force + dRectOp.recPlus.force,
            dRect.heat - dRectOp.recMinus.heat + dRectOp.recPlus.heat,
            dRect.empl - dRectOp.recMinus.empl + dRectOp.recPlus.empl
        )
    }

    private fun isGood(dRect: DRect, dRectNeed: DRect): Boolean {
        return (dRect.wifi >= dRectNeed.wifi &&
                dRect.storage >= dRectNeed.storage &&
                dRect.magnetic >= dRectNeed.magnetic &&
                dRect.energy >= 0 &&
                dRect.drafe >= -dRectNeed.drafe  &&
                dRect.drafe <= dRectNeed.drafe &&
                dRect.heat <= dRectNeed.heat &&
                dRect.force >= dRectNeed.force &&
                dRect.empl >= 0
                )
    }

    fun better(dRect1: DRect, dRect2: DRect?, dRectNeed: DRect):Boolean { //true if dRect1 better then dRect2
        if (!this.isGood(dRect1, dRectNeed)) {
            return false
        }
        if (dRect2 == null) {
            return true
        }

        return dRect1.energy > dRect2.energy
    }
}