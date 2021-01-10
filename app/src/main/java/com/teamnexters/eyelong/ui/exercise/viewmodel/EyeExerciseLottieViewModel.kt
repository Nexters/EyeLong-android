package com.teamnexters.eyelong.ui.exercise.viewmodel

import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase

class EyeExerciseLottieViewModel(private val activityUseCase: ActivityUseCase) {
    fun onCancelButtonClick() {
        activityUseCase.startEyeExerciseGroundActivity()
    }

    fun onPauseButtonClick() {}
}
