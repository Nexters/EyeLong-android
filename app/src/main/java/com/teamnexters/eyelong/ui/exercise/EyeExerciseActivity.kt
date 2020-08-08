 package com.teamnexters.eyelong.ui.exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.adapter.EyeExerciseRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_eye_exercise.*
import kotlinx.android.synthetic.main.activity_main.*

 class EyeExerciseActivity : AppCompatActivity(), View.OnClickListener {


     lateinit var eyeExerciseRecyclerViewAdapter: EyeExerciseRecyclerViewAdapter
     var dataList: ArrayList<Exercise> = ArrayList()

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
        setContentView(R.layout.activity_eye_exercise)

         init()
         configureRecyclerView()
    }


     private fun init() {
         cl_exercise_start_btn.setOnClickListener(this)
         img_btn_back.setOnClickListener(this)
     }

     private fun configureRecyclerView() {

         dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
         "tip의 설명", ""))
         dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
             "tip의 설명", ""))
         /*dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
             "tip의 설명", ""))
*/
         //마지막은 + 버튼 보이게 할꺼야
         dataList.add(Exercise(-1, "", "", "", "", "", "", ""))

         eyeExerciseRecyclerViewAdapter = EyeExerciseRecyclerViewAdapter(this, dataList)
         rv_exercise_list.adapter = eyeExerciseRecyclerViewAdapter
         rv_exercise_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

     }

 }
