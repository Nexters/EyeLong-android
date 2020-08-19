package com.teamnexters.eyelong.ui.main.viewmodel

import androidx.databinding.ObservableField
import com.teamnexters.eyelong.ui.usecase.StartActivityUseCase

class MainViewModel(private val startActivityUseCase: StartActivityUseCase) {
    val exerciseHistoryCount = ObservableField<Int>()
    val habitHistoryCount = ObservableField<Int>()

    init {
        exerciseHistoryCount.set(1)
        habitHistoryCount.set(1)
    }

    fun onStartExerciseButtonClick() {
        startActivityUseCase.startEyeExerciseActivity()
    }

    fun onHabitButtonClick() {
        startActivityUseCase.startHabitActivity()
    }
}
