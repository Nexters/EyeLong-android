package com.teamnexters.eyelong.ui.main.usecase

import android.content.Context
import android.content.Intent
import com.teamnexters.eyelong.ui.exercise.EyeExerciseActivity

class StartActivityUseCase(private val context: Context) {
    fun startEyeExerciseActivity() {
        context.startActivity(Intent(context, EyeExerciseActivity::class.java))
    }
}