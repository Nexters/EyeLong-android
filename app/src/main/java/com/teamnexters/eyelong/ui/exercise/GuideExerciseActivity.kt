package com.teamnexters.eyelong.ui.exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.activity_guide_exercise.*
import java.util.*
import kotlin.concurrent.timer

class GuideExerciseActivity : AppCompatActivity() {
    private lateinit var timer : Timer
    var time = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide_exercise)

        timerLogic()

    }



    private fun timerLogic() {
        //1초 지나면 --> 3
        //2초 지나면 --> 2
        //3초 지나면 --> 1 과 자 그럼 시작합니다 ! 뷰 띄워주기

        //그리고 운동의 종류는 총 3가지가 있을 것
        // 3가지의 운동마다 image, text, color 모두 다름
        // 이거 check 해서 해줘야함...

        //1초에 한번씩
        timer = timer(period = 1000){
            time--

            runOnUiThread {
                tv_timer.text = "$time"
            }
            if(time == 1) {
                cl_lets_start_toast.visibility = View.VISIBLE
            }
            else if(time == 0) {
                //intent!!! --> StartExercise는 아님 응 아님
                val intent = Intent(this@GuideExerciseActivity, LottieActivity::class.java)
                startActivity(intent)
                //멈추게 하는 방법 없나?
                timer.cancel()
            }
        }

    }
}
