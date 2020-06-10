package com.example.doanktdh

import android.graphics.Canvas
import android.graphics.Point

// dai dien vat the nhu xe, cay, nha, nguoi, xoay quan tam cua vat the
abstract class VatThe(var tam: Point) {

    abstract fun draw(canvas: Canvas)
}