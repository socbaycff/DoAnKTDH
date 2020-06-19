package com.example.doanktdh

import android.graphics.Canvas
import android.graphics.PointF

// dai dien vat the nhu xe, cay, nha, nguoi, xoay quan tam cua vat the
abstract class VatThe(var tam: PointF) {

    abstract fun draw(canvas: Canvas)
}