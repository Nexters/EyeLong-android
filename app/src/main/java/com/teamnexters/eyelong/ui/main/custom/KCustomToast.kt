package com.teamnexters.eyelong.ui.main.custom

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.layout_custom_toast.view.*

class KCustomToast private constructor(
    context: Context,
    layoutParams: LayoutParams,
    message: String
) {
    private val toast = LayoutInflater.from(context).inflate(R.layout.layout_custom_toast, null)
        .apply {
            tv_custom_toast.text = message
            tv_custom_toast.setTextColor(layoutParams.color)
        }.let {
            Toast(context).apply {
                view = it
                duration = Toast.LENGTH_SHORT

                setGravity(layoutParams.gravity, 0, 300)
            }
        }

    fun show() {
        toast.show()
    }

    class LayoutParams(val color: Int, val gravity: Int)

    class Builder(private val context: Context) {
        var message = ""
        var layoutParams = LayoutParams(color = Color.WHITE, gravity = Gravity.BOTTOM)

        fun build() = KCustomToast(context, layoutParams, message)
    }
}
