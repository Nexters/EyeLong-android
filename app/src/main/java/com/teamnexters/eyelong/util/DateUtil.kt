package com.teamnexters.eyelong.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    fun now(): String = Date(System.currentTimeMillis()).let {
        SimpleDateFormat("yyyyMMdd HH:mm:ss").format(it)
    }

    fun nowOfWeek(): String = Calendar.getInstance().run {
        StringBuilder()
            .append("${get(Calendar.YEAR)}년 ")
            .append("${get(Calendar.MONTH) + 1}월 ")
            .append(
                when (get(Calendar.WEEK_OF_MONTH)) {
                    1 -> "첫째주"
                    2 -> "둘째주"
                    3 -> "셋째주"
                    4 -> "넷째주"
                    5 -> "다섯째주"
                    else -> ""
                }
            ).toString()
    }

    fun daysOfWeek() = GregorianCalendar.getInstance()
        .apply { time = Date(System.currentTimeMillis()) }
        .let {
            mutableListOf<String>().apply {
                for (i in 1..7) {
                    it[Calendar.DAY_OF_WEEK] = i
                    add(SimpleDateFormat("yyyyMMdd").format(it.time))
                }
            }.toList()
        }
}
