package com.example.doanktdh.vatthe

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import com.example.doanktdh.LineMode
import com.example.doanktdh.VatThe
import com.example.doanktdh.drawLineMidPoint

class HinhChuNhat(tam: Point, var width: Int, var height: Int) : VatThe(tam) {


    val paint =
        Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 10f
            strokeCap = Paint.Cap.ROUND
        }
    override fun draw(canvas: Canvas) {
        val p1 = Point(tam.x - width / 2, tam.y - height / 2)
        val p2 = Point(tam.x + width / 2, tam.y + height / 2)
        drawLineMidPoint(p1.x,p1.y,p2.x,p1.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(p1.x,p1.y,p1.x,p2.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(p1.x,p2.y,p2.x,p2.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(p2.x,p2.y,p2.x,p1.y,LineMode.SOLID,paint,canvas)
    }

}