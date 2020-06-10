package com.example.doanktdh.vatthe

import android.graphics.Canvas
import android.graphics.Point
import com.example.doanktdh.LineMode
import com.example.doanktdh.VatThe
import com.example.doanktdh.drawLineMidPoint

class HinhChuNhat(tam : Point): VatThe(tam) {
    override fun draw(canvas: Canvas) {

      drawLineMidPoint( tam.x + 10,tam.y +500,tam.x + 50,tam.y + 50,LineMode.SOLID,canvas)
    }

}