package com.example.doanktdh.customview


import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.example.doanktdh.utils.AxisConverter
import com.example.doanktdh.utils.TwoDTrans
import com.example.doanktdh.vatthe.VatThe
import com.example.doanktdh.matran.toMatrix
import com.example.doanktdh.vatthe.ConCho
import com.example.doanktdh.vatthe.ConGau
import com.example.doanktdh.vatthe.Wave

/**
 * Class quản lý view bài 1 chứa 3 vật thể : Chó, Gấu, Sóng Âm
 * - thực hiện animation animateView()
 * - vẽ 3 đối tượng trong onDraw() của android
 * - listener gửi vị trí của các vật thể cho activity
 */

class Bai1View(context: Context, attributes: AttributeSet): View(context,attributes) {
    var listener: ((PointF,PointF) -> Unit)? = null

    val listVatThe = ArrayList<VatThe>() // danh sach cac vat the
    val dog = ConCho(PointF(1500f,300f))
    val bear = ConGau(PointF(900f,500f))
    val wave = Wave(PointF(500f,1000f),1)
    init {
        // add toan bo vat the vao list
        listVatThe.add(dog)
        listVatThe.add(bear)
        listVatThe.add(wave)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        listVatThe.forEach {
            it.draw(canvas!!)
        }
    }

    fun animateView() { // call trong luong khac
        // animate con gau
        val va = ValueAnimator.ofFloat(-100f, 100f)
        va.duration = 1000.toLong()
        va.addUpdateListener { animation ->
            val animatedValue: Float = animation.animatedValue as Float
            // toa do tam -> toa do ma tran
            val tamBearMT = bear.tam.toMatrix()
            // thuc hien nhan cac ma tran
            val mtTinhTien =
                TwoDTrans.mtTinhTien(animatedValue, 0f)
            val newDogMT = tamBearMT * mtTinhTien
            // ma tran -> toa do tam
            val newBearPoint = newDogMT.toPoint()
            bear.tam.x = newBearPoint.x
            bear.tam.y = newBearPoint.y
            //update giao dien thong tin vi tri con cho con gau
            listener?.invoke(bear.tam,dog.tam)
            postInvalidate()
        }
        va.repeatCount = ValueAnimator.INFINITE

            // animate con cho
        val va2 = ValueAnimator.ofFloat(0f, 360f)
        va2.duration = 5000.toLong()
        va2.repeatCount = ValueAnimator.INFINITE
        va2.addUpdateListener { animation ->
            val animatedValue: Float = animation.animatedValue as Float
            // toa do tam -> toa do ma tran
            val tamDogMT = dog.tam.toMatrix()
            val a = AxisConverter.width /2f
            val b = AxisConverter.heigh /2f

            // thuc hien nhan cac ma tranxyy
            val mtTinhTien = TwoDTrans.mtTinhTien(-a, -b)
            val mtXoay =
                TwoDTrans.mtXoay(animatedValue / 180)
            val mtTinhTien2 = TwoDTrans.mtTinhTien(a, b)

            val newDogMT = tamDogMT * mtTinhTien * mtXoay * mtTinhTien2

            // ma tran -> toa do tam
            val newDogPoint = newDogMT.toPoint()
            dog.tam.x = newDogPoint.x
            dog.tam.y = newDogPoint.y
        }


        // animate mau
        val colorFrom = Color.RED
        val colorTo = Color.BLUE
        val colorAnimation =
            ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
        colorAnimation.duration = 1000 // milliseconds
        colorAnimation.repeatCount = ValueAnimator.INFINITE
        colorAnimation.addUpdateListener { animator ->
            bear.changeColor(animator.animatedValue as Int)
        }


        val colorFrom2 = Color.CYAN
        val colorTo2 = Color.MAGENTA
        val colorAnimation2 =
            ValueAnimator.ofObject(ArgbEvaluator(), colorFrom2, colorTo2)
        colorAnimation2.repeatCount = ValueAnimator.INFINITE
        colorAnimation2.duration = 1000 // milliseconds
        colorAnimation2.addUpdateListener { animator ->
            dog.changeColor(animator.animatedValue as Int)
        }

        // animate song am
        val va3 = ValueAnimator.ofInt(0, 20)
        va3.duration = 2000.toLong()
        va3.repeatCount = ValueAnimator.INFINITE
        va3.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Int
            wave.waveCount = animatedValue // thay doi so luong wave
        }

        // ket hop tat ca animation tren
        val animatorSet = AnimatorSet()
        animatorSet.play(va2).with(va).with(colorAnimation).with(colorAnimation2).with(va3)
        animatorSet.interpolator = LinearInterpolator()
        animatorSet.start()
    }
}