package com.teamnexters.eyelong.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.activity_eye_exercise.img_btn_back
import kotlinx.android.synthetic.main.activity_eye_exercise_detail.*

class EyeExerciseDetailActivity : AppCompatActivity(), View.OnClickListener {
    //click
    override fun onClick(v: View?) {
        v?.let {
            when (it) {
                img_btn_back -> {
                    finish()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eye_exercise_detail)

        init()
        setting()
    }

    private fun setting() {
        var time = intent.getIntExtra("time", -1)

        val name = intent.getStringExtra("name")
        val effect_simple = intent.getStringExtra("effect_simple")
        val effect_des = intent.getStringExtra("effect_des")
        val image = intent.getStringExtra("image")

        //null 처리해야함

        tv_start_eye_exercise.text = (time / 60).toString() + "분 " + (time % 60).toString() + "초"

        tv_exercise_title.text = name
        tv_exercise_effect.text = effect_simple

        tv_exercise_effect_detail.text = effect_des
        Glide.with(this).load(image).into(img_exercise)

        //db의 해당 값을 불러와서 뿌려주거나, 아니면 필요한 값을 걍 intent로 넘겨서 넣어버리던가.
    }

    private fun init() {
        img_btn_back.setOnClickListener(this)
    }
}
