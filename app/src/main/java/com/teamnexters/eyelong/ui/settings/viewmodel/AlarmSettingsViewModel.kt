package com.teamnexters.eyelong.ui.settings.viewmodel

import android.util.Log
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase

class AlarmSettingsViewModel(private val activityUseCase: ActivityUseCase) {
    fun onTimePickerStartClick() {
        activityUseCase.showTimePickerDialog {
            Log.i(
                AlarmSettingsViewModel::class.qualifiedName,
                it
            )
        }
    }

    fun onTimePickerEndClick() {
        activityUseCase.showTimePickerDialog {
            Log.i(
                AlarmSettingsViewModel::class.qualifiedName,
                it
            )
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}