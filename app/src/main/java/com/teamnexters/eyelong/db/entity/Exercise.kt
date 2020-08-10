package com.teamnexters.eyelong.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class Exercise(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "lottie_image_path")
    val lottieImagePath: String?,

    @ColumnInfo(name = "elapsed_time")
    val elapsedTime: Int,

    @ColumnInfo(name = "effect_simple")
    val effectSimple: String?,

    @ColumnInfo(name = "effect_description")
    val effectDescription: String?,

    @ColumnInfo(name = "tip")
    val tip: String?,

    @ColumnInfo(name = "tip_image_path")
    val tipImagePath: String?
)