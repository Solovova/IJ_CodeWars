package complete

import kotlin.math.pow

class Task10 {
    var code: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!#$%&()*+,./:;<=>?@[]^_`{|}~\""
    fun encode(data: String): String {
        val resultBuf = StringBuffer()
        var ind = 0
        var bits = 0
        var bitsN = 0

        while (true) {
            if (bitsN < 0 && ind == data.length) break

            while (bitsN < 14 && ind < data.length) {
                bits += data[ind].toByte() * 2.0.pow(bitsN.toDouble()).toInt()
                bitsN += 8
                ind++
            }

            val workBit = bits % 8192
            bits /= 8192
            bitsN -= 13

            resultBuf.append(code[workBit % 91])
            if ((bitsN + 13) >= 8) resultBuf.append(code[workBit / 91])
        }
        return resultBuf.toString()
    }

    fun decode(data: String): String {
        val resultBuf = StringBuffer()
        var ind = 0
        var bits = 0
        var bitsN = 0

        while (true) {
            if (bitsN < 8 && ind >= data.length) break

            while (bitsN < 16 && ind < data.length) {
                val fByte = code.indexOf(data[ind])
                val nByte = if (ind == data.length - 1) 0 else code.indexOf(data[ind + 1])
                val bit13 = fByte + nByte * 91


                bits += bit13 * 2.0.pow(bitsN.toDouble()).toInt()
                bitsN += 13 - if (ind == data.length - 1) 6 else 0
                ind += 2
            }

            if (bitsN >= 8) {
                val workBit: Byte = (bits % 256).toByte()
                bits /= 256
                bitsN -= 8

                println("$bitsN ${workBit.toChar()}")
                resultBuf.append(workBit.toChar())
            }
        }
        return resultBuf.toString()
    }

    fun encode1(data: String): String {
        val encoded = mutableListOf<Char>()
        val bi = data.toByteArray()
        var acc = 0
        var en = 0
        for (b in bi) {
            acc = acc or ((b.toInt() and 255) shl en)
            en += 8
            if (en > 13) {
                var ev = acc and 8191
                if (ev > 88) {
                    en -= 13
                    acc = acc shr 13
                } else {
                    ev = acc and 16383
                    en -= 14
                    acc = acc shr 14
                }
                encoded.add(code.get(ev % 91))
                encoded.add(code.get(ev / 91))
            }
        }
        if (en > 0) {
            encoded.add(code.get(acc % 91))
            if (en > 7 || acc > 90)
                encoded.add(code.get(acc / 91))
        }
        return encoded.joinToString("")
    }
    fun decode1(data: String): String {
        val decoded = mutableListOf<Byte>()
        val indexs = data.map { code.indexOf(it) }
        var acc = 0
        var dn = 0
        var dv = -1
        for (i in indexs) {
            if (dv == -1) dv = i
            else {
                dv += i * 91
                acc = acc or (dv shl dn)
                dn += if ((dv and 8191) > 88) 13 else 14
                do {
                    decoded.add(acc.toByte())
                    acc = acc shr 8
                    dn -= 8
                } while (dn > 7)
                dv = -1
            }
        }
        if (dv != -1) decoded.add((acc or (dv shl dn)).toByte())
        return String(decoded.toByteArray())
    }
}
