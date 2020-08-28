package com.teamnexters.eyelong.ui.exercise.viewmodel

import android.util.Log
import androidx.databinding.ObservableArrayList
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.adapter.EyeExerciseTest
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase
import com.teamnexters.eyelong.ui.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ExerciseViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase
) {

    val items = ObservableArrayList<Exercise>()

    //사실 이 부분은..
    val selectedItems = ObservableArrayList<Exercise>()
    val observer = object : EyeExerciseTest.Observer {
        override fun onItemChecked(exercise: Exercise) {
            selectedItems.add(exercise)
        }

        override fun onItemRemoved(exercise: Exercise) {
            selectedItems.remove(exercise)
        }
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            roomDatabaseUseCase.getAppDatabase()?.run {
                items.addAll(exerciseDao().getExerciseAll())
                //item의 맨 마지막에는 하나의 배열이 들어가긴 해야함.
                //마지막은 + 버튼 보이게 할꺼야
                items.add(Exercise(-1, "", "", 0, "", "", "", ""))

                for(i in 0..items.size-1) {
                    Log.v("TAGG", items.get(i).tipImagePath.toString())
                }
            }
        }
    }

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }

    fun onStartExerciseButtonClick() {
        activityUseCase.startEyePlaygroundActivity()
    }
}