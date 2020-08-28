package com.teamnexters.eyelong.ui.habit.viewmodel

import androidx.databinding.ObservableArrayList
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.ui.habit.adapter.HabitRecyclerViewAdapter
import com.teamnexters.eyelong.ui.provider.ResourceProvider
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase
import com.teamnexters.eyelong.ui.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun Habit.getRegistered() = registered == "Y"
fun Habit.setRegistered(value: Boolean) {
    registered = if (value) "Y" else "N"
}

class HabitEditViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase,
    private val resourceProvider: ResourceProvider
) {
    val registeredItems = ObservableArrayList<Habit>()
    val unregisteredItems = ObservableArrayList<Habit>()
    val observer = object : HabitRecyclerViewAdapter.Observer {
        override fun onItemAdded(habit: Habit) {
            if (registeredItems.size < 5) {
                unregisteredItems.remove(habit)
                registeredItems.add(habit.apply { setRegistered(true) })
            } else {
                resourceProvider.getString(R.string.habit_edit_limit).let {
                    activityUseCase.showToast(it.toString())
                }
            }
        }

        override fun onItemDeleted(habit: Habit) {
            registeredItems.remove(habit)
            unregisteredItems.add(habit.apply { setRegistered(false) })
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
