package com.teamnexters.eyelong.network.entity

data class CreateData(
    val deviceId: String,
    val title: String,
    val content: String,
    val clickAction: String,
    val iconPath: String,
    val from: String,
    val to: String,
    val unit: String,
    val dayList: List<Int>
)
