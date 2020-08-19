package com.teamnexters.eyelong.ui.habit.viewmodel

import androidx.databinding.ObservableArrayList
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase

class HabitCheckViewModel(private val activityUseCase: ActivityUseCase) {
    val items = ObservableArrayList<Habit>()

    init {
        items.add(Habit(description = "습관"))
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}