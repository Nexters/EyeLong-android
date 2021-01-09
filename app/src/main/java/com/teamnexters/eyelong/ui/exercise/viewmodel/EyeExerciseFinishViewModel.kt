package com.teamnexters.eyelong.ui.exercise.viewmodel

import com.teamnexters.eyelong.db.entity.ExerciseHistory
import com.teamnexters.eyelong.util.DateUtil
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.NavigationComponentUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EyeExerciseFinishViewModel(
    private val activityUseCase: ActivityUseCase,
    private val roomDatabaseUseCase: RoomDatabaseUseCase
) {
    fun onExerciseFinishButtonClick() {
        roomDatabaseUseCase.getAppDatabase()?.run {
            GlobalScope.launch(Dispatchers.IO) {
                exerciseDao().getExerciseAll().run {
                    filter { it.getRegistered() }.forEach {
                        ExerciseHistory(
                            exerciseId = it.id,
                            createDate = DateUtil.now()
                        ).let {
                            exerciseHistoryDao().insertHistory(it)
                        }

                        withContext(Dispatchers.Main) {
                            activityUseCase.run {
                                finishActivity()
                                startMainActivity()
                            }
                        }
                    }
                }
            }
        }
    }
}