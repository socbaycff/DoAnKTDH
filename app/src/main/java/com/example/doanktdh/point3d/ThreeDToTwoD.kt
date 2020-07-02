package com.example.doanktdh.point3d

import android.graphics.PointF

/**
 * phep chieu 3d -> 2d
 */

fun Point3D.threeToTwoD(): PointF {
    // chieu cabinet
    val xTemp = x - y* 1/4
    val yTemp = z - y* 1/4
    return PointF(xTemp,yTemp)
}



