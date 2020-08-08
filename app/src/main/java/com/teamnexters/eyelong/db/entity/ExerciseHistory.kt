package com.teamnexters.eyelong.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_history")
data class ExerciseHistory(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "user_id")
    val userId: String,

    @ColumnInfo(name = "exercise_id")
    val exerciseId: Int,

    // TODO create_date type check
    @ColumnInfo(name = "create_date")
    val createDate: String
)
