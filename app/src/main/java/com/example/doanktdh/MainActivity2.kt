package com.example.doanktdh

import android.graphics.Point
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.doanktdh.Point3D.Point3D
import com.example.doanktdh.Point3D.threeToTwoD
import com.example.doanktdh.dialog.AddHinhCauDialog
import com.example.doanktdh.dialog.AddHinhHopDialog
import com.example.doanktdh.vatthe.HinhCau
import com.example.doanktdh.vatthe.HinhHop
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity(), AddHinhCauDialog.AddHCListener, AddHinhHopDialog.AddHHListener {

    var drawInfo = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main2_menu,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.addHC -> {
                AddHinhCauDialog().show(supportFragmentManager,"")
                true
            }
            R.id.addHH -> {
                AddHinhHopDialog().show(supportFragmentManager,"")
                true
            }
            R.id.reset -> {
                bai2.reset()
                drawInfo = ""
                main2Text.setText(drawInfo)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }



    override fun addHC(tam: Point3D, radius: Int) {
        bai2.addHinhCau(tam.threeToTwoD(),radius)
        // add vao string info
        drawInfo += "Hình cầu: Tâm(X:${tam.x},Y: ${tam.y},Z: ${tam.z}) Bán kính: $radius \n"
        main2Text.setText(drawInfo)

    }

    override fun addHH(tam: Point3D, dai: Int, rong: Int, cao: Int) {
        bai2.addHinhHop(tam.threeToTwoD(),dai,rong,cao)
        // add vao string info
        drawInfo += "HÌnh hộp: Tâm(X:${tam.x}, Y:${tam.y}, Z:${tam.z}) Cao: $cao, Dài: $dai, Rộng: ${rong}\n"
        main2Text.setText(drawInfo)
    }


}