package com.teamnexters.eyelong.ui.exercise

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.db.entity.ExerciseHistory
import com.teamnexters.eyelong.ui.exercise.adapter.EyeExerciseRecyclerViewAdapter
import com.teamnexters.eyelong.ui.exercise.viewmodel.ExerciseHistoryViewModel
import kotlinx.android.synthetic.main.activity_eye_exercise.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EyeExerciseActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var eyeExerciseRecyclerViewAdapter: EyeExerciseRecyclerViewAdapter
    lateinit var exerciseHistoryViewModel: ExerciseHistoryViewModel
    var dataList: ArrayList<Exercise> = ArrayList()
    var sum_time: Int = 0

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


        exerciseHistoryViewModel = ViewModelProvider(this).get(ExerciseHistoryViewModel::class.java)

        init()
        configureRecyclerView()


        //로직
        //총 소요시간 -> dataList의 elapsedTime들을

    }


    private fun init() {
        cl_exercise_start_btn.setOnClickListener(this)
        img_btn_back.setOnClickListener(this)
    }

    private fun configureRecyclerView() {

        //리사이클러뷰 로직
        //1. 맨 처음, dataList가 empty인지?
        //2-1. 비어있지 않다면, 그것으로 리사이클러뷰 만들어서 진행
        //2-2. 비어있다면,
        //3. exerciseHistory db 접근
        //3-1. 만약, exerciseHistory가 있다면, create_time과 현재 시간 비교, 있으면 그걸 불러와서 사용, 없다면, 3-2
        //3-2. exerciseHistory가 empty라면, 랜덤하게 숫자 1~N(exercise의 개수)개 중 3개를 뽑는다. --> id 가 1부터인지, 0부터인지 보기
        //그러면, db에 저장되어있는 해당 id 맞춰서 운동이 총 3개가 나올 것이다.
        // 이걸 dataList에 집어 넣고 리사이클러뷰 만들기

        val currentTime: Date = Calendar.getInstance().time
        val date_txt: String = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(currentTime)

        Log.v("TAGG 오늘의 연도월일 : ", date_txt)


        if (dataList.size == 0) {
            Thread {
                var exerciseList: List<ExerciseHistory> = emptyList()
                exerciseList = exerciseHistoryViewModel.getExerciseInfoBy(date_txt)
            }.start()
        }


        dataList.add(
            Exercise(
                0, "운동이름", "", 90, "효과효과", "효과의 상세설명",
                "tip의 설명", ""
            )
        )
        dataList.add(
            Exercise(
                0, "운동이름", "", 90, "효과효과", "효과의 상세설명",
                "tip의 설명", ""
            )
        )
        /*dataList.add(Exercise(0, "운동이름", "", "1분 30초", "효과효과", "효과의 상세설명",
            "tip의 설명", ""))
            */

        //마지막은 + 버튼 보이게 할꺼야
        dataList.add(Exercise(-1, "", "", 0, "", "", "", ""))

        eyeExerciseRecyclerViewAdapter = EyeExerciseRecyclerViewAdapter(this, dataList)
        rv_exercise_list.adapter = eyeExerciseRecyclerViewAdapter
        rv_exercise_list.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
}
