package com.example.doanktdh.vatthe

import android.graphics.*
import com.example.doanktdh.LineMode
import com.example.doanktdh.VatThe
import com.example.doanktdh.drawEllipse
import com.example.doanktdh.drawLineMidPoint

class ConCho(tam: PointF) : VatThe(tam) {
    fun changeColor(color: Int) {
        paint.color = color
    }
    val paint =
        Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 10f
            strokeCap = Paint.Cap.ROUND
        }
    override fun draw(canvas: Canvas) {
        val offsetX = (tam.x - 229).toInt()
        val offsetY = (tam.y - 206).toInt()
        // dau va chan truoc
        drawLineMidPoint(offsetX+ 215,offsetY+158,offsetX+ 178,offsetY+107,LineMode.SOLID,paint,canvas)//1
        drawLineMidPoint(offsetX+ 178,offsetY+107,offsetX+ 150,offsetY+39,LineMode.SOLID,paint,canvas)//2
        drawLineMidPoint(offsetX+ 150,offsetY+39, offsetX+ 100,offsetY+33,LineMode.SOLID,paint,canvas)//3
        drawLineMidPoint(offsetX+ 100,offsetY+33, offsetX+ 66,offsetY+49,LineMode.SOLID,paint,canvas)//4
        drawLineMidPoint(offsetX+ 66,offsetY+49,offsetX+ 14,offsetY+47,LineMode.SOLID,paint,canvas)//5
        drawLineMidPoint(offsetX+ 14,offsetY+47,offsetX+ 19,offsetY+103,LineMode.SOLID,paint,canvas)//6
        drawLineMidPoint(offsetX+ 19,offsetY+103,offsetX+ 105,offsetY+134,LineMode.SOLID,paint,canvas)//7
        drawLineMidPoint(offsetX+ 105,offsetY+134,offsetX+ 68,offsetY+65,LineMode.SOLID,paint,canvas)//8
        drawLineMidPoint(offsetX+ 68,offsetY+65,offsetX+ 100,offsetY+33,LineMode.SOLID,paint,canvas)//9
        drawLineMidPoint(offsetX+ 100,offsetY+33,offsetX+ 155,offsetY+65,LineMode.SOLID,paint,canvas)//10
        drawLineMidPoint(offsetX+ 155,offsetY+65,offsetX+ 71,offsetY+184,LineMode.SOLID,paint,canvas)//11
        drawLineMidPoint(offsetX+ 71,offsetY+184,offsetX+ 125,offsetY+326,LineMode.SOLID,paint,canvas)//12
        drawLineMidPoint(offsetX+ 125,offsetY+326,offsetX+ 124,offsetY+372,LineMode.SOLID,paint,canvas)//13
        drawLineMidPoint(offsetX+ 124,offsetY+372,offsetX+ 114,offsetY+385,LineMode.SOLID,paint,canvas)//14
        drawLineMidPoint(offsetX+ 114,offsetY+385,offsetX+ 131,offsetY+387,LineMode.SOLID,paint,canvas)//15
        drawLineMidPoint(offsetX+ 131,offsetY+387,offsetX+ 146,offsetY+376,LineMode.SOLID,paint,canvas)//16
        drawLineMidPoint(offsetX+ 146,offsetY+376,offsetX+ 215,offsetY+158,LineMode.SOLID,paint,canvas)//17
        drawLineMidPoint(offsetX+ 125,offsetY+326,offsetX+ 150,offsetY+350,LineMode.SOLID,paint,canvas)//18
        drawLineMidPoint(offsetX+ 150,offsetY+39,offsetX+ 192,offsetY+179,LineMode.SOLID,paint,canvas)//19
        drawLineMidPoint(offsetX+ 192,offsetY+179,offsetX+ 102,offsetY+234,LineMode.SOLID,paint,canvas)//20
        drawLineMidPoint(offsetX+ 102,offsetY+234,offsetX+ 71,offsetY+184,LineMode.SOLID,paint,canvas)//21
        drawLineMidPoint(offsetX+ 86,offsetY+128,offsetX+ 89,offsetY+158,LineMode.SOLID,paint,canvas)//22
        drawLineMidPoint(offsetX+ 18,offsetY+63,offsetX+ 33,offsetY+51,LineMode.SOLID,paint,canvas)//23
        // bung va chan duoi
        drawLineMidPoint(offsetX+ 169,offsetY+283,offsetX+ 283,offsetY+274,LineMode.SOLID,paint,canvas)//24
        drawLineMidPoint(offsetX+ 283,offsetY+274,offsetX+ 342,offsetY+326,LineMode.SOLID,paint,canvas)//25
        drawLineMidPoint(offsetX+ 342,offsetY+326,offsetX+ 335,offsetY+394,LineMode.SOLID,paint,canvas)//26
        drawLineMidPoint(offsetX+ 335,offsetY+394,offsetX+ 348,offsetY+397,LineMode.SOLID,paint,canvas)//27
        drawLineMidPoint(offsetX+ 348,offsetY+397,offsetX+ 405,offsetY+240,LineMode.SOLID,paint,canvas)//28
        drawLineMidPoint(offsetX+ 405,offsetY+240,offsetX+ 372,offsetY+147,LineMode.SOLID,paint,canvas)//29
        drawLineMidPoint(offsetX+ 372,offsetY+147,offsetX+ 215,offsetY+158,LineMode.SOLID,paint,canvas)//30
        drawLineMidPoint(offsetX+ 283,offsetY+274,offsetX+ 372,offsetY+147,LineMode.SOLID,paint,canvas)//31
        //duoi
        drawLineMidPoint(offsetX+ 372,offsetY+147,offsetX+ 400,offsetY+136,LineMode.SOLID,paint,canvas)//32
        drawLineMidPoint(offsetX+ 400,offsetY+136,offsetX+ 426,offsetY+34,LineMode.SOLID,paint,canvas)//33
        drawLineMidPoint(offsetX+ 426,offsetY+34, offsetX+ 440,offsetY+49,LineMode.SOLID,paint,canvas)//34
        drawLineMidPoint(offsetX+ 440,offsetY+49,offsetX+ 423,offsetY+150,LineMode.SOLID,paint,canvas)//35
        drawLineMidPoint(offsetX+ 423,offsetY+150,offsetX+ 394,offsetY+202,LineMode.SOLID,paint,canvas)//36
        drawLineMidPoint(offsetX+ 426,offsetY+34,offsetX+ 423,offsetY+150,LineMode.SOLID,paint,canvas)//37


        // ve ellipse
        drawEllipse(400f,300f,tam.x,tam.y,LineMode.SOLID,paint,canvas)
    }

}