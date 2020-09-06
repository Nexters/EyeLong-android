package com.teamnexters.eyelong.db.dao

import androidx.room.*
import com.teamnexters.eyelong.db.entity.HabitHistory

@Dao
interface HabitHistoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertHistory(history: HabitHistory)

    @Query("SELECT * FROM habit_history ORDER BY user_id")
    fun getHistoryAll(): List<HabitHistory>

    @Query("SELECT * FROM habit_history WHERE user_id = :userId")
    fun getHistoryByUserId(userId: String): List<HabitHistory>

    @Query("SELECT * FROM habit_history WHERE create_date BETWEEN :date+' 00:00:00' AND :date+' 23:59:59'")
    fun getHistoryByDate(date: String): List<HabitHistory>

    @Delete
    fun deleteHistory(vararg histories: HabitHistory)
}