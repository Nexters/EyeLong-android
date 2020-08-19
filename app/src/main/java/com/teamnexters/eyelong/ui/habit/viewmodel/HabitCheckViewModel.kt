package com.teamnexters.eyelong.ui.habit.viewmodel

import com.teamnexters.eyelong.ui.usecase.ActivityUseCase

class HabitCheckViewModel(private val activityUseCase: ActivityUseCase) {
    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}