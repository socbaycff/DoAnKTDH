package com.example.doanktdh.Point3D

import android.graphics.PointF

/**
 * phep chieu 3d -> 2d
 */

fun Point3D.threeToTwoD(): PointF {
    val xTemp = x - y /2
    val yTemp = z - y /2
    return PointF(xTemp,yTemp)
}