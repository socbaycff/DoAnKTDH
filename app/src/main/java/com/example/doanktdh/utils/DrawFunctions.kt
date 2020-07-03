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

val pixelSpacing = 5 // khoang cach cộng trừ pixel
val putLength = 10
val unputLength = 5
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
                x -= pixelSpacing
                if (P > 0) P -= dy else {
                    P += -dy - dx
                    y += pixelSpacing
                }

                if (pattern[counter++ % (pattern.size)]) {
                    canvas?.drawPoint(x, y, paint)
                }

            }
        } else {  // trường hợp lớn hơn 45 độ: y đổi liên tục, x đổi có điều kiện
            P = -dx - dy / 2
            while (y < endY) {
                y += pixelSpacing
                if (P < 0) P -= dx else {
                    P += -dx - dy
                    x -= pixelSpacing
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
                x += pixelSpacing
                if (P < 0) {
                    P += dy
                } else {
                    P += dy - dx
                    y += pixelSpacing
                }
                // chấm điểm
                if (pattern[counter++ % (pattern.size)]) {
                    canvas?.drawPoint(x, y, paint) // chấm điểm dựa theo xy
                }
            }
        } else {    // trường hợp lớn hơn 45 độ: y đổi liên tục, x đổi có điều kiện
            P = dx - dy / 2
            while (y < endY) {
                y += pixelSpacing
                if (P < 0) P += dx else {
                    P += dx - dy
                    x += pixelSpacing
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


    // Khởi tạo P
    var P: Int = 1 - radius
    // điểm bắt đầu là điểm ngoài cùng bên phải (x= bán kính, y = 0)
    var x = radius
    var y = 0

    while (x > y) { // vẽ tới khi x = y ( điểm x = y là điểm kết thúc)
        y += pixelSpacing
        // giải thuật midpoint tính toán điều kiện giảm x
        if (P <= 0) P += 2 * y + 1 else {
            x -= pixelSpacing
            P += 2 * y - 2 * x + 1
        }

        // đối xứng 8 vùng để chấm điểm
        if (pattern[counter++ % (pattern.size)]) { // ve theo mau net

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
    rx: Float,
    ry: Float,
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
    var P1 = ry * ry + 0.25f * rx * rx - rx * rx * ry

    // điểm bắt đầu của đường ellipse là trên cùng của hình (0,radius_y)
    var x: Float = 0f
    var y: Float = ry


    // vòng while vẽ vùng 1
    do {
        // vẽ đối xừng 4 vùng
        canvas?.drawPoint(x + center_x, y + center_y, paint)
        canvas?.drawPoint(-x + center_x, y + center_y, paint)
        if (pattern[counter++ % (pattern.size)]) {
            canvas?.drawPoint(x + center_x, -y + center_y, paint)
            canvas?.drawPoint(-x + center_x, -y + center_y, paint)
        }


        // thuật toán midpoint vẽ ellipse: điều chỉnh x, y , P1, dx,dy
        if (P1 < 0) {
            P1 += 2 * ry * ry * x + ry * ry
        } else {
            y -= pixelSpacing
            P1 += 2 * ry * ry * x - 2 * rx * rx * y + ry * ry
        }
        x += pixelSpacing
    } while (2 * ry * ry * x < 2 * rx * rx * y)

    // Khởi tạo các biến cho vùng 2
    var P2 = (ry * ry * ((x + 0.5f) * (x + 0.5f))
            + rx * rx * ((y - 1) * (y - 1))
            - rx * rx * ry * ry)

    // vòng while vẽ vùng 2
    do {
        // vẽ đối xừng 4 vùng
        canvas?.drawPoint(x + center_x, y + center_y, paint)
        canvas?.drawPoint(-x + center_x, y + center_y, paint)

        if (pattern[counter++ % (pattern.size)]) {
            canvas?.drawPoint(x + center_x, -y + center_y, paint)
            canvas?.drawPoint(-x + center_x, -y + center_y, paint)
        }

        // thuật toán midpoint vẽ ellipse: điều chỉnh x, y , P2, dx,dy
        if (P2 > 0) {
            P2 += rx * rx - 2 * rx * rx * y
        } else {
            x += pixelSpacing
            P2 += 2 * ry * ry * x - 2 * rx * rx * y + rx * rx
        }
        y -= pixelSpacing
    } while (y <= 0f)
}


fun drawEllipse(
    rx: Float,
    ry: Float,
    center_x: Float,
    center_y: Float,
    lineMode: LineMode,
    paint: Paint,
    canvas: Canvas?
) {
    val pattern: ArrayList<Boolean>
    when (lineMode) {
        LineMode.DASH -> pattern =
            dashPattern
        LineMode.SOLID -> pattern =
            solidPattern
    }

    // Khởi tạo các biến cho vùng 1
    // P1 = y^2  + (1/4)(x^2) - (x^2)y
    var P1 = ry * ry + 0.25f * rx * rx - rx * rx * ry

    // điểm bắt đầu của đường ellipse là trên cùng của hình (0,radius_y)
    var x: Float = 0f
    var y: Float = ry

    // vòng while vẽ vùng 1
    do {
        // vẽ đối xừng 4 vùng
        canvas?.drawPoint(x + center_x, y + center_y, paint)
        canvas?.drawPoint(-x + center_x, y + center_y, paint)
        canvas?.drawPoint(x + center_x, -y + center_y, paint)
        canvas?.drawPoint(-x + center_x, -y + center_y, paint)


        // thuật toán midpoint vẽ ellipse: điều chỉnh x, y , P1, dx,dy
        if (P1 < 0) {
            P1 += 2 * ry * ry * x + ry * ry
        } else {
            y -= pixelSpacing
            P1 += 2 * ry * ry * x - 2 * rx * rx * y + ry * ry
        }
        x += pixelSpacing
    } while (2 * ry * ry * x < 2 * rx * rx * y)

    // Khởi tạo các biến cho vùng 2
    var P2 = (ry * ry * ((x + 0.5f) * (x + 0.5f))
            + rx * rx * ((y - 1) * (y - 1))
            - rx * rx * ry * ry)

    // vòng while vẽ vùng 2
    do {
        // vẽ đối xừng 4 vùng
        canvas?.drawPoint(x + center_x, y + center_y, paint)
        canvas?.drawPoint(-x + center_x, y + center_y, paint)
        canvas?.drawPoint(x + center_x, -y + center_y, paint)
        canvas?.drawPoint(-x + center_x, -y + center_y, paint)


        // thuật toán midpoint vẽ ellipse: điều chỉnh x, y , P2, dx,dy
        if (P2 > 0) {
            P2 += rx * rx - 2 * rx * rx * y
        } else {
            x += pixelSpacing
            P2 += 2 * ry * ry * x - 2 * rx * rx * y + rx * rx
        }
        y -= pixelSpacing
    } while (y != 0f)
}




