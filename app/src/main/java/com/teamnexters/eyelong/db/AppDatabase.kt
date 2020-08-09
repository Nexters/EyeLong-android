package com.teamnexters.eyelong.db

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.dao.*
import com.teamnexters.eyelong.db.entity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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


    private class AppDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    val exerciseDao = database.exerciseDao()
                    val exerciseHistoryDao = database.exerciseHistoryDao()

//                    exerciseHistoryDao.insertHistory(ExerciseHistory(0, 1, 1212, "20200809"))
//                    exerciseDao.deleteAllExercise()

                    Log.v("TAGG", "여기 들어오지?")

                    exerciseDao.insertExercise(
                        Exercise(
                            0,
                            "8자 그리기 운동",
                            "1",
                            90,
                            "눈 혈행 개선",
                            R.string.exercise_effect_detail.toString(),
                            "1",
                            "1"
                        )
                    )
                    exerciseDao.insertExercise(
                        Exercise(
                            0,
                            "눈 깜빡이기",
                            "1",
                            90,
                            "안구 건조 완화",
                            R.string.exercise_effect_detail.toString(),
                            "1",
                            "1"
                        )
                    )
                    exerciseDao.insertExercise(
                        Exercise(
                            0,
                            "눈 콧등 마사지",
                            "1",
                            49,
                            "눈 혈류량 증가",
                            R.string.exercise_effect_detail.toString(),
                            "1",
                            "1"
                        )
                    )
                    exerciseDao.insertExercise(
                        Exercise(
                            0,
                            "7 눈 지압",
                            "1",
                            70,
                            "안구 건조증, 눈 피로 완화",
                            R.string.exercise_effect_detail.toString(),
                            "1",
                            "1"
                        )
                    )
                    exerciseDao.insertExercise(
                        Exercise(
                            0,
                            "십자 운동",
                            "",
                            70,
                            "시력 회복 도움",
                            R.string.exercise_effect_detail.toString(),
                            "",
                            ""
                        )
                    )
                }
            }
        }
    }


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase? {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "eyelong"
                )
                    .addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance

            }
        }
    }
}