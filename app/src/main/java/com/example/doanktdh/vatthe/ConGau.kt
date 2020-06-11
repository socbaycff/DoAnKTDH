package com.example.doanktdh.vatthe

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import com.example.doanktdh.LineMode
import com.example.doanktdh.VatThe
import com.example.doanktdh.drawLineMidPoint

class ConGau(tam: Point) : VatThe(tam) {
    val paint =
        Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 10f
            strokeCap = Paint.Cap.ROUND
        }
    override fun draw(canvas: Canvas) {
        val gocTrai = Point(tam.x - 417,tam.y - 220)
        val offsetX = tam.x - 417
        val offsetY = tam.y - 220
        // bung
        drawLineMidPoint(offsetX+ 270,offsetY+ 27,offsetX+317,offsetY+295,LineMode.SOLID,paint, canvas)// 1
        drawLineMidPoint(offsetX+270,offsetY+27,offsetX+482,offsetY+48,LineMode.SOLID,paint,canvas)// 2
        drawLineMidPoint(offsetX+482,offsetY+48,offsetX+474,offsetY+288,LineMode.SOLID,paint,canvas)//3
        drawLineMidPoint(offsetX+317,offsetY+295,offsetX+476,offsetY+240,LineMode.SOLID,paint,canvas)//4

        // mong va chan phai
        drawLineMidPoint(offsetX+270,offsetY+27,offsetX+131,offsetY+111,LineMode.SOLID,paint,canvas)//5
        drawLineMidPoint(offsetX+131,offsetY+111,offsetX+125,offsetY+187,LineMode.SOLID,paint,canvas)//6
        drawLineMidPoint(offsetX+125,offsetY+187,offsetX+260,offsetY+410,LineMode.SOLID,paint,canvas)//7
        drawLineMidPoint(offsetX+260,offsetY+410,offsetX+309,offsetY+375,LineMode.SOLID,paint,canvas)//8
        drawLineMidPoint(offsetX+309,offsetY+375,offsetX+317,offsetY+295,LineMode.SOLID,paint,canvas)//9
        // ban chan phai
        drawLineMidPoint(offsetX+260,offsetY+410,offsetX+369,offsetY+424,LineMode.SOLID,paint,canvas)//10
        drawLineMidPoint(offsetX+309,offsetY+375,offsetX+370,offsetY+400,LineMode.SOLID,paint,canvas)//11
        drawLineMidPoint(offsetX+369,offsetY+424,offsetX+370,offsetY+400,LineMode.SOLID,paint,canvas)//12
        // chan trai
        drawLineMidPoint(offsetX+131,offsetY+111,offsetX+93,offsetY+264,LineMode.SOLID,paint,canvas)//13
        drawLineMidPoint(offsetX+93,offsetY+264,offsetX+23,offsetY+359,LineMode.SOLID,paint,canvas)//14
        drawLineMidPoint(offsetX+23,offsetY+359,offsetX+54,offsetY+418,LineMode.SOLID,paint,canvas)//15
        drawLineMidPoint(offsetX+54,offsetY+418,offsetX+111,offsetY+414,LineMode.SOLID,paint,canvas)//16
        drawLineMidPoint(offsetX+111,offsetY+414,offsetX+111,offsetY+391,LineMode.SOLID,paint,canvas)//17
        drawLineMidPoint(offsetX+111,offsetY+391,offsetX+70,offsetY+395,LineMode.SOLID,paint,canvas)//18
        drawLineMidPoint(offsetX+70,offsetY+395,offsetX+62,offsetY+363,LineMode.SOLID,paint,canvas)// *
        drawLineMidPoint(offsetX+62,offsetY+363,offsetX+180,offsetY+277,LineMode.SOLID,paint,canvas)//19
        drawLineMidPoint(offsetX+180,offsetY+277,offsetX+93,offsetY+264,LineMode.SOLID,paint,canvas)//20
        drawLineMidPoint(offsetX+23,offsetY+359,offsetX+62,offsetY+363,LineMode.SOLID,paint,canvas)//21
        drawLineMidPoint(offsetX+54,offsetY+418,offsetX+70,offsetY+395,LineMode.SOLID,paint,canvas)//22
        //2 tay + vai
        drawLineMidPoint(offsetX+482,offsetY+48,offsetX+547,offsetY+14,LineMode.SOLID,paint,canvas)//23
        drawLineMidPoint(offsetX+547,offsetY+14,offsetX+670,offsetY+73,LineMode.SOLID,paint,canvas)//24
        drawLineMidPoint(offsetX+670,offsetY+73,offsetX+533,offsetY+323,LineMode.SOLID,paint,canvas)//25
        drawLineMidPoint(offsetX+474,offsetY+288,offsetX+619,offsetY+356,LineMode.SOLID,paint,canvas)//26
        drawLineMidPoint(offsetX+619,offsetY+356,offsetX+625,offsetY+334,LineMode.SOLID,paint,canvas)//27
        drawLineMidPoint(offsetX+625,offsetY+334,offsetX+565,offsetY+258,LineMode.SOLID,paint,canvas)//28
        drawLineMidPoint(offsetX+619,offsetY+356,offsetX+619,offsetY+399,LineMode.SOLID,paint,canvas)//29
        drawLineMidPoint(offsetX+619,offsetY+399,offsetX+594,offsetY+397,LineMode.SOLID,paint,canvas)//30
        drawLineMidPoint(offsetX+594,offsetY+397,offsetX+586,offsetY+350,LineMode.SOLID,paint,canvas)//31

        drawLineMidPoint(offsetX+474,offsetY+288,offsetX+473,offsetY+341,LineMode.SOLID,paint,canvas)//32
        drawLineMidPoint(offsetX+473,offsetY+341,offsetX+512,offsetY+412,LineMode.SOLID,paint,canvas)//33
        drawLineMidPoint(offsetX+512,offsetY+412,offsetX+556,offsetY+424,LineMode.SOLID,paint,canvas)//34
        drawLineMidPoint(offsetX+556,offsetY+424,offsetX+558,offsetY+404,LineMode.SOLID,paint,canvas)//35
        drawLineMidPoint(offsetX+558,offsetY+404,offsetX+531,offsetY+394,LineMode.SOLID,paint,canvas)//36
        drawLineMidPoint(offsetX+531,offsetY+394,offsetX+523,offsetY+323,LineMode.SOLID,paint,canvas)//37
        drawLineMidPoint(offsetX+547,offsetY+14,offsetX+600,offsetY+180,LineMode.SOLID,paint,canvas)//38
        // dau
        drawLineMidPoint(offsetX+600,offsetY+180,offsetX+730,offsetY+204,LineMode.SOLID,paint,canvas)//39
        drawLineMidPoint(offsetX+730,offsetY+204,offsetX+776,offsetY+135,LineMode.SOLID,paint,canvas)//40
        drawLineMidPoint(offsetX+776,offsetY+135,offsetX+756,offsetY+90,LineMode.SOLID,paint,canvas)//41
        drawLineMidPoint(offsetX+756,offsetY+90,offsetX+670,offsetY+73,LineMode.SOLID,paint,canvas)//42
        // tai
        drawLineMidPoint(offsetX+705,offsetY+74,offsetX+715,offsetY+40,LineMode.SOLID,paint,canvas)//43
        drawLineMidPoint(offsetX+715,offsetY+40,offsetX+752,offsetY+46,LineMode.SOLID,paint,canvas)//44
        drawLineMidPoint(offsetX+752,offsetY+46,offsetX+742,offsetY+81,LineMode.SOLID,paint,canvas)//45
        // mom
        drawLineMidPoint(offsetX+769,offsetY+150,offsetX+824,offsetY+183,LineMode.SOLID,paint,canvas)//46
        drawLineMidPoint(offsetX+824,offsetY+183,offsetX+800,offsetY+214,LineMode.SOLID,paint,canvas)//47
        drawLineMidPoint(offsetX+800,offsetY+214,offsetX+737,offsetY+196,LineMode.SOLID,paint,canvas)//48

    }

}