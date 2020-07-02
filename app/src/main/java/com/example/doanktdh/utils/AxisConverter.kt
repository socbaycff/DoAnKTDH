package com.example.doanktdh.utils

import android.graphics.PointF

/**
 * Chuyen qua lai toa do nguoi dung <-> toa do may tinh
 */
object AxisConverter {
    var width = 0
    var heigh = 0
    const val doRongPixel = 20
    fun userToSys(pointF: PointF): PointF {
        return PointF(pointF.x* doRongPixel + width /2,-pointF.y* doRongPixel + heigh /2)
    }

    fun sysToUser(pointF: PointF): PointF {
        return PointF(pointF.x/ doRongPixel - width /2,-pointF.y/ doRongPixel - heigh /2)
    }

}