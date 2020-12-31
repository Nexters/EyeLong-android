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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(lottieImagePath)
        parcel.writeInt(elapsedTime)
        parcel.writeString(effectSimple)
        parcel.writeString(effectDescription)
        parcel.writeString(tip)
        parcel.writeString(tipImagePath)
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