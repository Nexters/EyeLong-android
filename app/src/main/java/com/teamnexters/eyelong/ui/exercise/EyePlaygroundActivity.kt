package com.teamnexters.eyelong.ui.exercise

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.ui.exercise.listener.OnThrottleClickListener
import com.teamnexters.eyelong.ui.main.custom.KCustomToast
import kotlinx.android.synthetic.main.activity_start_exercise.*

class EyePlaygroundActivity : AppCompatActivity(), View.OnClickListener {

    var btnCount = 0
    var exerciseList: ArrayList<Int> = ArrayList()
    var exercisenum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_exercise)

        exercisenum = intent.getIntExtra("exercise_num", 0);

        init()
        onClick()
    }

    fun View.onThrottleClick(action: (v: View) -> Unit) {
        val listener = View.OnClickListener { action(it) }
        setOnClickListener(
            OnThrottleClickListener(
                listener
            )
        )
    }

    override fun onClick(v: View?) {
        v!!.let {
            when (it) {
                img_btn_back -> {
                    finish()
                }

//                btn_next_blue_img -> {
//                    //Toast 띄우기
//                    showInfoToastWithTypeface(v)
//                    postDelayIntent()
//                }
            }
        }
    }

    private fun init() {
        //btn_next_blue_img.setOnClickListener(this)
        img_btn_back.setOnClickListener(this)

        //exerciseList = intent.getIntegerArrayListExtra("exerciseList")

        Log.v("TAGG", exerciseList.toString())

    }

    private fun postDelayIntent() {
        Handler().postDelayed({
            //1초 후에 intent하기

            val intent = Intent(this, GuideExerciseActivity::class.java)
            intent.putIntegerArrayListExtra("exercise_list", exerciseList)
            intent.putExtra("exercise_num", exercisenum)
            startActivity(intent)
            finish()
        }, 2000)
    }

    fun showInfoToastWithTypeface(view: View) {
        KCustomToast.show(this, getString(R.string.block_blue_light))
    }

    //중복방지
    private fun onClick() {
        btn_next_blue_img.onThrottleClick {
            showInfoToastWithTypeface(it)
            postDelayIntent()
            Log.d("TAG", "button Clicked : ${++btnCount}")
        }
    }
}
