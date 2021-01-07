package com.teamnexters.eyelong.ui.exercise.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.FragmentEyeExerciseCountdownBinding

class EyeExerciseCountdownFragment : Fragment() {
    private lateinit var binding: FragmentEyeExerciseCountdownBinding
    private val args: EyeExerciseCountdownFragmentArgs by navArgs()
    private val countDownTimer = object : CountDownTimer(3000, 1000) {
        override fun onTick(p0: Long) {
            binding.apply { tvExerciseCountdown.text = "${(p0 / 1000) + 1}" }
        }

        override fun onFinish() {
            binding.apply { toastExerciseStart.visibility = View.VISIBLE }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_eye_exercise_countdown,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            setVariable(BR.step, 1)
            setVariable(BR.exercise, args.dataArg)

            btnBack.setOnClickListener {
                countDownTimer.cancel()
                activity?.finish()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        countDownTimer.start()
    }
}
