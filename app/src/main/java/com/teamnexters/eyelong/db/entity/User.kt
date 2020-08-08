package com.teamnexters.eyelong.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user",
    indices = [
        Index(name = "idx_user_id", value = ["id"])
    ]
)
data class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "no")
    val no: Int,

    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "user_name")
    val name: String
)
