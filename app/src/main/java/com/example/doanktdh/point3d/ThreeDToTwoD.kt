package com.example.doanktdh.point3d

import android.graphics.PointF
import kotlin.math.sqrt

/**
 * phep chieu 3d -> 2d
 */

fun Point3D.threeToTwoD(): PointF {
    // chieu cabinet
    // 3d: xyz -> 2d: xy
    val xTemp = x - y* 1/(2* sqrt(2f))
    val yTemp = z - y* 1/(2* sqrt(2f))
    return PointF(xTemp,yTemp)
}



