package com.teamnexters.eyelong.ui.habit.viewmodel

import com.teamnexters.eyelong.ui.usecase.ActivityUseCase

class HabitAnalyticsViewModel(private val activityUseCase: ActivityUseCase) {

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}