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
import kotlinx.android.synthetic.main.dialog_hinh_cau.view.*


class AddHinhCauDialog : AppCompatDialogFragment() {

    private var listener: AddHCListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = activity!!.layoutInflater
        val view: View = inflater.inflate(R.layout.dialog_hinh_cau, null)
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setView(view)
            .setTitle("Thêm hình cầu")
            .setPositiveButton("Huỷ") { _, i ->
                Toast.makeText(context, "Đã huỷ", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("OK")
            { _, i ->
                val x = view.xhinhcau.text.toString().toFloat()
                val y = view.yhinhcau.text.toString().toFloat()
                val z = view.zhinhcau.text.toString().toFloat()
                val bk = view.bankinhhc.text.toString().toInt()
                listener?.addHC(Point3D(x, y, z), bk)
            }
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as AddHCListener
    }

    interface AddHCListener {
        fun addHC(tam: Point3D, radius: Int)
    }
}