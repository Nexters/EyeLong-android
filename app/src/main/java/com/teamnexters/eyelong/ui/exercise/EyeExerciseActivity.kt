 package com.teamnexters.eyelong.ui.exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.activity_eye_exercise.*
import kotlinx.android.synthetic.main.activity_main.*

 class EyeExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eye_exercise)


        //테스트용
        cl_exercise_start_btn.setOnClickListener{
            var intent = Intent(this, EyeExerciseDetailActivity::class.java)
            startActivity(intent)
        }
    }
}
