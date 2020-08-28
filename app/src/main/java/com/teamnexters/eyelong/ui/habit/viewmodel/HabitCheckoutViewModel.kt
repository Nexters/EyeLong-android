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
import java.text.SimpleDateFormat
import java.util.*

class HabitCheckoutViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase
) {
    val items = ObservableArrayList<Habit>()
    val selectedItems = ObservableArrayList<Habit>()
    val observer = object : HabitRecyclerViewAdapter.Observer {
        override fun onItemAdded(habit: Habit) {
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
                                createDate = Date(System.currentTimeMillis()).let {
                                    SimpleDateFormat("yyyyMMdd hh:mm:ss").format(it)
                                }
                            )
                        }.forEach {
                            habitHistoryDao().insertHistory(it)
                        }
                }
            }
        }
    }
}
