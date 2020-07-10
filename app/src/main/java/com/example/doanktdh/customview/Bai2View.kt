package com.example.doanktdh.customview


import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import com.example.doanktdh.point3d.Point3D
import com.example.doanktdh.point3d.threeToTwoD
import com.example.doanktdh.utils.AxisConverter
import com.example.doanktdh.vatthe.VatThe
import com.example.doanktdh.vatthe.HinhCau
import com.example.doanktdh.vatthe.HinhHop

/**
 * Class quản lý view bài 2 vẽ 2 đối tượng 3d: hình hôp , hình cầu
 * - vẽ tất cả vật thể thuộc 2 loại trên (chứa trong danh sách vật thể) trong onDraw
 * - xoá tất cả vật thể trong danh sách với hàm reset
 */

class Bai2View(context: Context, attributes: AttributeSet): View(context,attributes) {

    private val listVatThe = ArrayList<VatThe>() // danh sach vat the

    val paint =
        Paint().apply {
            color = Color.BLUE
            style = Paint.Style.STROKE
            strokeWidth = 5f
            strokeCap = Paint.Cap.ROUND
        }

    val textPain =  Paint().apply {
        color = Color.BLUE
        textSize = 50f
        strokeCap = Paint.Cap.ROUND
    }

    fun addHinhHop(tam: Point3D, dai: Int, rong: Int, cao: Int) {
        listVatThe.add(HinhHop(tam,dai,rong,cao))
        postInvalidate()
    }

    fun addHinhCau(tam: Point3D, radius: Int) {
        listVatThe.add(HinhCau(tam,radius))
        postInvalidate()

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // ve truc x, y,z
        canvas?.drawLine(
            AxisConverter.width /2f,
            AxisConverter.heigh /2f, AxisConverter.width.toFloat(),
            AxisConverter.heigh /2f,paint)
        canvas?.drawLine(
            AxisConverter.width /2f,0f, AxisConverter.width /2f,
            AxisConverter.heigh /2f,paint)
        canvas?.drawLine(
            AxisConverter.width /2f,
            AxisConverter.heigh /2f,
            AxisConverter.width /2f- height/2 - 90 ,
            AxisConverter.heigh.toFloat(),paint)
        canvas?.drawText("X", width.toFloat() - 50,height/2f + 50,textPain)
        canvas?.drawText("Y", AxisConverter.width /2f- height/2 + 100,height.toFloat() - 50,textPain)
        canvas?.drawText("Z", width/2f + 20,50f,textPain)
        canvas?.drawText("O", AxisConverter.width /2f + 10,
            AxisConverter.heigh /2f - 10,textPain)

        // ve tat ca vat the trong danh sach
        listVatThe.forEach {
            it.draw(canvas!!)
        }
    }

    fun reset() {
        listVatThe.clear()
        postInvalidate()
    }



}



