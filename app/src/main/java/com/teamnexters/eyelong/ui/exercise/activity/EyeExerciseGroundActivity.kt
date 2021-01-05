package com.teamnexters.eyelong.ui.exercise.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.ui.exercise.viewmodel.getRegistered
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EyeExerciseGroundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eye_exercise_ground)

        GlobalScope.launch(Dispatchers.IO) {
            val roomDatabaseUseCase = RoomDatabaseUseCase(applicationContext)
            roomDatabaseUseCase.getAppDatabase()?.run {
                exerciseDao().getExerciseAll().run {
                    filter { it.getRegistered() }.let {
                        withContext(Dispatchers.Main) {
                            val bundle = Bundle().apply { putParcelable("data", it[0]) }

                            val navHostFragment =
                                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                            val navController = navHostFragment.navController
                            navController.setGraph(R.navigation.nav_graph, bundle)
                        }
                    }
                }
            }
        }
    }
}