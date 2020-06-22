package com.example.doanktdh

import android.graphics.Point
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
      //  bai2.addHinhHop(PointF(0f,-0f),500,500,500)
        bai2.addHinhCau(PointF(500f,500f),500)

    }
}