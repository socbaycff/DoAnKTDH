package com.example.doanktdh.Point3D

import android.graphics.PointF
import kotlin.math.sqrt

/**
 * phep chieu 3d -> 2d
 */

fun Point3D.threeToTwoD(): PointF {
    // chieu cabinet
    val xTemp = x - y* sqrt(2f) /4
    val yTemp = z - y* sqrt(2f) /4
    return PointF(xTemp,yTemp)
}



