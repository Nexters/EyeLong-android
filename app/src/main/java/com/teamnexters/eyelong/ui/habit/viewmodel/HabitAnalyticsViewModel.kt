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
    var chartItems = ObservableArrayList<Item>()
    var suggestItems = ObservableArrayList<Habit>()
    val nowOfWeek = DateUtil.nowOfWeek()

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                DateUtil.daysOfWeek().map {
                    Item(
                        habitHistoryDao().getHistoryByDate(it).count(),
                        "${it.substring(6 until it.length)}일"
                    )
                }.let {
                    chartItems.addAll(it)
                }

                habitHistoryDao().getHistoryByDate(DateUtil.now())
                    .map { it.habitId }
                    .let { ids ->
                        habitDao().getHabitByRegistered()
                            .filterNot { it.id in ids }
                            .let { suggestItems.addAll(it) }
                    }
            }
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}
