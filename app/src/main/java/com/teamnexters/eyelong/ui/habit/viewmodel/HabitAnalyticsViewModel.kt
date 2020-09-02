package com.teamnexters.eyelong.ui.habit.viewmodel

import androidx.databinding.ObservableArrayList
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.chart.Item
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase
import com.teamnexters.eyelong.ui.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.random.Random

class HabitAnalyticsViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase
) {
    var achieveItems = ObservableArrayList<Habit>()
    var chartItems = ObservableArrayList<Item>()

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                habitDao().getHabitAll().let { achieveItems.addAll(it) }
            }
        }
        GlobalScope.launch(Dispatchers.IO) {
            for (date in 1..7) {
                val item = Item(Random.nextInt(6), "${date}일")
                chartItems.add(item)
            }
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}