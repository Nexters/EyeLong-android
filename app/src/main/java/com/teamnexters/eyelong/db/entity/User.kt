package com.teamnexters.eyelong.db.entity

import androidx.room.*

@Entity(tableName = "user", indices = arrayOf(Index(name = "idx_user_id", value = ["id"])))
data class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int=0,
    @ColumnInfo(name = "name")
    val name: String
)
