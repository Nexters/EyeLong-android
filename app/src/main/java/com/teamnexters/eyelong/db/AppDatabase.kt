package com.teamnexters.eyelong.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(), version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {


}