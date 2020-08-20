package com.teamnexters.eyelong.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamnexters.eyelong.db.entity.Exercise

@Dao
interface ExerciseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExercise(exercise: Exercise)

    @Query("SELECT * FROM exercise")
    fun getExerciseAll(): List<Exercise>

    @Query("SELECT * FROM exercise WHERE id = :id")
    fun getExerciseInfo(id: Int): Exercise

    @Query("DELETE FROM exercise")
    suspend fun deleteAllExercise()
}