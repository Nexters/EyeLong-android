package com.teamnexters.eyelong.db.dao

import androidx.room.*
import com.teamnexters.eyelong.db.entity.Exercise

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExercise(exercise: Exercise)

    @Update
    fun updateExercise(exercise: Exercise)

    @Query("SELECT * FROM exercise")
    fun getExerciseAll(): List<Exercise>

    @Query("SELECT * FROM exercise WHERE id = :id")
    fun getExerciseInfo(id: Int): Exercise

    @Query("DELETE FROM exercise")
    suspend fun deleteAllExercise()
}