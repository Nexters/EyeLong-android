package com.teamnexters.eyelong.ui.exercise.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.teamnexters.eyelong.db.AppDatabase
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.repository.ExerciseRepository

class ExerciseViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: ExerciseRepository
    val allExercise: LiveData<List<Exercise>>

    init {
        val exerciseDao = AppDatabase.getAppDatabase(application)!!.exerciseDao()
        repository = ExerciseRepository(exerciseDao)
        allExercise = repository.allExercise
    }

    fun getExerciseInfo(id : Int) = repository.getExerciseInfo(id)
}