package com.teamnexters.eyelong.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.dao.*
import com.teamnexters.eyelong.db.entity.*

@Database(
    entities = arrayOf(
        User::class,
        Exercise::class,
        ExerciseHistory::class,
        Habit::class,
        HabitHistory::class
    ),
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
//        https://woovictory.github.io/2019/01/25/Android-Room-Basic/
//        val VERSION_1: Migration = object : Migration(0, 1) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                // database.execSQL("ALTER TABLE..");
//            }
//        }

        private var sAppDatabase: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase? {
            // Room
            if (sAppDatabase == null) {
                sAppDatabase = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    context.getString(R.string.app_db_name)
                ).build()
            }

            return sAppDatabase
        }
    }



}
