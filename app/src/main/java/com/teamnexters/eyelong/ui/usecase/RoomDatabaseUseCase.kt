package com.teamnexters.eyelong.ui.usecase

import android.content.Context
import com.teamnexters.eyelong.db.AppDatabase

class RoomDatabaseUseCase(private val context: Context) {
    fun getAppDatabase() = AppDatabase.getAppDatabase(context)
}
