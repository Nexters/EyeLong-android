package com.teamnexters.eyelong.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamnexters.eyelong.db.entity.ExerciseHistory

@Dao
interface ExerciseHistoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertExerciseHistory( exerciseHistory : ExerciseHistory )

    @Query("SELECT * FROM exercise_history ORDER BY id")
    fun getAllExerciseHistory() : LiveData<List<ExerciseHistory>>




}