package com.teamnexters.eyelong.ui.habit.viewmodel

import android.util.Log
import com.teamnexters.eyelong.ui.usecase.StartActivityUseCase

class HabitViewModel(private val startActivityUseCase: StartActivityUseCase) {

    fun onCheckHabitButtonClick() {
        Log.i(HabitViewModel::class.qualifiedName, "onCheckHabitButtonClick")
    }

    fun onAnalyticHabitButtonClick() {
        Log.i(HabitViewModel::class.qualifiedName, "onAnalyticHabitButtonClick")
    }
}
