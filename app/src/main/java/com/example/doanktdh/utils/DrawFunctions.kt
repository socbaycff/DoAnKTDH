@file:Suppress("LocalVariableName")

package com.example.doanktdh.utils

import android.graphics.Canvas
import android.graphics.Paint

/***
 * chua cac ham ve co ban: duong thang , tron, elipse
 *
 */

// 2 loai net ve : net dut, net thang
enum class LineMode { DASH, SOLID }


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

fun drawLineMidPoint(
    fromX: Int,
    fromY: Int,
    toX: Int,
    toY: Int,
    lineMode: LineMode,
    paint: Paint,
    canvas: Canvas?
) { // di tu diem y thap den diem y cao

    val startX: Int
    val startY: Int
    val endX: Int
    val endY: Int
    // điều chỉnh các điểm lại : để chỉ vẽ trường hợp y++ , k vẽ y--
    if (toY < fromY) { // nếu y đích thấp hơn y đầu, thì swap điểm xuất phát thành điểm kết thúc và ngược lại
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
    // tinh dx,dy
    val dx = endX - startX
    val dy = endY - startY

    var P = 0
    var x: Float = startX.toFloat() // x bat dau
    var y: Float = startY.toFloat() // y bat dau
    var counter = 0 // bộ đếm loại nét vẽ


    // chon net ve pattern
    val pattern: ArrayList<Boolean> = when (lineMode) {
        LineMode.DASH -> dashPattern
        LineMode.SOLID -> solidPattern
    }


    canvas?.drawPoint(x, y, paint) // cham diem dau tien
    if (endX < startX) { // trường hợp đi sang trái (x--)


        if (Math.abs(dx) > Math.abs(dy)) { // trường hợp bé hơn 45 độ: x đổi liên tục , y đổi có điều kiện
            P = -dy - dx / 2
            while (x > endX) {
                x--
                if (P > 0) P -= dy else {
                    P += -dy - dx
                    y++
                }

                if (pattern[counter++ % (pattern.size)]) {
                    canvas?.drawPoint(x, y, paint)
                }

            }
        } else {  // trường hợp lớn hơn 45 độ: y đổi liên tục, x đổi có điều kiện
            P = -dx - dy / 2
            while (y < endY) {
                y++
                if (P < 0) P -= dx else {
                    P += -dx - dy
                    x--
                }
                if (pattern[counter++ % (pattern.size)]) {
                    canvas?.drawPoint(x, y, paint)
                }
            }
        }
    } else { // đi sang phải (x++)


        if (Math.abs(dx) > Math.abs(dy)) {// trường hợp bé hơn 45 độ: x đổi liên tục , y đổi có điều kiện
            P = dy - dx / 2
            while (x < endX) {
                x++
                if (P < 0) P += dy else {
                    P += dy - dx
                    y++
                }
                if (pattern[counter++ % (pattern.size)]) {
                    canvas?.drawPoint(x, y, paint)
                }
            }
        } else {    // trường hợp lớn hơn 45 độ: y đổi liên tục, x đổi có điều kiện
            P = dx - dy / 2
            while (y < endY) {
                y++
                if (P < 0) P += dx else {
                    P += dx - dy
                    x++
                }
                if (pattern[counter++ % (pattern.size)]) {
                    canvas?.drawPoint(x, y, paint)
                }

            }
        }


    }


}

/**
 * Vẽ 1/8 hình tròn rồi đối xứng các phần còn lại
 * Phần tám dc vẽ là góc 45 hợp với bán kính ngang bên phải quét lên trên
 *
 */
fun drawCircle(
    radius: Int,
    x_centre: Int,
    y_centre: Int,
    lineMode: LineMode,
    paint: Paint,
    canvas: Canvas?
) {
    var counter = 0
    val xcenter = x_centre.toFloat()
    val ycenter = y_centre.toFloat()




    val pattern: ArrayList<Boolean> = when (lineMode) {
        LineMode.DASH -> dashPattern
        LineMode.SOLID -> solidPattern
    }

    // chấm 4 điểm
//    canvas?.drawPoint(x + x_centre.toFloat(), y + y_centre.toFloat(), paint)
//    if (radius > 0)
//    {
//        canvas?.drawPoint(x + x_centre.toFloat(), -y + y_centre.toFloat(), paint)
//        canvas?.drawPoint(y + x_centre.toFloat(), x + y_centre.toFloat(), paint) // diem  duoi cung cua dt
//        canvas?.drawPoint(-y + x_centre.toFloat(), x + y_centre.toFloat(), paint) // diem tren cung
//    }


    // Khởi tạo P
    var P: Int = 1 - radius
    // điểm bắt đầu là điểm ngoài cùng bên phải (x= bán kính, y = 0)
    var x = radius
    var y = 0

    while (x > y) { // vẽ tới khi x = y ( điểm x = y là điểm kết thúc)
        y++
        // giải thuật midpoint tính toán điều kiện giảm x
        if (P <= 0) P += 2 * y + 1 else {
            x--
            P += 2 * y - 2 * x + 1
        }

        // đối xứng 8 vùng để chấm điểm
        if (pattern[counter++ % (pattern.size)]) {

            canvas?.drawPoint(x + xcenter, y + ycenter, paint)
            canvas?.drawPoint(-x + xcenter, y + ycenter, paint)
            canvas?.drawPoint(x + xcenter, -y + ycenter, paint)
            canvas?.drawPoint(-x + xcenter, -y + ycenter, paint)


            canvas?.drawPoint(y + xcenter, x + ycenter, paint)
            canvas?.drawPoint(-y + xcenter, x + ycenter, paint)
            canvas?.drawPoint(y + xcenter, -x + ycenter, paint)
            canvas?.drawPoint(-y + xcenter, -x + ycenter, paint)

        }

    }
}

/**
 * ve hinh ellipse có phia trên là nét đứt, dưới là thẳng
 * vẽ 1 phần tư rồi đối xứng các phần còn lại của ellipse
 * phần được vẽ là quét góc 90 từ bán kính ngang bên phải đi lên trên
 *
 * trong phần tư có 2 phần không đối xứng, vẽ từng phần đó:
 * vùng 1: đi từ đỉnh trên đến giữa đường ellipse bên phải trên
 * vùng 2: đi từ điểm giữa ellipse bên phải trên đến điểm ngoài cùng bên phải
 */
fun drawEllipseDash(
    radius_x: Float,
    radius_y: Float,
    center_x: Float,
    center_y: Float,
    lineMode: LineMode,
    paint: Paint,
    canvas: Canvas?
) {
    var counter = 0


    val pattern: ArrayList<Boolean>
    when (lineMode) {
        LineMode.DASH -> pattern =
            dashPattern
        LineMode.SOLID -> pattern =
            solidPattern
    }

    // Khởi tạo các biến cho vùng 1
    // P1 = y^2  + (1/4)(x^2) - (x^2)y
    var P1 = radius_y * radius_y + 0.25f * radius_x * radius_x - radius_x * radius_x * radius_y

    // điểm bắt đầu của đường ellipse là trên cùng của hình (0,radius_y)
    var x: Float = 0f
    var y: Float = radius_y

    var dx = 2 * radius_y * radius_y * x
    var dy = 2 * radius_x * radius_x * y

    // vòng while vẽ vùng 1
    while (dx < dy) {
        // vẽ đối xừng 4 vùng
        canvas?.drawPoint(x + center_x, y + center_y, paint)
        canvas?.drawPoint(-x + center_x, y + center_y, paint)
        if (pattern[counter++ % (pattern.size)]) {
            canvas?.drawPoint(x + center_x, -y + center_y, paint)
            canvas?.drawPoint(-x + center_x, -y + center_y, paint)
        }


        // thuật toán midpoint vẽ ellipse: điều chỉnh x, y , P1, dx,dy
        if (P1 < 0) {
            x++
            dx = dx + 2 * radius_y * radius_y
            P1 = P1 + dx + radius_y * radius_y
        } else {
            x++
            y--
            dx = dx + 2 * radius_y * radius_y
            dy = dy - 2 * radius_x * radius_x
            P1 = P1 + dx - dy + radius_y * radius_y
        }
    }

    // Khởi tạo các biến cho vùng 2
    var P2 = (radius_y * radius_y * ((x + 0.5f) * (x + 0.5f))
            + radius_x * radius_x * ((y - 1) * (y - 1))
            - radius_x * radius_x * radius_y * radius_y)

    // vòng while vẽ vùng 2
    while (y >= 0) {
        // vẽ đối xừng 4 vùng
        canvas?.drawPoint(x + center_x, y + center_y, paint)
        canvas?.drawPoint(-x + center_x, y + center_y, paint)

        if (pattern[counter++ % (pattern.size)]) {
            canvas?.drawPoint(x + center_x, -y + center_y, paint)
            canvas?.drawPoint(-x + center_x, -y + center_y, paint)
        }

        // thuật toán midpoint vẽ ellipse: điều chỉnh x, y , P2, dx,dy
        if (P2 > 0) {
            y--
            dy = dy - 2 * radius_x * radius_x
            P2 = P2 + radius_x * radius_x - dy
        } else {
            y--
            x++
            dx = dx + 2 * radius_y * radius_y
            dy = dy - 2 * radius_x * radius_x
            P2 = P2 + dx - dy + radius_x * radius_x
        }
    }
}


fun drawEllipse(radius_x: Float, radius_y: Float, center_x: Float, center_y: Float, lineMode: LineMode, paint: Paint, canvas: Canvas?) {
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
        LineMode.DASH -> pattern =
            dashPattern
        LineMode.SOLID -> pattern =
            solidPattern
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




