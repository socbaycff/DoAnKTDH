package com.example.doanktdh.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.doanktdh.R
import com.example.doanktdh.point3d.Point3D
import kotlinx.android.synthetic.main.dialog_hinh_hop.view.*


class AddHinhHopDialog : AppCompatDialogFragment() {

    private var listener: AddHHListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = activity!!.layoutInflater
        val view: View = inflater.inflate(R.layout.dialog_hinh_hop, null)
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setView(view)
            .setTitle("Thêm hình hộp")
            .setPositiveButton("Huỷ")
                { _, i ->
                    Toast.makeText(context, "Đã huỷ", Toast.LENGTH_SHORT).show()
                }
            .setNegativeButton("OK")
                { _, i ->
                    val x = view.xhinhhop.text.toString().toFloat()
                    val y = view.yhinhhop.text.toString().toFloat()
                    val z = view.zhinhhop.text.toString().toFloat()
                    val cao = view.cao.text.toString().toInt()
                    val dai = view.dai.text.toString().toInt()
                    val rong = view.rong.text.toString().toInt()
                    listener?.addHH(Point3D(x,y,z),dai,rong,cao)
                }
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as AddHHListener
    }

    interface AddHHListener {
        fun addHH(tam: Point3D,dai: Int, rong: Int, cao: Int)
    }
}