package com.teamnexters.eyelong.db.entity

import android.os.Parcel
import android.os.Parcelable
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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeInt(elapsedTime)
        parcel.writeString(effectTitle)
        parcel.writeString(effectSimpleDescription)
        parcel.writeString(effectDescription)
        parcel.writeString(tip)
        parcel.writeString(guide)
        parcel.writeString(registered)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Exercise> {
        override fun createFromParcel(parcel: Parcel): Exercise {
            return Exercise(parcel)
        }

        override fun newArray(size: Int): Array<Exercise?> {
            return arrayOfNulls(size)
        }
    }
}
