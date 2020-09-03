package com.teamnexters.eyelong.ui.habit.viewmodel

import androidx.databinding.ObservableArrayList
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.chart.Item
import com.teamnexters.eyelong.util.DateUtil
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HabitAnalyticsViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase
) {
    var achieveItems = ObservableArrayList<Habit>()
    var chartItems = ObservableArrayList<Item>()
    val nowOfWeek = DateUtil.nowOfWeek()

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                habitHistoryDao().getHistoryByCreateDate(DateUtil.now()).let { history ->
                    habitDao().getHabitByRegistered()
                        .filterNot { it.id in history.map { it.habitId } }
                        .let { achieveItems.addAll(it) }
                }
            }
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}
