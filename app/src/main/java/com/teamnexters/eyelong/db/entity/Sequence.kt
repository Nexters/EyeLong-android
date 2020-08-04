package com.teamnexters.eyelong.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sequence")
data class Sequence (
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "seq")
    val seq: String
)