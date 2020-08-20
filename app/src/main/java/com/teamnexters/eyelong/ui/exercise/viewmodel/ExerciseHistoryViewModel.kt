package com.teamnexters.eyelong.ui.exercise.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.teamnexters.eyelong.db.AppDatabase
import com.teamnexters.eyelong.db.entity.Exercise
import com.teamnexters.eyelong.db.entity.ExerciseHistory
import com.teamnexters.eyelong.repository.ExerciseHistoryRepository
import com.teamnexters.eyelong.repository.ExerciseRepository
import com.teamnexters.eyelong.ui.usecase.ActivityUseCase

class ExerciseHistoryViewModel ( private val activityUseCase: ActivityUseCase) {


    init {
    }

}