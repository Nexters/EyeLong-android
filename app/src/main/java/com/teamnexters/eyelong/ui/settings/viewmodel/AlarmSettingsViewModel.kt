package com.teamnexters.eyelong.ui.settings.viewmodel

import androidx.databinding.ObservableField
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import java.time.LocalTime

class AlarmSettingsViewModel(private val activityUseCase: ActivityUseCase) {
    val startTime = ObservableField<LocalTime>()
    val endTime = ObservableField<LocalTime>()
    val repeatTime = ObservableField<LocalTime>()

    fun onTimePickerStartClick() {
        activityUseCase.showTimePickerDialog { hourOfDay, minute ->
            startTime.set(LocalTime.of(hourOfDay, minute))
        }
    }

    fun onTimePickerEndClick() {
        activityUseCase.showTimePickerDialog { hourOfDay, minute ->
            endTime.set(LocalTime.of(hourOfDay, minute))
        }
    }

    fun onTimePickerRepeatClick() {
        activityUseCase.showTimePickerDialog(true) { hourOfDay, minute ->
            repeatTime.set(LocalTime.of(hourOfDay, minute))
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}
