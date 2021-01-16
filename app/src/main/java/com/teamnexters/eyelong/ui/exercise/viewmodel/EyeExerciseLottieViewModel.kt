package com.teamnexters.eyelong.ui.exercise.viewmodel

import com.teamnexters.eyelong.wrapper.provider.DataStorageProvider
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase

class EyeExerciseLottieViewModel(
    private val activityUseCase: ActivityUseCase,
    private val dataStorageProvider: DataStorageProvider
) {
    fun onCancelButtonClick() {
        activityUseCase.run {
            finishActivity()
            startEyeExerciseGroundActivity()
        }
    }

    fun onPauseButtonClick() {}
}
