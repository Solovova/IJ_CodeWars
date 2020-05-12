package complete

class Task16Recursive {
    fun decompose(n: Long): String {
        val list = decomposeN(n,n*n)
        var result=""
        if (list!=null) {
            for(el in list) result += " $el"
        }

        result = result.trim()
        return if (result=="") "null" else result
    }

    private fun decomposeN(n: Long,sum: Long): MutableList<Long>? {
        val myN = n-1


        if (myN==0L) return null
        if (sum<0L) return null
        if (sum==0L) return mutableListOf()
        if (sum==1L) return mutableListOf(1)

        val sol1 = decomposeN(myN,sum-myN*myN)
        val sol2 = decomposeN(myN,sum)

        if (sol1==null && sol2==null) return null

        if(sol1==null && sol2!=null) {
            return sol2
        }

        if(sol1!=null && sol2==null) {
            sol1.add(myN)
            return sol1
        }

        if(sol1!=null && sol2!=null) {
            return if (sol2.size<=sol1.size) {
                sol2
            }else{
                sol1.add(myN)
                sol1
            }
        }
        return null
    }
}