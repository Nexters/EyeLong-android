package com.teamnexters.eyelong.ui.exercise.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.teamnexters.eyelong.R
import kotlinx.android.synthetic.main.fragment_eye_exercise_finish.view.*

class EyeExerciseFinishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eye_exercise_finish, container, false).apply {
            btn_exercise_finish.setOnClickListener {
                val action = EyeExerciseFinishFragmentDirections
                    .actionEyeExerciseFinishFragmentToMainActivity()
                findNavController().navigate(action)
            }
        }
    }
}
