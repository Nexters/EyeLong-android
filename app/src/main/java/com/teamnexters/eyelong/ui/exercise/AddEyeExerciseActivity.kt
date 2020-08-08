package com.teamnexters.eyelong.ui.exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.adapter.AddEyeExerciseRecyclerViewAdapter
import com.teamnexters.eyelong.ui.exercise.adapter.EyeExerciseRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_add_eye_exercise.*

class AddEyeExerciseActivity : AppCompatActivity() {

    lateinit var addEyeExerciseRecyclerViewAdapter: AddEyeExerciseRecyclerViewAdapter
    var dataList: ArrayList<Exercise> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_eye_exercise)

        configureRecyclerView()
    }

    private fun configureRecyclerView() {

        dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
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
            "tip의 설명", ""))


        addEyeExerciseRecyclerViewAdapter = AddEyeExerciseRecyclerViewAdapter(this, dataList)
        rv_add_exercise_list.adapter = addEyeExerciseRecyclerViewAdapter
        rv_add_exercise_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }
}
