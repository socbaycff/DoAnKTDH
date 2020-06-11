package com.example.doanktdh.matran

import android.graphics.Point

class MaTran(var matrix: Array<IntArray>) { // x,y,1 or x,y,z,1
    operator fun times(other: Array<IntArray>) : MaTran{
        val r1 = matrix.size
        val c2 = other[0].size
        val c1 = matrix[0].size
        val product = Array(r1) { IntArray(c2) }
        for (i in 0..r1 - 1) {
            for (j in 0..c2 - 1) {
                for (k in 0..c1 - 1) {
                    product[i][j] += matrix[i][k] * other[k][j]
                }
            }
        }
        return MaTran(product)
    }

    fun toPoint(): Point {
        val row1 = matrix[0]
        return Point(row1[0],row1[1])
    }

    fun toPoint3D() {
    // not yet
    }


}
// point 2d -> matrix
fun Point.toMaTrix(): MaTran {
    return MaTran(Array<IntArray>(1) {IntArray(3).apply {
        this[0] = x
        this[1] = y
        this[2] = 1
    }  } )
}

