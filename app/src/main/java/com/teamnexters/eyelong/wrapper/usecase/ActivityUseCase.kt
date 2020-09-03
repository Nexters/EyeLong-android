package com.teamnexters.eyelong.wrapper.usecase

import android.app.Activity
import android.content.Intent
import android.view.Gravity
import com.teamnexters.eyelong.ui.exercise.EyeExerciseActivity
import com.teamnexters.eyelong.ui.exercise.EyePlaygroundActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitAnalyticsActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitCheckoutActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitEditActivity
import com.teamnexters.eyelong.ui.main.custom.KCustomToast

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

    fun showWarningToast(message: String) {
        KCustomToast.Builder(activity)
            .apply {
                this.message = message
                this.configure =
                    KCustomToast.Configure(KCustomToast.Configure.Level.WARNING, Gravity.BOTTOM)
            }
            .build()
            .show()
    }

    fun showInfoToast(message: String) {
        KCustomToast.Builder(activity)
            .apply {
                this.message = message
                this.configure =
                    KCustomToast.Configure(KCustomToast.Configure.Level.INFO, Gravity.BOTTOM)
            }
            .build()
            .show()
    }
}
