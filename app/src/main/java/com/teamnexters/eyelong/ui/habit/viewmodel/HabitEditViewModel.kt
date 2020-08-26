package com.teamnexters.eyelong.ui.habit.viewmodel

import androidx.databinding.ObservableArrayList
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.adapter.HabitListAdapter
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase
import com.teamnexters.eyelong.ui.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun Habit.getRegistered() = registered == "Y"
fun Habit.setRegistered(value: Boolean) = if (value) registered == "Y" else registered == "N"

class HabitEditViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase
) {
    val registeredItems = ObservableArrayList<Habit>()
    val unregisteredItems = ObservableArrayList<Habit>()
    val observer = object : HabitListAdapter.Observer {
        override fun onItemAdded(habit: Habit) {
            TODO("Not yet implemented")
        }

        override fun onItemDeleted(habit: Habit) {
            TODO("Not yet implemented")
        }
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                habitDao().getHabitAll().groupBy { it.getRegistered() }.run {
                    get(true)?.let { registeredItems.addAll(it) }
                    get(false)?.let { unregisteredItems.addAll(it) }
                }
            }
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}
