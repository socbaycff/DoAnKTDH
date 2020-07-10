package com.example.doanktdh.matran

import android.graphics.PointF

class MaTran(var matrix: Array<FloatArray>) { // x,y,1
    // nhan ma tran
    operator fun times(maTran: MaTran) : MaTran{
        val other = maTran.matrix
        val r1 = matrix.size // so hang ma tran 1
        val c1 = matrix[0].size // so cot ma tran 1
        val c2 = other[0].size // so cot ma tran 2

        val product = Array(r1) { FloatArray(c2) }
        for (i in 0..r1 - 1) {
            for (j in 0..c2 - 1) {
                for (k in 0..c1 - 1) {
                    product[i][j] += matrix[i][k] * other[k][j]
                }
            }
        }
        return MaTran(product)
    }

    // chuyển matran sang point
    fun toPoint(): PointF {
        val row1 = matrix[0]
        return PointF(row1[0],row1[1])
    }

}
// point 2d -> matrix
fun PointF.toMatrix(): MaTran {
    return MaTran(Array<FloatArray>(1) {FloatArray(3).apply {
        this[0] = x
        this[1] = y
        this[2] = 1f
    }  } )
}


