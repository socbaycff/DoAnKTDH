package com.example.doanktdh

import android.content.Intent
import android.content.res.Resources
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import androidx.lifecycle.lifecycleScope
import com.example.doanktdh.dialog.AddHinhCauDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
   lateinit var mp: MediaPlayer
     var animateSwitch : MenuItem? = null
    var isAnimate = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mp = MediaPlayer.create(applicationContext, R.raw.music)
        mp.isLooping = true
        bai1View.background = getResources().getDrawable( R.drawable.wall);
       bai1View.listener = { tamgau,tamcho ->
            val tamGau = AxisConverter.sysToUser(tamgau)
           val tamCho = AxisConverter.userToSys(tamcho)
           textViewMain.setText("Tâm gấu: (${tamGau.x}, ${tamGau.y}) tâm chó: (${tamCho.x}, ${tamCho.y})")

       }
    }

    override fun onPause() {
        super.onPause()
        mp.stop()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when (item.itemId) {
            R.id.next -> {
                startActivity(Intent(this,MainActivity2::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        animateSwitch = menu?.findItem(R.id.animate_switch)
        animateSwitch?.isChecked = isAnimate
        val switch = animateSwitch?.actionView?.findViewById<Switch>(R.id.switchItem)
        switch?.setOnCheckedChangeListener { buttonView, isChecked ->
           if (isChecked) {

               mp.start()
               bai1View.animateView()
           } else {
                mp.pause()

           }
        }
        return super.onPrepareOptionsMenu(menu)
    }
}
