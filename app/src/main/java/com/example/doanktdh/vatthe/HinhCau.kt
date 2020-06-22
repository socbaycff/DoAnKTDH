package com.example.doanktdh.vatthe

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import com.example.doanktdh.LineMode
import com.example.doanktdh.VatThe
import com.example.doanktdh.drawCircle
import com.example.doanktdh.drawEllipse

class HinhCau(tam: PointF,var radius: Int) : VatThe(tam) {
    val paint =
        Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 10f
            strokeCap = Paint.Cap.ROUND
        }


    override fun draw(canvas: Canvas) {
        // ve hinh tron bao
        drawCircle(radius,tam.x.toInt(),tam.y.toInt(),LineMode.SOLID,paint,canvas)


        // ve elipse co truc ngang bang ban kinh
        drawEllipse(radius.toFloat(),radius/4f,tam.x,tam.y,LineMode.SOLID,paint,canvas)


    }

}