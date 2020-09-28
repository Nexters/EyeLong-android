package com.teamnexters.eyelong.ui.settings.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivitySettingsAlarmBinding
import com.teamnexters.eyelong.ui.settings.viewmodel.AlarmSettingsViewModel
import com.teamnexters.eyelong.wrapper.provider.ResourceProviderImpl
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase

class AlarmSettingsActivity : AppCompatActivity() {
    private lateinit var settingsViewModel: AlarmSettingsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_alarm)

        settingsViewModel = AlarmSettingsViewModel(
            ActivityUseCase(this@AlarmSettingsActivity),
            ResourceProviderImpl(this@AlarmSettingsActivity)
        )

        val binding: ActivitySettingsAlarmBinding =
            DataBindingUtil.setContentView(
                this@AlarmSettingsActivity,
                R.layout.activity_settings_alarm
            )
        binding.setVariable(BR.viewModel, settingsViewModel)
    }
}
