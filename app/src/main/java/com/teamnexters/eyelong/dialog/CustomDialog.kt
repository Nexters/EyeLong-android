package com.teamnexters.eyelong.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.layout_custom_dialog.*
import java.util.*

class CustomDialog(
    context: Context,
    private val title: String,
    private val message: String,
    private val confirmButtonText: String,
    private val cancelButtonText: String,
    private var onConfirm: (() -> Unit)? = null,
    private var onCancel: (() -> Unit)? = null
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_custom_dialog)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        tv_custom_dialog_title.text = title
        tv_custom_dialog_message.text = message

        btn_custom_dialog_confirm.text = confirmButtonText
        btn_custom_dialog_confirm.setOnClickListener {
            onConfirm?.invoke()
            dismiss()
        }

        btn_custom_dialog_cancel.text = cancelButtonText
        btn_custom_dialog_cancel.setOnClickListener {
            onCancel?.invoke()
            dismiss()
        }
    }
}