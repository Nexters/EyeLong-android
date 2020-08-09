package com.teamnexters.eyelong.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.dao.*
import com.teamnexters.eyelong.db.entity.*

@Database(
    entities = [User::class, Exercise::class, ExerciseHistory::class, Habit::class, HabitHistory::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun exerciseHistoryDao(): ExerciseHistoryDao
    abstract fun habitDao(): HabitDao
    abstract fun habitHistoryDao(): HabitHistoryDao

    companion object {
        @Volatile
        private var appDatabase: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase? {
            assetsToDisk(context)

            appDatabase = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "eyelong"
            ).build()

            return appDatabase
        }

        private fun assetsToDisk(context: Context) {
            context.getDatabasePath(context.getString(R.string.app_db_name))?.let { file ->
                if (file.exists()) {
                    return
                }

                context.assets.open(context.getString(R.string.app_db_name)).use { stream ->
                    file.outputStream().use { stream.copyTo(it) }
                }
            }
        }
    }
}