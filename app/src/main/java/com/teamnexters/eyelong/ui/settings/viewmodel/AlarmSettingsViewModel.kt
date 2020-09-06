package com.teamnexters.eyelong.ui.settings.viewmodel

import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase

class AlarmSettingsViewModel(private val activityUseCase: ActivityUseCase) {
    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}