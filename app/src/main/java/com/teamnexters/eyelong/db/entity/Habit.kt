package com.teamnexters.eyelong.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "habit")
data class Habit(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "image_path")
    val imagePath: String?,

    @ColumnInfo(name = "registered")
    var registered: String
) {
    @Ignore
    var achieved: Boolean = false
}
