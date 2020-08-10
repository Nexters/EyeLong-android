package com.teamnexters.eyelong.ui.exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.activity_lottie.*

class LottieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie)

    }

    private fun lottie() {

        lottie_animation.playAnimation()

    }


}
