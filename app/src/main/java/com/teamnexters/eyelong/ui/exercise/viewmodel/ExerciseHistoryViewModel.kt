package com.teamnexters.eyelong.ui.exercise.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.teamnexters.eyelong.db.AppDatabase
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.db.entity.ExerciseHistory
import com.teamnexters.eyelong.repository.ExerciseHistoryRepository
import com.teamnexters.eyelong.repository.ExerciseRepository

class ExerciseHistoryViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: ExerciseHistoryRepository
    val allExerciseHistory : LiveData<List<ExerciseHistory>>

    init {
        val exerciseHistoryDao = AppDatabase.getAppDatabase(application, viewModelScope)!!.exerciseHistoryDao()
        repository = ExerciseHistoryRepository(exerciseHistoryDao)
        allExerciseHistory = repository.allExercise
    }

    fun getExerciseInfo(id : Int) = repository.getExerciseInfo(id)

    fun getExerciseInfoBy(create_time : String) = repository.getExerciseInfoByCreateTime(create_time)
}