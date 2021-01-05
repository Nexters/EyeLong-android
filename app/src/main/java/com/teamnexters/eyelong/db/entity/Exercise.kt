package com.teamnexters.eyelong.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "exercise")
data class Exercise(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "elapsed_time")
    val elapsedTime: Int,

    @ColumnInfo(name = "effect_title")
    val effectTitle: String?,

    @ColumnInfo(name = "effect_simple_description")
    val effectSimpleDescription: String?,

    @ColumnInfo(name = "effect_description")
    val effectDescription: String?,

    @ColumnInfo(name = "tip")
    val tip: String?,

    @ColumnInfo(name = "guide")
    val guide: String?,

    @ColumnInfo(name = "registered")
    var registered: String?
) : Parcelable
