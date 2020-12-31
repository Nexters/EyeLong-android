package com.teamnexters.eyelong.ui.exercise.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityEyeExerciseDetailBinding
import com.teamnexters.eyelong.db.entity.Exercise

class EyeExerciseDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityEyeExerciseDetailBinding =
            DataBindingUtil.setContentView(
                this@EyeExerciseDetailActivity,
                R.layout.activity_eye_exercise_detail
            )

        binding.apply {
            val exercise = intent.getParcelableExtra<Exercise>("data")
            setVariable(BR.exercise, exercise)

            btnEyeExerciseDetailBack.setOnClickListener { finish() }
        }
    }
}