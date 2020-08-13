package com.teamnexters.eyelong.ui.exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.activity_eye_exercise.*
import kotlinx.android.synthetic.main.activity_lottie.*

class LottieActivity : AppCompatActivity() , View.OnClickListener {

    //click
    override fun onClick(v: View?) {
        when (v!!) {
            img_delete_btn_lottie -> {
                //main화면으로가기
                //이전뷰는 모두 지우기...
                // 이 부분 어떻게 구현되는지 확인하기
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie)

        lottie()
        init()
    }
    private fun init() {
        img_delete_btn_lottie.setOnClickListener(this)
    }

    private fun lottie() {

        lottie_animation.playAnimation()

    }


}
