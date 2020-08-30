package com.teamnexters.eyelong.ui.usecase

import android.app.Activity
import android.content.Intent
import com.teamnexters.eyelong.ui.exercise.EyeExerciseActivity
import com.teamnexters.eyelong.ui.exercise.EyePlaygroundActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitAnalyticsActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitCheckoutActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitEditActivity
import com.teamnexters.eyelong.util.KCustomToast

class ActivityUseCase(private val activity: Activity) {

    fun startEyeExerciseActivity() {
        activity.startActivity(Intent(activity, EyeExerciseActivity::class.java))
    }

    fun startEyePlaygroundActivity() {
        activity.startActivity(Intent(activity, EyePlaygroundActivity::class.java))
    }

    fun startHabitActivity() {
        activity.startActivity(Intent(activity, HabitActivity::class.java))
    }

    fun startHabitCheckActivity() {
        activity.startActivity(Intent(activity, HabitCheckoutActivity::class.java))
    }

    fun startHabitEditActivity() {
        activity.startActivity(Intent(activity, HabitEditActivity::class.java))
    }

    fun startHabitAnalyticsActivity() {
        activity.startActivity(Intent(activity, HabitAnalyticsActivity::class.java))
    }

    fun finishActivity() {
        activity.finish()
    }

    fun showToast(message: String) {
        KCustomToast.show(activity, message)
    }
}
