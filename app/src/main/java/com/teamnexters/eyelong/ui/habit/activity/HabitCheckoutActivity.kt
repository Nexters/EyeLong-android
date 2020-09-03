package com.teamnexters.eyelong.ui.habit.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityHabitCheckoutBinding
import com.teamnexters.eyelong.ui.habit.viewmodel.HabitCheckoutViewModel
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase

class HabitCheckoutActivity : AppCompatActivity() {
    private lateinit var habitCheckoutViewModel: HabitCheckoutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_habit_checkout)

        habitCheckoutViewModel = HabitCheckoutViewModel(
            ActivityUseCase(this@HabitCheckoutActivity),
            RoomDatabaseUseCase(applicationContext)
        )

        val binding: ActivityHabitCheckoutBinding =
            DataBindingUtil.setContentView(
                this@HabitCheckoutActivity,
                R.layout.activity_habit_checkout
            )
        binding.setVariable(BR.viewModel, habitCheckoutViewModel)
    }
}
