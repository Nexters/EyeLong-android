package com.teamnexters.eyelong.ui.settings.viewmodel

import android.util.Log
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase

class AlarmSettingsViewModel(private val activityUseCase: ActivityUseCase) {
    fun onTimePickerStartClick() {
        activityUseCase.showTimePickerDialog { Log.i("TimePicker", it) }
    }

    fun onTimePickerEndClick() {
        activityUseCase.showTimePickerDialog { Log.i("TimePicker", it) }
    }

    fun onTimePickerRepeatClick() {
        activityUseCase.showTimePickerDialog(true) { Log.i("TimePicker", it) }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}
