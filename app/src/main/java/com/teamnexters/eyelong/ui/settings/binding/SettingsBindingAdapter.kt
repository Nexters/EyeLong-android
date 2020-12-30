package com.teamnexters.eyelong.ui.settings.binding

import android.content.Context
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.teamnexters.eyelong.R
import java.time.Duration
import java.time.LocalTime

fun LocalTime.format(format: String) = String.format(format, hour, minute)
fun LocalTime.meridiem(context: Context) =
    context.getString(if (hour >= 12) R.string.post_meridiem else R.string.ante_meridiem)

fun LocalTime.count(start: LocalTime, end: LocalTime) = if (start.isAfter(end)) {
    val diff = Duration.ofDays(1).toNanos() - start.toNanoOfDay()
    diff + end.toNanoOfDay()
} else {
    Duration.between(start, end).toNanos()
}.let { it / toNanoOfDay() }

@BindingAdapter("meridiem")
fun bindMeridiem(view: TextView, time: LocalTime?) {
    view.apply {
        text = time?.meridiem(context) ?: context.getString(R.string.ante_meridiem)
        isEnabled = time != null
    }
}

@BindingAdapter("time")
fun bindTime(view: TextView, time: LocalTime?) {
    view.apply {
        text = time?.format("%02d : %02d") ?: context.getString(R.string.clock)
        isEnabled = time != null
    }
}
