package com.teamnexters.eyelong.ui.exercise.viewmodel

import android.view.View
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.adapter.EyeExerciseEditRecyclerViewAdapter
import com.teamnexters.eyelong.wrapper.provider.ResourceProvider
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EyeExerciseEditViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase,
    private val resourceProvider: ResourceProvider
) {
    val items = ObservableArrayList<Exercise>()
    val selectedItems = ObservableArrayList<Exercise>()
    val exerciseAddButtonVisibility = ObservableField<Int>(View.GONE)
    val observer = object : EyeExerciseEditRecyclerViewAdapter.Observer {
        override fun onItemAdded(exercise: Exercise) {
            selectedItems.add(exercise.apply { setRegistered(true) })

            if (selectedItems.size > 0) {
                exerciseAddButtonVisibility.set(View.VISIBLE)
            }
        }

        override fun onItemDeleted(exercise: Exercise) {
            selectedItems.remove(exercise.apply { setRegistered(false) })

            if (selectedItems.size == 0) {
                exerciseAddButtonVisibility.set(View.GONE)
            }
        }
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                exerciseDao().getExerciseAll().let { items.addAll(it) }
            }
        }
    }

    fun onExerciseAddButtonClick() {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                items.forEach { exerciseDao().updateExercise(it) }

                withContext(Dispatchers.Main) {
                    activityUseCase.showInfoToast(resourceProvider.getString(R.string.exercise_add_succeed))
                    onBackButtonClick()
                }
            }
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
        activityUseCase.startEyeExerciseActivity()
    }
}
