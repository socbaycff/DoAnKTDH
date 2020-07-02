package com.example.doanktdh.vatthe

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import com.example.doanktdh.utils.AxisConverter
import com.example.doanktdh.utils.LineMode
import com.example.doanktdh.utils.drawCircle
import com.example.doanktdh.utils.drawEllipseDash

class HinhCau(tam: PointF,var radius: Int) : VatThe(tam) {
    val paint =
        Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 5f
            strokeCap = Paint.Cap.ROUND
        }


    val paintDot =
        Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 10f
            strokeCap = Paint.Cap.ROUND
        }


    override fun draw(canvas: Canvas) {
        // ve hinh tron bao quanh
        drawCircle(
            radius * AxisConverter.doRongPixel,
            tam.x.toInt(),
            tam.y.toInt(),
            LineMode.SOLID,
            paint,
            canvas
        )
        canvas.drawPoint(tam.x,tam.y,paintDot)

        // ve elipse co truc ngang bang ban kinh
        drawEllipseDash(
            radius * AxisConverter.doRongPixel.toFloat(),
            radius * AxisConverter.doRongPixel / 4f,
            tam.x,
            tam.y,
            LineMode.DASH,
            paint,
            canvas
        )


    }

}