package com.teamnexters.eyelong.wrapper.usecase

import android.content.Context
import com.teamnexters.eyelong.db.AppDatabase

class RoomDatabaseUseCase(private val context: Context) {
    fun getAppDatabase() = AppDatabase.getAppDatabase(context)
}
