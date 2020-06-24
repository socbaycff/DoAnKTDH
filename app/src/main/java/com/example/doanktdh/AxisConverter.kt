package com.example.doanktdh

import android.graphics.PointF


object AxisConverter {
    var width = 0
    var heigh = 0
    val doRongPixel = 20
    fun userToSys(pointF: PointF): PointF {
        return PointF(pointF.x* doRongPixel+ width/2,-pointF.y* doRongPixel + heigh/2)
    }

    fun sysToUser(pointF: PointF): PointF {
        return PointF(pointF.x/ doRongPixel - width/2,-pointF.y/ doRongPixel - heigh/2)
    }

}