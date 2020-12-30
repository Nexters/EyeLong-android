package com.teamnexters.eyelong.ui.exercise.activity

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.activity_lottie.*

class LottieActivity : AppCompatActivity(), View.OnClickListener {

    var lottieNum = 0
    var progressNum = 0
    var cnt = 1
    var lottieAssetNameArrayList: ArrayList<String> = ArrayList()
    val handler: Handler = Handler()
    var exercisenum = 0


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

        exercisenum = intent.getIntExtra("exercise_num", -1)


        init()
        lottie()

    }

    private fun init() {
        img_delete_btn_lottie.setOnClickListener(this)
        img_pause_lottie.setOnClickListener(this)
    }

    private fun lottie() {

        lottieAssetNameArrayList.clear()

        when (exercisenum) {

            //사실 1번부터 해야 안헷갈릴듯
            0 -> {
                lottieNum = 6
                progressNum = 100 / lottieNum + 1

                lottieAssetNameArrayList.add("exercise_make_eight_180_1.json")
                lottieAssetNameArrayList.add("exercise_make_eight_180_2.json")
                lottieAssetNameArrayList.add("exercise_make_eight_180_3.json")
                lottieAssetNameArrayList.add("exercise_make_eight_180_4.json")
                lottieAssetNameArrayList.add("exercise_make_eight_180_5.json")
                lottieAssetNameArrayList.add("exercise_make_eight_180_6.json")

            }

            1 -> {
                lottieNum = 9
                progressNum = 100 / lottieNum + 1

                lottieAssetNameArrayList.add("blink_eye_exercise_1_1.json")
                lottieAssetNameArrayList.add("blink_eye_exercise_1_2.json")
                lottieAssetNameArrayList.add("blink_eye_exercise_1_3.json")

                lottieAssetNameArrayList.add("blink_eye_exercise_2_1.json")
                lottieAssetNameArrayList.add("blink_eye_exercise_2_2.json")
                lottieAssetNameArrayList.add("blink_eye_exercise_2_3.json")

                lottieAssetNameArrayList.add("blink_eye_exercise_3_1.json")
                lottieAssetNameArrayList.add("blink_eye_exercise_3_2.json")
                lottieAssetNameArrayList.add("blink_eye_exercise_3_3.json")

                //pb_lottie.progressDrawable(resources.getColor(R.color.colorLemon_500))

            }

            2 -> {

                lottieNum = 3
                progressNum = 100 / lottieNum + 1

                lottieAssetNameArrayList.add("eye_nose_massage_1.json")
                lottieAssetNameArrayList.add("eye_nose_massage_2.json")
                lottieAssetNameArrayList.add("eye_nose_massage_3.json")

            }

            3 -> {

            }
        }


        lottie_animation.setAnimation(lottieAssetNameArrayList.get(0))
        pb_lottie.progress = progressNum
        lottie_animation.loop(true)
        lottie_animation.playAnimation()

        lottie_animation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {

                handler.postDelayed(Runnable { // do something after 1.5s

                    run {
                        if (cnt != lottieNum) {
                            Log.v("TAGG", cnt.toString())
                            Log.v("TAGG_progress", (progressNum * (cnt + 1)).toString())
                            Log.v("TAGG_arrayList", lottieAssetNameArrayList.get(cnt))
                            lottie_animation.setAnimation(lottieAssetNameArrayList.get(cnt))
                            lottie_animation.playAnimation()
                            lottie_animation.speed = 5f
                            cnt++
                            img_character.visibility = View.INVISIBLE
                            //progress bar
                            pb_lottie.progress = progressNum * (cnt + 1)
                        } else {
                            lottie_animation.cancelAnimation()
                            val intent =
                                Intent(this@LottieActivity, EyePlaygroundActivity::class.java)
                            intent.putExtra("exercise_num", exercisenum + 1)
                            startActivity(intent)
                            Toast.makeText(
                                this@LottieActivity,
                                exercisenum.toString() + "번째 운동 끝",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }
                    }
                }, 10)
            }

            override fun onAnimationEnd(animation: Animator?) {


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
}
