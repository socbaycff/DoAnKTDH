@file:Suppress("unused")

package com.example.doanktdh

import android.app.Application
import android.content.res.Resources
import com.example.doanktdh.utils.AxisConverter


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // lay width heigh man hinh
        AxisConverter.width = Resources.getSystem().displayMetrics.widthPixels
        AxisConverter.heigh = Resources.getSystem().displayMetrics.heightPixels
    }

}