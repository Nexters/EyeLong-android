package com.teamnexters.eyelong.ui.exercise

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.ui.exercise.adapter.AddEyeExerciseRecyclerViewAdapter
import com.teamnexters.eyelong.ui.exercise.viewmodel.ExerciseViewModel
import kotlinx.android.synthetic.main.activity_add_eye_exercise.*

class AddEyeExerciseActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var addEyeExerciseRecyclerViewAdapter: AddEyeExerciseRecyclerViewAdapter
    private lateinit var exerciseViewModel: ExerciseViewModel

    //var dataList: ArrayList<Exercise> = ArrayList()

    //click
    override fun onClick(v: View?) {
        when (v!!) {
            img_btn_back -> {
                finish()
            }

            cl_exercise_add_btn -> {
                //## 리사이클러뷰의 item 중 체크한 것을 가져와야함
                //adapter

                finish()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_eye_exercise)

        //exerciseViewModel = ViewModelProvider(this).get(ExerciseViewModel::class.java)

        configureRecyclerView()
        init()
    }

    private fun init() {
        cl_exercise_add_btn.setOnClickListener(this)
        img_btn_back.setOnClickListener(this)
    }

    private fun configureRecyclerView() {

        /*dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
            "tip의 설명", ""))
        dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
            "tip의 설명", ""))
        dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
            "tip의 설명", ""))
        dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
            "tip의 설명", ""))
        dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
            "tip의 설명", ""))
        dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
            "tip의 설명", ""))*/

/*        exerciseViewModel.allExercise.observe(this, Observer { exercise ->
            // Update the cached copy of the words in the adapter.
            exercise?.let {
                //Log.v("TAGG", it.get(0).name)
                addEyeExerciseRecyclerViewAdapter.setWords(it)
            }
        })*/

        addEyeExerciseRecyclerViewAdapter = AddEyeExerciseRecyclerViewAdapter(this)
        rv_add_exercise_list.adapter = addEyeExerciseRecyclerViewAdapter
        rv_add_exercise_list.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}
