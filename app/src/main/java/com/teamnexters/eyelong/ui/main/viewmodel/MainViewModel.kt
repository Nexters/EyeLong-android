package com.teamnexters.eyelong.ui.main.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase
) {
    val doListOfWeek = ObservableArrayList<Boolean>()
    val habitCountOfToday = ObservableField<Int>()

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                habitCountOfToday.set(habitHistoryDao().getHistoryAll().size)
            }
        }
    }

    fun onStartExerciseButtonClick() {
        activityUseCase.startEyeExerciseActivity()
    }

    fun onAlarmSettingsClick() {
        activityUseCase.startAlarmSettingsActivity()
    }

    fun onHabitButtonClick() {
        activityUseCase.startHabitActivity()
    }
}
