package com.teamnexters.eyelong.ui.exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.util.KCustomToast
import kotlinx.android.synthetic.main.activity_add_eye_exercise.*
import kotlinx.android.synthetic.main.activity_eye_exercise.*
import kotlinx.android.synthetic.main.activity_start_exercise.*
import kotlinx.android.synthetic.main.activity_start_exercise.img_btn_back

class StartExerciseActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_exercise)



        init()
    }

    override fun onClick(v: View?) {
        v!!.let {
            when (it) {
                img_btn_back -> {
                    finish()
                }

                btn_next_blue_img -> {
                    //Toast 띄우기
                    showInfoToastWithTypeface(v)

                    //1초 후에 intent하기
                    val intent = Intent(this, GuideExerciseActivity::class.java)
                    startActivity(intent)

                }
            }
        }
    }

    private fun init() {
        btn_next_blue_img.setOnClickListener(this)
        img_btn_back.setOnClickListener(this)
    }

    fun showInfoToastWithTypeface(view: View) {
        KCustomToast.infoToast(this, getString(R.string.block_blue_light) , KCustomToast.GRAVITY_BOTTOM)
    }
}
