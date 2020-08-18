package com.teamnexters.eyelong.ui.main.viewmodel

import androidx.databinding.ObservableField

class MainViewModel {
    val exerciseHistoryCount = ObservableField<Int>()

    init {
        exerciseHistoryCount.set(5)
    }
}
