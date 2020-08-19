package com.teamnexters.eyelong.ui.habit.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityHabitCheckBinding
import com.teamnexters.eyelong.ui.habit.viewmodel.HabitCheckViewModel
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase

class HabitCheckActivity : AppCompatActivity() {
    private val habitCheckViewModel = HabitCheckViewModel(ActivityUseCase(this@HabitCheckActivity))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit_check)

        val binding: ActivityHabitCheckBinding =
            DataBindingUtil.setContentView(this@HabitCheckActivity, R.layout.activity_habit_check)
        binding.setVariable(BR.viewModel, habitCheckViewModel)
    }
}
