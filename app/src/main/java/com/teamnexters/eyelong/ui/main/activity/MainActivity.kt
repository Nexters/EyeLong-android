package com.teamnexters.eyelong.ui.main.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityMainBinding
import com.teamnexters.eyelong.ui.main.viewmodel.MainViewModel
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import com.teamnexters.eyelong.wrapper.usecase.RoomDatabaseUseCase

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = MainViewModel(
            ActivityUseCase(this@MainActivity),
            RoomDatabaseUseCase(applicationContext)
        )

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        binding.setVariable(BR.viewModel, mainViewModel)
    }
}