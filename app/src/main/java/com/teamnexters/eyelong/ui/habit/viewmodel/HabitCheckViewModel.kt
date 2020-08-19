package com.teamnexters.eyelong.ui.habit.viewmodel

import androidx.databinding.ObservableArrayList
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.adapter.HabitRecyclerViewAdapter
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase
import com.teamnexters.eyelong.ui.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HabitCheckViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase
) {
    val items = ObservableArrayList<Habit>()
    val selectedItems = ObservableArrayList<Habit>()
    val observer = object : HabitRecyclerViewAdapter.Observer {
        override fun onItemChecked(habit: Habit) {
            selectedItems.add(habit)
        }

        override fun onItemRemoved(habit: Habit) {
            selectedItems.remove(habit)
        }
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                items.addAll(habitDao().getHabitAll())
            }
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }

    fun onCheckoutButtonClick() {}
}
