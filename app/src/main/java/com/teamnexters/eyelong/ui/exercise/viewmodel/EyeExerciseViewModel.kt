package com.teamnexters.eyelong.ui.exercise.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.adapter.EyeExerciseRecyclerViewAdapter
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class EyeExerciseViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase
) {
    val items = ObservableArrayList<Exercise>()
    val totalElapsedTime = ObservableField<Int>()
    val observer = object : EyeExerciseRecyclerViewAdapter.Observer {
        override fun onItemAdded(exercise: Exercise) {}
        override fun onItemDeleted(exercise: Exercise) {
            items.remove(exercise)
        }

        override fun onExerciseAddButtonClick() {
            TODO("Not yet implemented")
        }
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                exerciseDao().getExerciseAll().run {
                    forEach { items.add(it) }
                    fold(0) { acc, exercise -> acc + exercise.elapsedTime }
                        .let { totalElapsedTime.set(it) }
                }
            }
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}
