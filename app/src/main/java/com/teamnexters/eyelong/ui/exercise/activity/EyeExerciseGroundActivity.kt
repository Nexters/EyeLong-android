package com.teamnexters.eyelong.ui.exercise.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.ui.exercise.viewmodel.getRegistered
import com.teamnexters.eyelong.wrapper.provider.PreferencesProvider
import com.teamnexters.eyelong.wrapper.provider.PreferencesProviderImpl
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EyeExerciseGroundActivity : AppCompatActivity() {
    private lateinit var roomDatabaseUseCase: RoomDatabaseUseCase
    private lateinit var preferences: PreferencesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eye_exercise_ground)
        Log.i(this::class.qualifiedName, "::onCreate")

        roomDatabaseUseCase = RoomDatabaseUseCase(applicationContext)
        preferences = PreferencesProviderImpl(applicationContext)

        savedInstanceState?.let {} ?: run {
            GlobalScope.launch(Dispatchers.IO) {
                roomDatabaseUseCase.getAppDatabase()?.run {
                    exerciseDao().getExerciseAll().run {
                        filter { it.getRegistered() }.let {
                            withContext(Dispatchers.Main) {
                                val stage =
                                    preferences.getIntData(getString(R.string.shared_pref_key_stage))
                                val bundle = Bundle().apply { putParcelable("data", it[stage]) }

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
}
