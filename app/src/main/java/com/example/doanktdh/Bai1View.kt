package com.example.doanktdh

import android.content.Context
import android.graphics.Canvas
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import com.example.doanktdh.vatthe.HinhChuNhat

class Bai1View(context: Context, attributes: AttributeSet): View(context,attributes) {
    val listVatThe = ArrayList<VatThe>()
    init {
        // add toan bo vat the vao list
        listVatThe.add(HinhChuNhat(Point(100,100)))

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        listVatThe.forEach {
            it.draw(canvas!!)
        }
    }

}