package com.teamnexters.eyelong.wrapper.usecase

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.view.Gravity
import androidx.appcompat.app.AlertDialog
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.dialog.CustomDialog
import com.teamnexters.eyelong.ui.exercise.activity.EyeExerciseActivity
import com.teamnexters.eyelong.ui.exercise.activity.EyeExerciseDetailActivity
import com.teamnexters.eyelong.ui.exercise.activity.EyeExerciseEditActivity
import com.teamnexters.eyelong.ui.exercise.activity.EyeExerciseGroundActivity
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

    fun startEyeExerciseDetailActivity(exercise: Exercise) {
        Intent(activity, EyeExerciseDetailActivity::class.java)
            .apply { putExtra("data", exercise) }
            .let { activity.startActivity(it) }
    }

    fun startEyeExerciseEditActivity() {
        activity.startActivity(Intent(activity, EyeExerciseEditActivity::class.java))
    }

    fun startEyeExerciseGroundActivity() {
        Intent(activity, EyeExerciseGroundActivity::class.java)
            .apply { flags = Intent.FLAG_ACTIVITY_SINGLE_TOP }
            .let { activity.startActivity(it) }
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

    fun showExerciseDeleteDialog(onConfirm: () -> Unit, onCancel: () -> Unit) {
        with(activity) {
            CustomDialog(
                this,
                getString(R.string.exercise_delete),
                getString(R.string.exercise_delete_message),
                getString(R.string.text_delete),
                getString(R.string.text_cancel),
                onConfirm,
                onCancel
            ).show()
        }
    }

    fun showTimePickerDialog(
        is24HourView: Boolean = false,
        onTimeChanged: (hourOfDay: Int, minute: Int) -> Unit
    ) {
        var dialog: DialogInterface? = null
        dialog = activity.layoutInflater.inflate(R.layout.layout_dialog_time_picker, null)
            .apply {
                time_picker.setIs24HourView(is24HourView)
                btn_picker.setOnClickListener {
                    time_picker.run { onTimeChanged(hour, minute) }
                    dialog?.dismiss()
                }
            }
            .let { AlertDialog.Builder(activity).apply { setView(it) }.show() }
    }
}
