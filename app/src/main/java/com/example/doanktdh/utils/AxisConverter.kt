package com.example.doanktdh.utils

import android.graphics.PointF

/**
 * Chuyen qua lai toa do nguoi dung <-> toa do may tinh
 */
object AxisConverter {
    var width = 0
    var heigh = 0
    const val doRongDonVi = 5
    fun userToSys(pointF: PointF): PointF {// user -> may tinh
        return PointF(pointF.x* doRongDonVi + width /2,-pointF.y* doRongDonVi + heigh /2)
    }

    fun sysToUser(pointF: PointF): PointF { // may tinh -> user
        return PointF(pointF.x/ doRongDonVi - width /2,-pointF.y/ doRongDonVi - heigh /2)
    }

}