package com.teamnexters.eyelong.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface HabitHistoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertHistory(habitHistoryDao: HabitHistoryDao)

    @Query("SELECT * FROM habit_history ORDER BY user_id")
    fun getHistoryAll(): LiveData<List<HabitHistoryDao>>

    @Query("SELECT * FROM habit_history WHERE user_id = :userId")
    fun getHistoryByUserId(userId: String): LiveData<List<HabitHistoryDao>>
}