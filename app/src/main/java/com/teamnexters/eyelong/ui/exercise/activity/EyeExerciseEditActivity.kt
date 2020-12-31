package com.teamnexters.eyelong.ui.exercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityEyeExerciseEditBinding
import com.teamnexters.eyelong.ui.exercise.viewmodel.EyeExerciseEditViewModel
import com.teamnexters.eyelong.wrapper.provider.ResourceProviderImpl
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase

class EyeExerciseEditActivity : AppCompatActivity() {
    private lateinit var eyeExerciseEditViewModel: EyeExerciseEditViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        eyeExerciseEditViewModel = EyeExerciseEditViewModel(
            ActivityUseCase(this@EyeExerciseEditActivity),
            RoomDatabaseUseCase(applicationContext),
            ResourceProviderImpl(applicationContext)
        )

        val binding: ActivityEyeExerciseEditBinding =
            DataBindingUtil.setContentView(
                this@EyeExerciseEditActivity,
                R.layout.activity_eye_exercise_edit
            )
        binding.setVariable(BR.viewModel, eyeExerciseEditViewModel)
    }
}