package com.teamnexters.eyelong.ui.exercise

import android.animation.Animator
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.activity_lottie.*

class LottieActivity : AppCompatActivity() , View.OnClickListener {

    var lottieNum = 0
    var progressNum = 0
    var lottieAssetNameArrayList : ArrayList<String> = ArrayList()
    val handler: Handler = Handler()


    //click
    override fun onClick(v: View?) {
        when (v!!) {
            img_delete_btn_lottie -> {
                //main화면으로가기 --> StartActivtyForResult
                //이전뷰는 모두 지우기...
                // 이 부분 어떻게 구현되는지 확인하기
                finish()
            }
            img_pause_lottie -> {
                lottie_animation.pauseAnimation()
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
        img_pause_lottie.setOnClickListener(this)
    }

    private fun lottie() {

        lottieNum = 6
        var cnt = 1;

        progressNum = 100/lottieNum + 1

        lottieAssetNameArrayList.add("exercise_make_eight_180_1.json")
        lottieAssetNameArrayList.add("exercise_make_eight_180_2.json")
        lottieAssetNameArrayList.add("exercise_make_eight_180_3.json")
        lottieAssetNameArrayList.add("exercise_make_eight_180_4.json")
        lottieAssetNameArrayList.add("exercise_make_eight_180_5.json")
        lottieAssetNameArrayList.add("exercise_make_eight_180_6.json")

        lottie_animation.setAnimation(lottieAssetNameArrayList.get(0))
        lottie_animation.loop(true)
        lottie_animation.playAnimation()

        lottie_animation.addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {

                handler.postDelayed(Runnable { // do something after 1.5s

                    if(cnt == lottieNum)
                        handler.removeMessages(0)

                    else {
                        lottie_animation.setAnimation(lottieAssetNameArrayList.get(cnt))
                        lottie_animation.playAnimation()
                        cnt++;
                        img_character.visibility = View.INVISIBLE
                        //progress bar
                    }
                }, 10)
            }

            override fun onAnimationEnd(animation: Animator?) {

                Toast.makeText(this@LottieActivity, "첫번째 운동 끝", Toast.LENGTH_SHORT ).show()

                //Intent해야함.


                /*handler.postDelayed({ // do something after 1.5s
                    lottie_animation.playAnimation()
                }, 1000)*/
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {

            }
        })
    }

    private fun progressBar() {


    }


}
