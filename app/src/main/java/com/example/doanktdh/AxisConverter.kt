package com.example.doanktdh

import android.graphics.PointF


object AxisConverter {
    var width = 0
    var heigh = 0
    fun userToSys(pointF: PointF): PointF {
        return PointF(pointF.x+ width/2,-pointF.y + heigh/2)
    }

}