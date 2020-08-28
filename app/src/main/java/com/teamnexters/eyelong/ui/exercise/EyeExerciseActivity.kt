package com.teamnexters.eyelong.ui.exercise

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityEyeExerciseBinding
import com.teamnexters.eyelong.databinding.ActivityHabitBinding
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.ui.exercise.adapter.EyeExerciseRecyclerViewAdapter
import com.teamnexters.eyelong.ui.exercise.viewmodel.ExerciseHistoryViewModel
import com.teamnexters.eyelong.ui.exercise.viewmodel.ExerciseViewModel
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase
import com.teamnexters.eyelong.ui.usecase.RoomDatabaseUseCase
import com.teamnexters.eyelong.util.KCustomToast
import kotlinx.android.synthetic.main.activity_eye_exercise.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class EyeExerciseActivity : AppCompatActivity(), View.OnClickListener,
    EyeExerciseRecyclerViewAdapter.OnItemClickListener {

    lateinit var eyeExerciseRecyclerViewAdapter: EyeExerciseRecyclerViewAdapter
    lateinit var exerciseHistoryViewModel: ExerciseHistoryViewModel

    lateinit var exerciseViewModel: ExerciseViewModel

    var dataList: ArrayList<Exercise> = ArrayList()
    var exerciseList: ArrayList<Int> = ArrayList()
    var sum_time: Int = 0

    //click
    override fun onClick(v: View?) {
        when (v!!) {
            /* img_btn_back -> {
                 finish()
             }
             cl_exercise_start_btn -> {
                 //test용 arraylist
                 exerciseList.add(1)
                 exerciseList.add(2)
                 exerciseList.add(3)
                 val intent = Intent(this, StartExerciseActivity::class.java)
                 intent.putIntegerArrayListExtra("exercise_list", exerciseList)
                 startActivity(intent)
             }*/
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_eye_exercise)

        exerciseViewModel = ExerciseViewModel(
            ActivityUseCase(this@EyeExerciseActivity),
            RoomDatabaseUseCase(applicationContext)
        )

        val binding: ActivityEyeExerciseBinding =
            DataBindingUtil.setContentView(this@EyeExerciseActivity, R.layout.activity_eye_exercise)
        binding.setVariable(BR.viewModel, exerciseViewModel)

        //init()
        //configureRecyclerView()
    }

    private fun init() {
        //cl_exercise_start_btn.setOnClickListener(this)
    }

    override fun onItemClicked() {
        //##왜 안나오지??
        showInfoToastWithTypeface(cl_exercise_start_btn)
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
        val date_txt: String =
            SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(currentTime)

        Log.v("TAGG 오늘의 연도월일 : ", date_txt)


        if (dataList.size == 0) {
            Thread {

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
        /*dataList.add(Exercise(-1, "", "", 0, "", "", "", ""))

        eyeExerciseRecyclerViewAdapter = EyeExerciseRecyclerViewAdapter(this, dataList)
        rv_exercise_list.adapter = eyeExerciseRecyclerViewAdapter
        rv_exercise_list.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)*/
    }
/*
     fun rand(from: Int, to: Int, exerciseList: ArrayList<Int>) : ArrayList<Int> {
         val random = Random()

         var set : Set<Int> = setOf<Int>()

         while (set.size == 0) {
             set.plus(random.nextInt(to - from) + from)
         }

         for( i in set) {
             exerciseList.add(i)
         }

         return exerciseList
     }*/


    fun showInfoToastWithTypeface(view: View) {
        KCustomToast.show(this, getString(R.string.exercise_maximum_three))
    }
}
