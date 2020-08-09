package com.teamnexters.eyelong.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.util.KCustomToast
import kotlinx.android.synthetic.main.activity_start_exercise.*

class StartExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_exercise)

        btn_next_blue_img.setOnClickListener {
            //Toast 띄우기
            showInfoToastWithTypeface(it)

            //1초 후에 intent하기

        }
    }

    fun showInfoToastWithTypeface(view: View) {
        KCustomToast.infoToast(this, getString(R.string.block_blue_light) , KCustomToast.GRAVITY_BOTTOM)
    }
}
