package com.teamnexters.eyelong.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.AppDatabase
import com.teamnexters.eyelong.ui.exercise.EyeExerciseActivity
import com.teamnexters.eyelong.ui.exercise.viewmodel.ExerciseHistoryViewModel
import com.teamnexters.eyelong.ui.exercise.viewmodel.ExerciseViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var exerciseViewModel : ExerciseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cl_eye_exercise_start_btn.setOnClickListener{
            var intent = Intent(this, EyeExerciseActivity::class.java)
            startActivity(intent)
        }
        //val userDao = AppDatabase.getAppDatabase(applicationContext, )!!.userDao()

        AppDatabase.getAppDatabase(applicationContext)
    }
}