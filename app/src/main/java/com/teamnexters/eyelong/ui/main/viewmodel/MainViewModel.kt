package com.teamnexters.eyelong.ui.main.viewmodel

import androidx.databinding.ObservableField
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase

class MainViewModel(private val activityUseCase: ActivityUseCase) {
    val exerciseHistoryCount = ObservableField<Int>()
    val habitHistoryCount = ObservableField<Int>()

    init {
        exerciseHistoryCount.set(1)
        habitHistoryCount.set(1)
    }

    fun onStartExerciseButtonClick() {
        activityUseCase.startEyeExerciseActivity()
    }

    fun onHabitButtonClick() {
        activityUseCase.startHabitActivity()
    }
}
