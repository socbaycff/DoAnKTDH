package com.example.doanktdh.vatthe

import android.graphics.*
import androidx.core.graphics.toPoint
import com.example.doanktdh.LineMode
import com.example.doanktdh.VatThe
import com.example.doanktdh.drawLineMidPoint

class HinhHop(tam: PointF,var dai: Int, var rong: Int, var cao: Int): VatThe(tam) {

    var a: Point
    var b: Point
    var c: Point
    var d: Point

    var e: Point
    var f: Point
    var g: Point
    var h: Point
    init {
        a = tam.toPoint()
        b = Point(a.x + rong,a.y)
        c = Point(b.x + dai/2 , b.y - dai/2)
        d = Point(a.x + dai/2, a.y - dai/2)

        e = Point(a.x,a.y-cao)
        f = Point(b.x,b.y-cao)
        h = Point(c.x,c.y-cao)
        g = Point(d.x,d.y-cao)
    }
    val paint =
        Paint().apply {
            color = Color.RED
            style = Paint.Style.STROKE
            strokeWidth = 5f
            strokeCap = Paint.Cap.ROUND
        }


    override fun draw(canvas: Canvas) {
        // ve mat duoi
        drawLineMidPoint(a.x,a.y,b.x,b.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(b.x, b.y, c.x,c.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(c.x,c.y,d.x,d.y,LineMode.DASH,paint,canvas)
        drawLineMidPoint(a.x,a.y,d.x,d.y,LineMode.DASH,paint,canvas)
        // ve mat tren
        drawLineMidPoint(e.x,e.y,f.x,f.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(f.x, f.y, h.x,h.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(h.x,h.y,g.x,g.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(g.x,g.y,e.x,e.y,LineMode.SOLID,paint,canvas)

        // ve 4 duong cao
        drawLineMidPoint(a.x,a.y,e.x,e.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(b.x,b.y,f.x,f.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(c.x,c.y,h.x,h.y,LineMode.SOLID,paint,canvas)
        drawLineMidPoint(d.x,d.y,g.x,g.y,LineMode.DASH,paint,canvas)


   }

}