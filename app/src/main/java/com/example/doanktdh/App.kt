package com.example.doanktdh

import android.app.Application
import android.content.res.Resources
import android.view.Display


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        AxisConverter.width = Resources.getSystem().getDisplayMetrics().widthPixels
        AxisConverter.heigh = Resources.getSystem().getDisplayMetrics().heightPixels
    }

}