package com.teamnexters.eyelong.db

import android.content.Context
import android.util.Log
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
        private var appDatabase: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase? {
            assetToDisk(context)

            appDatabase = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                context.getString(R.string.app_db_name)
            ).build()

            return appDatabase
        }

        private fun assetToDisk(context: Context) {
            val fileName = context.getString(R.string.app_db_name)

            context.getDatabasePath(fileName).let { file ->
                if (file.exists()) {
                    return
                }

                Log.i("RoomDatabase", "copy to database path..")

                context.assets.open(fileName).use { stream ->
                    file.outputStream().use { stream.copyTo(it) }
                }
            }
        }
    }
}
