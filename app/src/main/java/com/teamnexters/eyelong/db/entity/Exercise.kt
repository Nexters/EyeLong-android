package com.teamnexters.eyelong.db.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class Exercise (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int=0,
    @ColumnInfo(name = "name")
    val name: String,

    //##어떤 이미지 path?
    @ColumnInfo(name = "image_path")
    val image_path: String,

    //효과
    @ColumnInfo(name = "effect_simple")
    val effect_simple: String,
    @ColumnInfo(name = "effect_discription")
    val effect_discription: String,

    //소요시간
    @ColumnInfo(name = "time")
    val time: String,

    //##이 부분은 뷰가 나오면 추가할 부분 있는지 확인하기
    @ColumnInfo(name = "tip")
    val tip: String,
    @ColumnInfo(name = "tip_image")
    val tip_image : Int,
    @ColumnInfo(name = "lottie_image_path")
    val lottie_image_path: String

)
