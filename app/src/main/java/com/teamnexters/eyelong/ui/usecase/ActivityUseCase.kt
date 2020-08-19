package com.teamnexters.eyelong.ui.usecase

import android.app.Activity
import android.content.Intent
import com.teamnexters.eyelong.ui.exercise.EyeExerciseActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitCheckActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitEditActivity

class ActivityUseCase(private val activity: Activity) {
    fun startEyeExerciseActivity() {
        activity.startActivity(Intent(activity.applicationContext, EyeExerciseActivity::class.java))
    }

    fun startHabitActivity() {
        activity.startActivity(Intent(activity.applicationContext, HabitActivity::class.java))
    }

    fun startHabitCheckActivity() {
        activity.startActivity(Intent(activity.applicationContext, HabitCheckActivity::class.java))
    }

    fun startHabitEditActivity() {
        activity.startActivity(Intent(activity.applicationContext, HabitEditActivity::class.java))
    }

    fun finishActivity() {
        activity.finish()
    }
}
