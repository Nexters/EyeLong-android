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
    fun insertHistory(exerciseHistory: ExerciseHistory)

    @Query("SELECT * FROM exercise_history ORDER BY user_id")
    fun getHistoryAll(): LiveData<List<ExerciseHistory>>

    @Query("SELECT * FROM exercise_history WHERE user_id = :userId")
    fun getHistoryByUserId(userId: Int): LiveData<List<ExerciseHistory>>

    @Query("SELECT * FROM exercise_history WHERE create_date = :create_date")
    fun getHistoryByCreateTime(create_date: String): List<ExerciseHistory>




}