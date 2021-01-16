package com.teamnexters.eyelong.ui.exercise.viewmodel

import androidx.databinding.ObservableField
import com.teamnexters.eyelong.application.getLottieImagePath
import com.teamnexters.eyelong.wrapper.provider.PreferencesProvider
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase

class EyeExerciseLottieViewModel(
    private val activityUseCase: ActivityUseCase,
    private val preferencesProvider: PreferencesProvider
) {
    val lottieImagePath = ObservableField<String>()

    init {
        getLottieImagePath(3)?.let { lottieImagePath.set(it[0]) }
    }

    fun onCancelButtonClick() {
        activityUseCase.run {
            finishActivity()
            startEyeExerciseGroundActivity()
        }
    }

    fun onPauseButtonClick() {}
}
