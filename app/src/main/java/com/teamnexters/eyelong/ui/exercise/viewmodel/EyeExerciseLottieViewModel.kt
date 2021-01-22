package com.teamnexters.eyelong.ui.exercise.viewmodel

import android.animation.Animator
import androidx.databinding.ObservableField
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.application.getLottieImagePath
import com.teamnexters.eyelong.wrapper.provider.PreferencesProvider
import com.teamnexters.eyelong.wrapper.provider.ResourceProvider
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.NavigationComponentUseCase

class EyeExerciseLottieViewModel(
    private val activityUseCase: ActivityUseCase,
    private val navigationComponentUseCase: NavigationComponentUseCase,
    private val resourceProvider: ResourceProvider,
    private val preferencesProvider: PreferencesProvider
) {
    private var lottieImagePaths: List<String>? = null
    private var lottieImageIndex = 0

    val lottieImagePath = ObservableField<String>()
    val lottieListener = object : Animator.AnimatorListener {
        override fun onAnimationRepeat(animator: Animator?) {}
        override fun onAnimationEnd(animator: Animator?) {
            lottieImagePaths?.let {
                if (lottieImageIndex < 1) {
                    lottieImagePath.set(it[++lottieImageIndex])
                } else {
                    next()
                }
            }
        }

        override fun onAnimationCancel(animator: Animator?) {}
        override fun onAnimationStart(animator: Animator?) {
            next()
        }
    }

    fun initLottie(exerciseId: Int) {
        lottieImagePaths = getLottieImagePath(exerciseId)
        lottieImagePaths?.let { lottieImagePath.set(it[lottieImageIndex]) }
    }

    fun onCancelButtonClick() {
        home()
    }

    fun onPauseButtonClick() {}

    private fun next() {
        val key = resourceProvider.getString(R.string.shared_pref_key_stage)
        val stage = preferencesProvider.getIntData(key)
        val nextStage = stage + 1

        if (nextStage > 2) {
            preferencesProvider.setIntData(key, 0)
            finish()
        } else {
            preferencesProvider.setIntData(key, nextStage)
            home()
        }
    }

    private fun home() {
        activityUseCase.run {
            finishActivity()
            startEyeExerciseGroundActivity()
        }
    }

    private fun finish() {
        activityUseCase.run {
            finishActivity()
            startEyeExerciseFinishActivity()
        }
    }
}
