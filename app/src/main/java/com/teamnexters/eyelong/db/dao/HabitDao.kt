package com.teamnexters.eyelong.db.dao

import androidx.room.*
import com.teamnexters.eyelong.db.entity.Habit

@Dao
interface HabitDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertHabit(habit: Habit)

    @Update
    fun updateHabit(habit: Habit)

    @Query("SELECT * FROM habit")
    fun getHabitAll(): List<Habit>

    @Query("SELECT * FROM habit WHERE registered='Y'")
    fun getHabitByRegistered(): List<Habit>
}