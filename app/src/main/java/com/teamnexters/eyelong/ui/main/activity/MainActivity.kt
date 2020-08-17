package com.teamnexters.eyelong.ui.main.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityMainBinding
import com.teamnexters.eyelong.db.AppDatabase
import com.teamnexters.eyelong.ui.exercise.EyeExerciseActivity
import com.teamnexters.eyelong.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO Room database init..
        AppDatabase.getAppDatabase(applicationContext)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.setVariable(BR.viewModel, mainViewModel)

        btn_main_start_exercise.setOnClickListener{
            var intent = Intent(this, EyeExerciseActivity::class.java)
            startActivity(intent)
        }
    }
}