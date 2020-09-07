package com.teamnexters.eyelong.wrapper.usecase

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.view.Gravity
import androidx.appcompat.app.AlertDialog
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.ui.exercise.EyeExerciseActivity
import com.teamnexters.eyelong.ui.exercise.EyePlaygroundActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitAnalyticsActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitCheckoutActivity
import com.teamnexters.eyelong.ui.habit.activity.HabitEditActivity
import com.teamnexters.eyelong.ui.main.custom.KCustomToast
import com.teamnexters.eyelong.ui.settings.activity.AlarmSettingsActivity
import kotlinx.android.synthetic.main.layout_dialog_time_picker.view.*

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

    fun startAlarmSettingsActivity() {
        activity.startActivity(Intent(activity, AlarmSettingsActivity::class.java))
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

    fun showTimePickerDialog(onTimeChanged: (String) -> Unit) {
        var dialog: DialogInterface? = null
        dialog = activity.layoutInflater.inflate(R.layout.layout_dialog_time_picker, null)
            .apply {
                time_picker.setOnTimeChangedListener { _, hourOfDay, minute ->
                    onTimeChanged("$hourOfDay:$minute")
                }

                btn_picker.setOnClickListener { dialog?.dismiss() }
            }
            .let { AlertDialog.Builder(activity).apply { setView(it) } }
            .show()
    }
}
