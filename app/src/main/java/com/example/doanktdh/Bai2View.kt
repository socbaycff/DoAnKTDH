package com.example.doanktdh


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.example.doanktdh.vatthe.HinhCau
import com.example.doanktdh.vatthe.HinhHop


class Bai2View(context: Context, attributes: AttributeSet): View(context,attributes) {

    val listVatThe = ArrayList<VatThe>()


    val paint =
        Paint().apply {
            color = Color.BLUE
            style = Paint.Style.STROKE
            strokeWidth = 5f
            strokeCap = Paint.Cap.ROUND
        }
    fun addHinhHop(tam: PointF, dai: Int, rong: Int, cao: Int) {
        listVatThe.add(HinhHop(AxisConverter.userToSys(tam),dai,rong,cao))
        invalidate()
    }

    fun addHinhCau(tam: PointF, radius: Int) {
        val point = AxisConverter.userToSys(tam)
        listVatThe.add(HinhCau(point,500))
    }
    fun addHinhTru(tam: PointF, radius: Int, cao: Int) {
        val point = AxisConverter.userToSys(tam)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // ve truc

        canvas?.drawLine(0f,AxisConverter.heigh/2.toFloat(), AxisConverter.width.toFloat(),AxisConverter.heigh/2.toFloat(),paint)
        canvas?.drawLine(AxisConverter.width/2f,0f, AxisConverter.width/2f,AxisConverter.heigh.toFloat(),paint)
        listVatThe.forEach {
            it.draw(canvas!!)
        }
    }


}



