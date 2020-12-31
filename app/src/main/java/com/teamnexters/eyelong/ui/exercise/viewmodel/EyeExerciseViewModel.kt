package com.teamnexters.eyelong.ui.exercise.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.adapter.EyeExerciseRecyclerViewAdapter
import com.teamnexters.eyelong.wrapper.provider.ResourceProvider
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun Exercise.getRegistered() = registered == "Y"
fun Exercise.setRegistered(value: Boolean) {
    registered = if (value) "Y" else "N"
}

class EyeExerciseViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase,
    private val resourceProvider: ResourceProvider
) {
    val items = ObservableArrayList<Exercise>()
    val totalElapsedTime = ObservableField<Int>()
    val observer = object : EyeExerciseRecyclerViewAdapter.Observer {
        override fun onItemClick(exercise: Exercise) {
            activityUseCase.startEyeExerciseDetailActivity(exercise)
        }

        override fun onItemAdded(exercise: Exercise) {

        }

        override fun onItemDeleted(exercise: Exercise) {
            activityUseCase.showExerciseDeleteDialog(
                {
                    GlobalScope.launch(Dispatchers.IO) {
                        roomDatabaseUseCase.getAppDatabase()?.run {
                            exerciseDao().updateExercise(exercise.apply { setRegistered(false) })
                        }
                    }

                    items.remove(exercise)
                },
                {}
            )
        }

        override fun onExerciseAddButtonClick() {
            if (items.size > 2) {
                activityUseCase.showWarningToast(resourceProvider.getString(R.string.exercise_add_limit))
            } else {
                activityUseCase.finishActivity()
                activityUseCase.startEyeExerciseEditActivity()
            }
        }
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                exerciseDao().getExerciseAll().run {
                    filter { it.getRegistered() }.let {
                        items.addAll(it)
                        totalElapsedTime.set(it.fold(0) { acc, exercise -> acc + exercise.elapsedTime })
                    }
                }
            }
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }
}
