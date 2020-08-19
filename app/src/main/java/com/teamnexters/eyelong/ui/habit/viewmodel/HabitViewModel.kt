package com.teamnexters.eyelong.ui.habit.viewmodel

import android.util.Log
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase

class HabitViewModel(private val activityUseCase: ActivityUseCase) {
    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }

    fun onCheckHabitButtonClick() {
        activityUseCase.startHabitCheckActivity()
    }

    fun onAnalyticHabitButtonClick() {
        Log.i(HabitViewModel::class.qualifiedName, "onAnalyticHabitButtonClick")
    }
}
