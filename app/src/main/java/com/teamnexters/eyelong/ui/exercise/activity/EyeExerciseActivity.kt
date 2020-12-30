package com.teamnexters.eyelong.ui.exercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityEyeExerciseBinding
import com.teamnexters.eyelong.ui.exercise.viewmodel.EyeExerciseViewModel
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase

class EyeExerciseActivity : AppCompatActivity() {
    private lateinit var eyeExerciseViewModel: EyeExerciseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        eyeExerciseViewModel = EyeExerciseViewModel(
            ActivityUseCase(this@EyeExerciseActivity),
            RoomDatabaseUseCase(applicationContext)
        )

        val binding: ActivityEyeExerciseBinding =
            DataBindingUtil.setContentView(this@EyeExerciseActivity, R.layout.activity_eye_exercise)
        binding.setVariable(BR.viewModel, eyeExerciseViewModel)
    }
}
