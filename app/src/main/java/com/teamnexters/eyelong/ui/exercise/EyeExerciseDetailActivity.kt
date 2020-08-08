 package com.teamnexters.eyelong.ui.exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.activity_eye_exercise.*

 class EyeExerciseDetailActivity : AppCompatActivity(), View.OnClickListener {

     //click
     override fun onClick(v: View?) {
         when (v!!) {
             img_btn_back -> {
                 finish()
             }
         }
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eye_exercise_detail)

        init()
    }

     private fun init() {
         img_btn_back.setOnClickListener(this)
     }
}
