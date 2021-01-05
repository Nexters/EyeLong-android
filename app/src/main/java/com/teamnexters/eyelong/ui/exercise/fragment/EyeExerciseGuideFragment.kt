package com.teamnexters.eyelong.ui.exercise.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.FragmentEyeExerciseGuideBinding
import com.teamnexters.eyelong.db.entity.Exercise

class EyeExerciseGuideFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentEyeExerciseGuideBinding =
            DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_eye_exercise_guide,
                container,
                false
            )

        arguments?.let {
            it.getParcelable<Exercise>("data")?.let {
                binding.setVariable(BR.exercise, it)
            }
        }

        return binding.root
    }
}
