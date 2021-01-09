package com.teamnexters.eyelong.ui.exercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityEyeExerciseFinishBinding
import com.teamnexters.eyelong.ui.exercise.viewmodel.EyeExerciseFinishViewModel
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase

class EyeExerciseFinishActivity : AppCompatActivity() {
    private lateinit var eyeExerciseFinishViewModel: EyeExerciseFinishViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        eyeExerciseFinishViewModel = EyeExerciseFinishViewModel(
            ActivityUseCase(this@EyeExerciseFinishActivity),
            RoomDatabaseUseCase(applicationContext)
        )

        val binding: ActivityEyeExerciseFinishBinding = DataBindingUtil.setContentView(
            this@EyeExerciseFinishActivity,
            R.layout.activity_eye_exercise_finish
        )
        binding.setVariable(BR.viewModel, eyeExerciseFinishViewModel)
    }
}