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
import androidx.databinding.ObservableArrayList
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.util.DateUtil
import java.time.DayOfWeek


class EyeLongChallengeView : LinearLayout {
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
        initView(context, attrs, defStyleAttr)
    }

    private fun initView(context: Context?) {
        context?.let {
            val inflater = it.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.layout_eyelong_challenge, this@EyeLongChallengeView, false)
                .apply {
                    addView(this)
                }
        }

        with(findViewById<ImageView>(R.id.img_character_eyelong_challenge)) {
            val dayOfWeek = DateUtil.dayOfWeek()
            val xPos = (dayOfWeek.value - 1) * 64f

            translationX = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                xPos,
                resources.displayMetrics
            )
        }

        with(findViewById<LinearLayout>(R.id.week_eyelong_challenge)) {
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

    private fun initView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) {
        initView(context)
    }

    fun setDoList(doList: ObservableArrayList<Boolean>) {
        with(findViewById<LinearLayout>(R.id.progress_eyelong_challenge)) {
            doList.forEachIndexed { index, done ->
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

                    if (done) {
                        background = context.getDrawable(
                            when (index) {
                                DayOfWeek.MONDAY.value - 1 -> R.drawable.bg_eyelong_progress_start
                                DayOfWeek.SUNDAY.value - 1 -> R.drawable.bg_eyelong_progress_end
                                else -> R.drawable.bg_eyelong_progress_do
                            }
                        )
                    }
                }.also {
                    addView(it)
                }
            }
        }
    }
}
