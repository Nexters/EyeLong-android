package com.teamnexters.eyelong.ui.habit.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityHabitAnalyticsBinding
import com.teamnexters.eyelong.ui.habit.viewmodel.HabitAnalyticsViewModel

class HabitAnalyticsActivity : AppCompatActivity() {
    private lateinit var habitAnalyticsViewModel: HabitAnalyticsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit_analytics)

        habitAnalyticsViewModel = HabitAnalyticsViewModel()

        val binding: ActivityHabitAnalyticsBinding =
            DataBindingUtil.setContentView(
                this@HabitAnalyticsActivity,
                R.layout.activity_habit_analytics
            )
        binding.setVariable(BR.viewModel, habitAnalyticsViewModel)
    }
}