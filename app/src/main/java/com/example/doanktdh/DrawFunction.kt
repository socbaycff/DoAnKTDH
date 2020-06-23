package com.example.doanktdh

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

/***
 * chua cac ham ve co ban: duong thang , tron, elipse
 *
 */


enum class LineMode { DASH, SOLID}


val putLength = 20
val unputLength = 10
val dashPattern = ArrayList<Boolean>(putLength + unputLength).apply {
    for (index in 1..putLength) {
        add(true)
    }
    for (index in 1..unputLength) {
        add(false)
    }
}

val solidPattern = ArrayList<Boolean>(putLength + unputLength).apply {
    for (index in 1..putLength + unputLength) {
        add(true)
    }

}
 fun drawLineMidPoint(fromX: Int, fromY: Int, toX: Int, toY: Int,lineMode: LineMode,paint: Paint, canvas: Canvas?) { // di tu diem y thap den diem y cao

     val startX: Int
     val startY: Int
     val endX: Int
     val endY: Int
     if (toY < fromY) {
         startX = toX
         startY = toY
         endX = fromX
         endY = fromY
     } else {
         startX = fromX
         startY = fromY
         endX = toX
         endY = toY
     }

    val dx = endX - startX
    val dy = endY - startY

    var d = 0
    var x: Float = startX.toFloat() // x bat dau
    var y: Float = startY.toFloat() // y bat dau
    var counter = 0 // bo dem


    // choose pattern
    val pattern: ArrayList<Boolean>
    when (lineMode) {
        LineMode.DASH -> pattern = dashPattern
        LineMode.SOLID -> pattern = solidPattern
    }


    canvas?.drawPoint(x, y, paint)
    if (endX < startX) {
        if (Math.abs(dx) > Math.abs(dy)) {
            d = -dy - dx / 2
            while (x > endX) {
                x--
                if (d > 0) d = d - dy else {
                    d += -dy - dx
                    y++
                }

                if (pattern[counter++ % (pattern.size)]) {
                    canvas?.drawPoint(x, y, paint)
                }

            }
        } else {
            d = -dx - dy / 2
            while (y < endY) {
                y++
                if (d < 0) d = d - dx else {
                    d += -dx - dy
                    x--
                }
                if (pattern[counter++ % (pattern.size)]) {
                    canvas?.drawPoint(x, y, paint)
                }
            }
        }
    } else {
        if (Math.abs(dx) > Math.abs(dy)) {
            d = dy - dx / 2
            while (x < endX) {
                x++
                if (d < 0) d = d + dy else {
                    d += dy - dx
                    y++
                }
                if (pattern[counter++ % (pattern.size)]) {
                    canvas?.drawPoint(x, y, paint)
                }
            }
        } else {
            d = dx - dy / 2
            while (y < endY) {
                y++
                if (d < 0) d = d + dx else {
                    d += dx - dy
                    x++
                }
                if (pattern[counter++ % (pattern.size)]) {
                    canvas?.drawPoint(x, y, paint)
                }

            }
        }
    }


}


fun drawCircle(radius :Int, x_centre: Int, y_centre: Int,lineMode: LineMode,paint: Paint, canvas: Canvas?) {
    var counter = 0

    var x: Int = radius
    var y = 0

    // choose pattern
    val pattern: ArrayList<Boolean>
    when (lineMode) {
        LineMode.DASH -> pattern = dashPattern
        LineMode.SOLID -> pattern = solidPattern
    }

    canvas?.drawPoint(x + x_centre.toFloat(), y + y_centre.toFloat(), paint)
    if (radius > 0)
    {
        canvas?.drawPoint(x + x_centre.toFloat(), -y + y_centre.toFloat(), paint)
        canvas?.drawPoint(y + x_centre.toFloat(), x + y_centre.toFloat(), paint)
        canvas?.drawPoint(-y + x_centre.toFloat(), x + y_centre.toFloat(), paint)
    }


    // Initialising the value of P
    var P: Int = 1 - radius
    while (x > y) {
        y++
        // Mid-point is inside or on the perimeter
        P = if (P <= 0) P + 2 * y + 1 else {
            x--
            P + 2 * y - 2 * x + 1
        }

        // All the perimeter points have already been printed
        if (x < y) break

        // Printing the generated point and its reflection in the other octants after translation
        if (pattern[counter++ % (pattern.size)]) {
            canvas?.drawPoint(x + x_centre.toFloat(), y + y_centre.toFloat(), paint)
            canvas?.drawPoint(-x + x_centre.toFloat(), y + y_centre.toFloat(), paint)
            canvas?.drawPoint(x + x_centre.toFloat(), -y + y_centre.toFloat(), paint)
            canvas?.drawPoint(-x + x_centre.toFloat(), -y + y_centre.toFloat(), paint)

            // If the generated point is on the line x = y then the perimeter points have already been printed
            if (x != y) {
                canvas?.drawPoint(y + x_centre.toFloat(), x + y_centre.toFloat(), paint)
                canvas?.drawPoint(-y + x_centre.toFloat(), x + y_centre.toFloat(), paint)
                canvas?.drawPoint(y + x_centre.toFloat(), -x + y_centre.toFloat(), paint)
                canvas?.drawPoint(-y + x_centre.toFloat(), -x + y_centre.toFloat(), paint)
            }
        }

    }
}

fun drawEllipseDash(radius_x: Float, radius_y: Float, center_x: Float, center_y: Float,lineMode: LineMode,paint: Paint, canvas: Canvas?) {
    var counter = 0
    var d1: Float
    var d2: Float
    var x: Float
    var y: Float
    x = 0f
    y = radius_y

    // choose pattern
    val pattern: ArrayList<Boolean>
    when (lineMode) {
        LineMode.DASH -> pattern = dashPattern
        LineMode.SOLID -> pattern = solidPattern
    }
    // Initial decision parameter of region 1
    d1 = radius_y * radius_y - radius_x * radius_x * radius_y + 0.25f * radius_x * radius_x
    var dx = 2 * radius_y * radius_y * x
    var dy = 2 * radius_x * radius_x * y

    // For region 1
    while (dx < dy) { // Print points based on 4-way symmetry
        canvas?.drawPoint(x + center_x, y + center_y, paint)
        canvas?.drawPoint(-x + center_x, y + center_y, paint)

        if (pattern[counter++ %(pattern.size)]) {
            canvas?.drawPoint(x + center_x, -y + center_y, paint)
            canvas?.drawPoint(-x + center_x, -y + center_y, paint)
        }


        // Checking and updating value of decision parameter based on algorithm
        if (d1 < 0) {
            x++
            dx = dx + 2 * radius_y * radius_y
            d1 = d1 + dx + radius_y * radius_y
        } else {
            x++
            y--
            dx = dx + 2 * radius_y * radius_y
            dy = dy - 2 * radius_x * radius_x
            d1 = d1 + dx - dy + radius_y * radius_y
        }
    }

    // Decision parameter of region 2
    d2 = (radius_y * radius_y * ((x + 0.5f) * (x + 0.5f))
            + radius_x * radius_x * ((y - 1) * (y - 1))
            - radius_x * radius_x * radius_y * radius_y)

    // Plotting points of region 2
    while (y >= 0) { // printing points based on 4-way symmetry

        canvas?.drawPoint(x + center_x, y + center_y, paint)
        canvas?.drawPoint(-x + center_x, y + center_y, paint)

        if (pattern[counter++ %(pattern.size)]) {
            canvas?.drawPoint(x + center_x, -y + center_y, paint)
            canvas?.drawPoint(-x + center_x, -y + center_y, paint)
        }

        // Checking and updating parameter value based on algorithm
        if (d2 > 0) {
            y--
            dy = dy - 2 * radius_x * radius_x
            d2 = d2 + radius_x * radius_x - dy
        } else {
            y--
            x++
            dx = dx + 2 * radius_y * radius_y
            dy = dy - 2 * radius_x * radius_x
            d2 = d2 + dx - dy + radius_x * radius_x
        }
    }
}


fun drawEllipse(radius_x: Float, radius_y: Float, center_x: Float, center_y: Float,lineMode: LineMode,paint: Paint, canvas: Canvas?) {
    var counter = 0
    var d1: Float
    var d2: Float
    var x: Float
    var y: Float
    x = 0f
    y = radius_y


    // choose pattern
    val pattern: ArrayList<Boolean>
    when (lineMode) {
        LineMode.DASH -> pattern = dashPattern
        LineMode.SOLID -> pattern = solidPattern
    }

    // Initial decision parameter of region 1
    d1 = radius_y * radius_y - radius_x * radius_x * radius_y + 0.25f * radius_x * radius_x
    var dx = 2 * radius_y * radius_y * x
    var dy = 2 * radius_x * radius_x * y

    // For region 1
    while (dx < dy) { // Print points based on 4-way symmetry
        canvas?.drawPoint(x + center_x, y + center_y, paint)
        canvas?.drawPoint(-x + center_x, y + center_y, paint)

        if (pattern[counter++ %(pattern.size)]) {
            canvas?.drawPoint(x + center_x, -y + center_y, paint)
            canvas?.drawPoint(-x + center_x, -y + center_y, paint)
        }


        // Checking and updating value of decision parameter based on algorithm
        if (d1 < 0) {
            x++
            dx = dx + 2 * radius_y * radius_y
            d1 = d1 + dx + radius_y * radius_y
        } else {
            x++
            y--
            dx = dx + 2 * radius_y * radius_y
            dy = dy - 2 * radius_x * radius_x
            d1 = d1 + dx - dy + radius_y * radius_y
        }
    }

    // Decision parameter of region 2
    d2 = (radius_y * radius_y * ((x + 0.5f) * (x + 0.5f))
            + radius_x * radius_x * ((y - 1) * (y - 1))
            - radius_x * radius_x * radius_y * radius_y)

    // Plotting points of region 2
    while (y >= 0) { // printing points based on 4-way symmetry

        canvas?.drawPoint(x + center_x, y + center_y, paint)
        canvas?.drawPoint(-x + center_x, y + center_y, paint)

        if (pattern[counter++ %(pattern.size)]) {
            canvas?.drawPoint(x + center_x, -y + center_y, paint)
            canvas?.drawPoint(-x + center_x, -y + center_y, paint)
        }

        // Checking and updating parameter value based on algorithm
        if (d2 > 0) {
            y--
            dy = dy - 2 * radius_x * radius_x
            d2 = d2 + radius_x * radius_x - dy
        } else {
            y--
            x++
            dx = dx + 2 * radius_y * radius_y
            dy = dy - 2 * radius_x * radius_x
            d2 = d2 + dx - dy + radius_x * radius_x
        }
    }
}


