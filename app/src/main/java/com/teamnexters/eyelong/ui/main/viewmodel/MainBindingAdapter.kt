package com.teamnexters.eyelong.ui.main.viewmodel

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("habitCount")
fun habitCount(view: View, count: Int) {
    val textView = view as TextView
    textView.apply { text = "${count}개 달성 완료!" }
}
