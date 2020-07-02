package com.example.doanktdh

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.chibde.visualizer.BarVisualizer
import com.example.doanktdh.utils.AxisConverter
import kotlinx.android.synthetic.main.activity_bai1.*

@Suppress("DEPRECATION")
@SuppressLint("SetTextI18n")
class Bai1Activity : AppCompatActivity() {
    lateinit var mp: MediaPlayer
    private var animateSwitch: MenuItem? = null
    private var isAnimate = false
    private lateinit var barVisualizer: BarVisualizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bai1)
        mp = MediaPlayer.create(applicationContext, R.raw.edit)
        mp.isLooping = true
        barVisualizer = musicvisual
        // check quyen truy cap audio
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            )
            == PackageManager.PERMISSION_GRANTED
        ) {
            startVisualizer()
        } else {
            ActivityCompat
                .requestPermissions(
                    this,
                    arrayOf(Manifest.permission.RECORD_AUDIO),
                    0
                )
        }
        // set background và lắng nghe sự kiện đổi vị trí tâm gấu chó
        bai1View.background = resources.getDrawable(R.drawable.wall)
        bai1View.listener = { tamgau, tamcho ->
            val tamGau = AxisConverter.sysToUser(tamgau)
            val tamCho = AxisConverter.userToSys(tamcho)
            textViewMain.text = "Tâm gấu: (${tamGau.x}, ${tamGau.y}) tâm chó: (${tamCho.x}, ${tamCho.y})"
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        startVisualizer()
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }


    override fun onPause() {
        super.onPause()
        mp.stop()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.next -> {
                startActivity(Intent(this, Bai2Activity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        animateSwitch = menu?.findItem(R.id.animate_switch)
        animateSwitch?.isChecked = isAnimate
        val switch = animateSwitch?.actionView?.findViewById<Switch>(R.id.switchItem)
        switch?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                mp.start()
                bai1View.animateView()
            } else {
                mp.pause()
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }

    private fun startVisualizer() {
        barVisualizer.setPlayer(mp.audioSessionId)
        barVisualizer.setDensity(100f)
        barVisualizer.setColor(Color.MAGENTA)
    }
}
