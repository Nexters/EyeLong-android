package com.teamnexters.eyelong.ui.settings.viewmodel

import android.widget.CompoundButton
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.teamnexters.eyelong.ui.binding.count
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import java.time.LocalTime

class AlarmSettingsViewModel(private val activityUseCase: ActivityUseCase) {
    val startTime = ObservableField<LocalTime>()
    val endTime = ObservableField<LocalTime>()
    val repeatTime = ObservableField<LocalTime>()
    val repeatCount = ObservableField<Int>().apply { set(0) }
    val buttonEnable = ObservableField<Boolean>().apply { set(false) }
    val buttonCheck = ObservableField<Boolean>()

    private val checklist = mutableListOf<String>()

    init {
        val callback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                repeatTime.get()?.let {
                    val start = startTime.get()
                    val end = endTime.get()

                    if (start != null && end != null) {
                        repeatCount.set(it.count(start, end).toInt())
                    }
                }

                isNullOrEmptyObservable()
            }
        }

        startTime.addOnPropertyChangedCallback(callback)
        endTime.addOnPropertyChangedCallback(callback)
        repeatTime.addOnPropertyChangedCallback(callback)
    }

    fun onTimePickerStartClick() = onTimePickerClick(field = startTime)
    fun onTimePickerEndClick() = onTimePickerClick(field = endTime)
    fun onTimePickerRepeatClick() = onTimePickerClick(is24HourView = true, field = repeatTime)

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }

    fun onClearButtonClick() {
        startTime.set(null)
        endTime.set(null)
        repeatTime.set(null)
        repeatCount.set(0)
        buttonCheck.set(false)
        buttonCheck.set(null)
    }

    fun onCompoundButtonCheck(compoundButton: CompoundButton, isChecked: Boolean) {
        compoundButton.text.toString().let {
            if (isChecked) {
                checklist.add(it)
            } else {
                checklist.remove(it)
            }
        }

        isNullOrEmptyObservable()
    }

    fun onSaveButtonClick() {}

    private fun onTimePickerClick(
        is24HourView: Boolean = false,
        field: ObservableField<LocalTime>
    ) {
        activityUseCase.showTimePickerDialog(is24HourView) { hourOfDay, minute ->
            field.set(LocalTime.of(hourOfDay, minute))
        }
    }

    private fun isNullOrEmptyObservable() {
        buttonEnable.set(
            startTime.get() != null
                    && endTime.get() != null
                    && repeatTime.get() != null
                    && checklist.size > 0
        )
    }
}
