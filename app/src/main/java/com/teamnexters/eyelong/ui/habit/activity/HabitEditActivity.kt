package com.teamnexters.eyelong.ui.habit.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityHabitEditBinding
import com.teamnexters.eyelong.ui.habit.viewmodel.HabitEditViewModel
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase
import com.teamnexters.eyelong.ui.usecase.RoomDatabaseUseCase

class HabitEditActivity : AppCompatActivity() {
    private lateinit var habitEditViewModel: HabitEditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit_edit)

        habitEditViewModel = HabitEditViewModel(
            ActivityUseCase(this@HabitEditActivity),
            RoomDatabaseUseCase(applicationContext)
        )

        val binding: ActivityHabitEditBinding =
            DataBindingUtil.setContentView(this@HabitEditActivity, R.layout.activity_habit_edit)
        binding.setVariable(BR.viewModel, habitEditViewModel)
    }
}
