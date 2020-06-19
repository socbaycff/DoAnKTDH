package com.example.doanktdh.matran

import android.graphics.Point
import android.graphics.PointF
import com.example.doanktdh.Point3D.Point3D

class MaTran(var matrix: Array<FloatArray>) { // x,y,1 or x,y,z,1
    operator fun times(maTran: MaTran) : MaTran{
        val other = maTran.matrix
        val r1 = matrix.size
        val c2 = other[0].size
        val c1 = matrix[0].size
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

    fun toPoint(): PointF {
        val row1 = matrix[0]
        return PointF(row1[0],row1[1])
    }

    fun toPoint3D(): Point3D {
        val row1 = matrix[0]
        return Point3D(row1[0],row1[1],row1[2])
    }




}
// point 2d -> matrix
fun PointF.toMatrix(): MaTran {
    return MaTran(Array<FloatArray>(1) {FloatArray(3).apply {
        this[0] = x.toFloat()
        this[1] = y.toFloat()
        this[2] = 1f
    }  } )
}

// point 3d -> matrix
fun Point3D.toMatrix(): MaTran {
    return MaTran(Array<FloatArray>(1) {FloatArray(4).apply {
        this[0] = x.toFloat()
        this[1] = y.toFloat()
        this[2] = z.toFloat()
        this[3] = 1f
    }  } )
}

