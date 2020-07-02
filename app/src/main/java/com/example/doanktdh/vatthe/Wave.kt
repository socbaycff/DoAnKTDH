package com.example.doanktdh.vatthe

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import com.example.doanktdh.utils.LineMode
import com.example.doanktdh.utils.drawCircle

class Wave(tam: PointF, var waveCount: Int) : VatThe(tam) {
    val doRong = 75

    val paint =
        Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 5f
            strokeCap = Paint.Cap.ROUND
        }
    override fun draw(canvas: Canvas) {
        for (i in 1..waveCount) {
            drawCircle(doRong*i,tam.x.toInt(),tam.y.toInt(),LineMode.SOLID,paint,canvas)

        }
    }

}