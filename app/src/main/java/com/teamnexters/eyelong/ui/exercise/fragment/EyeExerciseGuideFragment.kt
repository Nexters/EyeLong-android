package com.teamnexters.eyelong.ui.exercise.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.FragmentEyeExerciseGuideBinding
import com.teamnexters.eyelong.db.entity.Exercise

class EyeExerciseGuideFragment : Fragment() {
    private lateinit var binding: FragmentEyeExerciseGuideBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_eye_exercise_guide,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            arguments?.let {
                it.getParcelable<Exercise>("data")?.let { exercise ->
                    setVariable(BR.exercise, exercise)

                    btnNext.setOnClickListener {
                        val action = EyeExerciseGuideFragmentDirections
                            .actionEyeExerciseGuideFragmentToEyeExerciseCountdownFragment(exercise)
                        view.findNavController().navigate(action)
                    }
                    btnBack.setOnClickListener { activity?.finish() }
                }
            }
        }
    }
}
