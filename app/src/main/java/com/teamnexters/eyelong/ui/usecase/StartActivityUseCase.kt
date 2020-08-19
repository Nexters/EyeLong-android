package com.teamnexters.eyelong.ui.usecase

import android.content.Context
import android.content.Intent
import com.teamnexters.eyelong.ui.exercise.EyeExerciseActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitActivity

class StartActivityUseCase(private val context: Context) {
    fun startEyeExerciseActivity() {
        context.startActivity(Intent(context, EyeExerciseActivity::class.java))
    }

    fun startHabitActivity() {
        context.startActivity(Intent(context, HabitActivity::class.java))
    }
}
