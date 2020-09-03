package com.teamnexters.eyelong.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamnexters.eyelong.db.entity.HabitHistory

@Dao
interface HabitHistoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertHistory(habitHistory: HabitHistory)

    @Query("SELECT * FROM habit_history ORDER BY user_id")
    fun getHistoryAll(): List<HabitHistory>

    @Query("SELECT * FROM habit_history WHERE user_id = :userId")
    fun getHistoryByUserId(userId: String): List<HabitHistory>

    @Query("SELECT * FROM habit_history WHERE create_date BETWEEN :createDate+' 00:00:00' AND :createDate+' 23:59:59'")
    fun getHistoryByCreateDate(createDate: String): List<HabitHistory>
}