package com.example.doanktdh.utils

import com.example.doanktdh.matran.MaTran
import kotlin.math.cos
import kotlin.math.sin

object TwoDTrans {
    // tinh tien 1 doan x,y
    fun mtTinhTien(x: Float, y: Float): MaTran{
        return MaTran(Array<FloatArray>(3) {FloatArray(3)} ).apply {
            val matrix = this.matrix
            matrix[0][0] = 1f
            matrix[0][1] = 0f
            matrix[0][2] = 0f

            matrix[1][0] = 0f
            matrix[1][1] = 1f
            matrix[1][2] = 0f

            matrix[2][0] = x
            matrix[2][1] = y
            matrix[2][2] = 1f
        }

    }

    // xoay 1 goc angle
    fun mtXoay(angle: Float): MaTran {
        return MaTran(Array(3) {FloatArray(3)} ).apply {
            val goc = angle
            val matrix = this.matrix
            matrix[0][0] = cos(goc)
            matrix[0][1] = sin(goc)
            matrix[0][2] = 0f

            matrix[1][0] = -sin(goc)
            matrix[1][1] = cos(goc)
            matrix[1][2] = 0f

            matrix[2][0] = 0f
            matrix[2][1] = 0f
            matrix[2][2] = 1f
        }
    }


}

