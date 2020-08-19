package com.teamnexters.eyelong.repository

import androidx.lifecycle.LiveData
import com.teamnexters.eyelong.db.dao.ExerciseDao
import com.teamnexters.eyelong.db.entity.Exercise

class ExerciseRepository(private val exerciseDao: ExerciseDao) {

    val allExercise: LiveData<List<Exercise>> = exerciseDao.getExerciseAll()

    fun getExerciseInfo(id: Int): Exercise {
        return exerciseDao.getExerciseInfo(id)
    }

    suspend fun insert(exercise: Exercise) {
        exerciseDao.insertExercise(exercise)
    }

}