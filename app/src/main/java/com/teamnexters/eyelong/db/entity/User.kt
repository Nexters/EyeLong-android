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
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "email")
    val email: String?,

    @ColumnInfo(name = "name")
    val name: String?
)