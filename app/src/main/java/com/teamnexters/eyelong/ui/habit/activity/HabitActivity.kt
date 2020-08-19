package com.teamnexters.eyelong.ui.habit.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityHabitBinding
import com.teamnexters.eyelong.ui.habit.viewmodel.HabitViewModel

class HabitActivity : AppCompatActivity() {
    private val habitViewModel = HabitViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit)

        val binding: ActivityHabitBinding =
            DataBindingUtil.setContentView(this@HabitActivity, R.layout.activity_habit)
        binding.setVariable(BR.viewModel, habitViewModel)
    }
}
