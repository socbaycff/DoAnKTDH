package com.example.doanktdh.vatthe

import android.graphics.*
import androidx.core.graphics.toPoint
import com.example.doanktdh.point3d.Point3D
import com.example.doanktdh.point3d.threeToTwoD
import com.example.doanktdh.utils.AxisConverter
import com.example.doanktdh.utils.LineMode
import com.example.doanktdh.utils.drawLineMidPoint
import kotlin.math.sqrt

class HinhHop(tam: Point3D,var dai: Int, var rong: Int, var cao: Int): VatThe(tam.threeToTwoD()) {

    var a: Point
    var b: Point
    var c: Point
    var d: Point

    var e: Point
    var f: Point
    var g: Point
    var h: Point

    init {


        val b3d = Point3D(tam.x+rong,tam.y,tam.z)
        val c3d = Point3D(b3d.x,b3d.y-dai,b3d.z)
        val d3d = Point3D(tam.x,tam.y-dai,tam.z)
        val e3d = Point3D(tam.x,tam.y,tam.z+cao)
        val f3d = Point3D(b3d.x,b3d.y,b3d.z+cao)
        val h3d = Point3D(c3d.x,c3d.y,c3d.z+cao)
        val g3d = Point3D(d3d.x,d3d.y,d3d.z+cao)

        a = AxisConverter.userToSys(tam.threeToTwoD()).toPoint()
        b = AxisConverter.userToSys(b3d.threeToTwoD()).toPoint()
        c = AxisConverter.userToSys(c3d.threeToTwoD()).toPoint()
        d = AxisConverter.userToSys(d3d.threeToTwoD()).toPoint()

        e = AxisConverter.userToSys(e3d.threeToTwoD()).toPoint()
        f = AxisConverter.userToSys(f3d.threeToTwoD()).toPoint()
        h = AxisConverter.userToSys(h3d.threeToTwoD()).toPoint()
        g = AxisConverter.userToSys(g3d.threeToTwoD()).toPoint()
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
        drawLineMidPoint(
            a.x,
            a.y,
            b.x,
            b.y,
            LineMode.SOLID,
            paint,
            canvas
        )
        drawLineMidPoint(
            b.x,
            b.y,
            c.x,
            c.y,
            LineMode.SOLID,
            paint,
            canvas
        )
        drawLineMidPoint(
            c.x,
            c.y,
            d.x,
            d.y,
            LineMode.DASH,
            paint,
            canvas
        )
        drawLineMidPoint(
            a.x,
            a.y,
            d.x,
            d.y,
            LineMode.DASH,
            paint,
            canvas
        )
        // ve mat tren
        drawLineMidPoint(
            e.x,
            e.y,
            f.x,
            f.y,
            LineMode.SOLID,
            paint,
            canvas
        )
        drawLineMidPoint(
            f.x,
            f.y,
            h.x,
            h.y,
            LineMode.SOLID,
            paint,
            canvas
        )
        drawLineMidPoint(
            h.x,
            h.y,
            g.x,
            g.y,
            LineMode.SOLID,
            paint,
            canvas
        )
        drawLineMidPoint(
            g.x,
            g.y,
            e.x,
            e.y,
            LineMode.SOLID,
            paint,
            canvas
        )

        // ve 4 duong cao
        drawLineMidPoint(
            a.x,
            a.y,
            e.x,
            e.y,
            LineMode.SOLID,
            paint,
            canvas
        )
        drawLineMidPoint(
            b.x,
            b.y,
            f.x,
            f.y,
            LineMode.SOLID,
            paint,
            canvas
        )
        drawLineMidPoint(
            c.x,
            c.y,
            h.x,
            h.y,
            LineMode.SOLID,
            paint,
            canvas
        )
        drawLineMidPoint(
            d.x,
            d.y,
            g.x,
            g.y,
            LineMode.DASH,
            paint,
            canvas
        )
   }

}