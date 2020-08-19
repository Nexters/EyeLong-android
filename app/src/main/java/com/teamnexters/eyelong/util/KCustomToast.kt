package com.teamnexters.eyelong.util

import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.widget.Toast
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.custom_toast_layout.view.*

class KCustomToast {
    companion object {
        val GRAVITY_TOP = 48
        val GRAVITY_CENTER = 17
        val GRAVITY_BOTTOM = 80
        private lateinit var layoutInflater: LayoutInflater


        fun infoToast(context: Activity, message: String, position: Int) {
            layoutInflater = LayoutInflater.from(context)
            val layout = layoutInflater.inflate(
                R.layout.custom_toast_layout,
                (context).findViewById(R.id.custom_toast_layout)
            )
            layout.custom_toast_message.setTextColor(Color.WHITE)
            layout.custom_toast_message.text = message
            val toast = Toast(context.applicationContext)
            toast.duration = Toast.LENGTH_SHORT
            if (position == GRAVITY_BOTTOM) {
                toast.setGravity(position, 0, 300)
            } else {
                toast.setGravity(position, 0, 300)
            }
            toast.view = layout //setting the view of custom toast layout
            toast.show()
        }
    }
}