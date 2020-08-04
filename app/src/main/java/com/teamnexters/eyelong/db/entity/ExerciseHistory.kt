package com.teamnexters.eyelong.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_history")
data class ExerciseHistory (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int=0,
    @ColumnInfo(name = "exercise_id")
    val exercise_id: Int=0,
    @ColumnInfo(name = "user_id")
    val user_id: Int=0,


    //##create_date type
    @ColumnInfo(name = "create_date")
    val create_date: String

)