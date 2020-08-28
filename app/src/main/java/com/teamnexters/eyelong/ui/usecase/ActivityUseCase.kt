package com.teamnexters.eyelong.ui.usecase

import android.app.Activity
import android.content.Intent
import com.teamnexters.eyelong.ui.exercise.EyeExerciseActivity
import com.teamnexters.eyelong.ui.exercise.StartExerciseActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitCheckoutActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitEditActivity
import com.teamnexters.eyelong.util.KCustomToast

class ActivityUseCase(private val activity: Activity) {
    fun startEyeExerciseActivity() {
        activity.startActivity(Intent(activity.applicationContext, EyeExerciseActivity::class.java))
    }

    fun startHabitActivity() {
        activity.startActivity(Intent(activity.applicationContext, HabitActivity::class.java))
    }

    fun startHabitCheckActivity() {
        activity.startActivity(Intent(activity.applicationContext, HabitCheckoutActivity::class.java))
    }

    fun startHabitEditActivity() {
        activity.startActivity(Intent(activity.applicationContext, HabitEditActivity::class.java))
    }

    fun finishActivity() {
        activity.finish()
    }

<<<<<<< HEAD
    //eyeExercise -> start_activity
    fun intentStartEyeExerciseActivity() {
        //
        activity.startActivity(Intent(activity.applicationContext, StartExerciseActivity::class.java))
=======
    fun showToast(message: String) {
        KCustomToast.show(activity, message)
>>>>>>> feature-#5/habit
    }
}
