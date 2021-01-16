package com.teamnexters.eyelong.ui.exercise.viewmodel

import com.teamnexters.eyelong.wrapper.provider.PreferencesProvider
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase

class EyeExerciseLottieViewModel(
    private val activityUseCase: ActivityUseCase,
    private val preferencesProvider: PreferencesProvider
) {
    fun onCancelButtonClick() {
        activityUseCase.run {
            finishActivity()
            startEyeExerciseGroundActivity()
        }
    }

    fun onPauseButtonClick() {}
}
