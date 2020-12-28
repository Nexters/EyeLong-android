package com.teamnexters.eyelong.ui.main.custom

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.util.DateUtil
import java.time.DayOfWeek


class ExerciseProgressView : LinearLayout {
    constructor(context: Context?) : super(context) {
        initView(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    private fun initView(context: Context?) {
        context?.let {
            val inflater = it.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.layout_main_exercise, this@ExerciseProgressView, false)
                .apply {
                    addView(this)
                }
        }

        with(findViewById<ImageView>(R.id.img_main_exercise_character)) {
            val dayOfWeek = DateUtil.dayOfWeek()
            val xPos = (dayOfWeek.value - 1) * 64f

            translationX = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                xPos,
                resources.displayMetrics
            )
        }

        with(findViewById<LinearLayout>(R.id.week_main_exercise)) {
            children.map { it as TextView }.forEach {
                context?.run {
                    val dayOfWeek = DateUtil.dayOfWeek()

                    if (indexOfChild(it) == dayOfWeek.value - 1) {
                        it.setTextColor(getColor(R.color.colorWhite))
                        it.background = getDrawable(R.drawable.bg_main_exercise_oval)
                    } else {
                        it.setTextColor(getColor(R.color.colorBlack))
                        it.background = null
                    }
                }
            }
        }
    }

    private fun initView(context: Context?, attrs: AttributeSet?) {
        initView(context)
    }

    fun setProgress(progress: Int) {
        with(findViewById<LinearLayout>(R.id.progress_main_exercise)) {
            for (index in 1..progress) {
                View(context).apply {
                    layoutParams = LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.WRAP_CONTENT
                    ).apply {
                        width = TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_DIP,
                            64f,
                            resources.displayMetrics
                        ).toInt()
                    }

                    background = context.getDrawable(
                        when (index) {
                            DayOfWeek.MONDAY.value -> R.drawable.bg_main_exercise_progress_start
                            DayOfWeek.SUNDAY.value -> R.drawable.bg_main_exercise_progress_end
                            else -> R.drawable.bg_main_exercise_progress_do
                        }
                    )
                }.also {
                    addView(it)
                }
            }
        }
    }
}
