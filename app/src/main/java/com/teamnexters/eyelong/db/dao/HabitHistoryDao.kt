package com.teamnexters.eyelong.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamnexters.eyelong.db.entity.Habit
import com.teamnexters.eyelong.db.entity.HabitHistory
import com.teamnexters.eyelong.db.entity.User

@Dao
interface HabitHistoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertHabitHistory(habitHistory: HabitHistory)

    @Query("SELECT * FROM habit_history ORDER BY id")
    fun getAllHabitHistory() : LiveData<List<HabitHistory>>




}