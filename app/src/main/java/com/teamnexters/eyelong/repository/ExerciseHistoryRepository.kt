package com.teamnexters.eyelong.repository

import androidx.lifecycle.LiveData
import com.teamnexters.eyelong.db.dao.ExerciseHistoryDao
import com.teamnexters.eyelong.db.entity.ExerciseHistory

class ExerciseHistoryRepository(private val exerciseHistoryDao: ExerciseHistoryDao) {

    val allExercise: LiveData<List<ExerciseHistory>> = exerciseHistoryDao.getHistoryAll()

    fun getExerciseInfo(id: Int) {
        exerciseHistoryDao.getHistoryByUserId(id)
    }

    fun getExerciseInfoByCreateTime(create_time: String): List<ExerciseHistory> {
        return exerciseHistoryDao.getHistoryByCreateTime(create_time)
    }

    suspend fun insert(exerciseHistory: ExerciseHistory) {
        exerciseHistoryDao.insertHistory(exerciseHistory)
    }
}