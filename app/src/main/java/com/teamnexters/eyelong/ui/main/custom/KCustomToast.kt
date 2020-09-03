package com.teamnexters.eyelong.ui.main.custom

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.layout_custom_toast.view.*

class KCustomToast {

    companion object {
        fun show(context: Context, message: String) {
            LayoutInflater.from(context).inflate(R.layout.layout_custom_toast, null)
                .apply {
                    tv_custom_toast.text = message
                    tv_custom_toast.setTextColor(Color.WHITE)
                }.let {
                    Toast(context).apply {
                        view = it
                        duration = Toast.LENGTH_SHORT

                        setGravity(Gravity.BOTTOM, 0, 300)
                    }.show()
                }
        }
    }
}