package com.teamnexters.eyelong.ui.exercise.fragment

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.FragmentEyeExerciseLottieBinding
import com.teamnexters.eyelong.ui.exercise.viewmodel.EyeExerciseLottieViewModel
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase

class EyeExerciseLottieFragment : Fragment() {
    private lateinit var onBackPressedCallback: OnBackPressedCallback
    private lateinit var viewModel: EyeExerciseLottieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.let { viewModel = EyeExerciseLottieViewModel(ActivityUseCase(it)) }
        activity?.apply { requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentEyeExerciseLottieBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_eye_exercise_lottie,
            container,
            false
        )
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.run { finish() }
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
    }

    override fun onDetach() {
        super.onDetach()

        onBackPressedCallback.remove()

        activity?.apply { requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT }
    }
}
