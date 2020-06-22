package com.example.doanktdh

import android.content.Intent
import android.content.res.Resources
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this,MainActivity2::class.java))
//        lifecycleScope.launch(Dispatchers.Main) {
//            bai1View.animateView()
//        }
//        bai1View.background = getResources().getDrawable( R.drawable.wall);
    }
}
