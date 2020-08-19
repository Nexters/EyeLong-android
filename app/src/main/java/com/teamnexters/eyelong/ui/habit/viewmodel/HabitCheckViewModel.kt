package com.teamnexters.eyelong.ui.habit.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableArrayList
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.db.entity.HabitHistory
import com.teamnexters.eyelong.ui.habit.adapter.HabitRecyclerViewAdapter
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase
import com.teamnexters.eyelong.ui.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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

        override fun onItemDeleted(habit: Habit) {
            selectedItems.remove(habit)
        }
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                items.addAll(habitDao().getHabitByRegistered())
            }
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }

    fun onEditHabitClick() {
        activityUseCase.startHabitEditActivity()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onCheckoutButtonClick() {
        if (selectedItems.size > 0) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                GlobalScope.launch(Dispatchers.IO) {
                    selectedItems
                        .map {
                            HabitHistory(
                                userId = userDao().getUserByUserName("master")[0].id,
                                habitId = it.id,
                                createDate = LocalDateTime.now()
                                    .format(DateTimeFormatter.ofPattern("yyyyMMdd hh:mm:ss"))
                            )
                        }
                        .forEach {
                            habitHistoryDao().insertHistory(it)
                        }
                }
            }
        }
    }
}
