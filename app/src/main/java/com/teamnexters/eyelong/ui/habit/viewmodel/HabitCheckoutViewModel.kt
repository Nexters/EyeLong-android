package com.teamnexters.eyelong.ui.habit.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableArrayList
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.db.entity.HabitHistory
import com.teamnexters.eyelong.ui.habit.adapter.HabitRecyclerViewAdapter
import com.teamnexters.eyelong.util.DateUtil
import com.teamnexters.eyelong.wrapper.provider.ResourceProvider
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HabitCheckoutViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase,
    private val resourceProvider: ResourceProvider
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
                habitHistoryDao().getHistoryByDate(DateUtil.now())
                    .map { it.habitId }
                    .let { ids ->
                        habitDao().getHabitByRegistered().forEach {
                            if (it.id in ids) {
                                it.achieved = true
                            }

                            items.add(it)
                        }
                    }
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
                    selectedItems.map {
                        HabitHistory(
                            userId = userDao().getUserByUserName("master")[0].id,
                            habitId = it.id,
                            createDate = DateUtil.now()
                        )
                    }.forEach {
                        habitHistoryDao().insertHistory(it)
                    }

                    async(Dispatchers.Main) {
                        activityUseCase.showInfoToast(
                            resourceProvider.getString(R.string.habit_checkout_succeed).toString()
                        )
                    }
                }
            }
        }
    }
}
