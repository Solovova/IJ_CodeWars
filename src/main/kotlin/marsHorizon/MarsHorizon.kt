package marsHorizon

import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.FileInputStream


class MarsHorizon {
    val ops: MutableList<DRectOp> = mutableListOf()
    val recStart: DRect
    val recNeed: DRect
    private val maxTurns: Int
    private val maxTurnsStep: Int
    private val turnForce: Int
    private val turnHeat: Int

    private fun getIntFrom(row: Int, cell: Int, sheet: Sheet): Int {
        return try {
            val result = sheet.getRow(row).getCell(cell).numericCellValue
            result.toInt()
        } catch (e: Exception) {
            0
        }
    }

    private fun getDRecFrom(row: Int, cell: Int, sheet: Sheet): DRect {
        return DRect(
            getIntFrom(row, cell, sheet),
            getIntFrom(row, cell + 1, sheet),
            getIntFrom(row, cell + 2, sheet),
            getIntFrom(row, cell + 3, sheet),
            getIntFrom(row, cell + 4, sheet),
            getIntFrom(row, cell + 5, sheet),
            getIntFrom(row, cell + 6, sheet),
            getIntFrom(row, cell + 7, sheet)
        )
    }

    init {
        val filepath = "C:\\00prg\\Google\\IJ_CodeWars\\src\\main\\kotlin\\marsHorizon\\mh.xlsx"
        val inputStream = FileInputStream(filepath)
        val xlWb = WorkbookFactory.create(inputStream)
        val xlWs = xlWb.getSheetAt(0)

        maxTurns = getIntFrom(0, 0, xlWs)
        maxTurnsStep = getIntFrom(1, 0, xlWs)
        turnForce = getIntFrom(5, 6, xlWs)
        turnHeat = getIntFrom(5, 7, xlWs)
        recStart = getDRecFrom(6, 1, xlWs)
        recNeed = getDRecFrom(7, 1, xlWs)
        println(maxTurns)
        var rowOp: Int = 8
        while (getIntFrom(rowOp, 0, xlWs) != 0) {
            ops.add(
                DRectOp(
                    getDRecFrom(rowOp, 1, xlWs),
                    getDRecFrom(rowOp + 1, 1, xlWs)
                )
            )
            rowOp += 2
        }

        println(recStart)
        println(recNeed)

        println(ops)


        val result = DRectTurn(recStart,recNeed,ops,maxTurns, maxTurnsStep,turnForce,turnHeat, recStart.empl, 0).getBestTurn(mutableListOf())

        println(result?.steeps)
        println(result?.rec)
    }
}