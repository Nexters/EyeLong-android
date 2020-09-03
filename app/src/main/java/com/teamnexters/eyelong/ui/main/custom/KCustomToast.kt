package com.teamnexters.eyelong.ui.main.custom

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.layout_custom_toast.view.*

class KCustomToast private constructor(context: Context, configure: Configure, message: String) {
    private val toast = LayoutInflater.from(context).inflate(R.layout.layout_custom_toast, null)
        .apply {
            root_custom_toast.background = context.getDrawable(configure.level.resId)
            tv_custom_toast.text = message
            tv_custom_toast.setTextColor(Color.WHITE)
        }.let {
            Toast(context).apply {
                view = it
                duration = Toast.LENGTH_SHORT

                setGravity(configure.gravity, 0, 300)
            }
        }

    fun show() {
        toast.show()
    }

    class Configure(val level: Level, val gravity: Int) {
        enum class Level(val resId: Int) {
            WARNING(R.drawable.bg_custom_toast_black),
            INFO(R.drawable.bg_custom_toast_blue)
        }
    }

    class Builder(private val context: Context) {
        var message = ""
        var configure = Configure(level = Configure.Level.WARNING, gravity = Gravity.BOTTOM)

        fun build() = KCustomToast(context, configure, message)
    }
}