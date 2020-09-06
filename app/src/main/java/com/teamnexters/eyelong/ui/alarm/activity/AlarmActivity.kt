package com.teamnexters.eyelong.ui.alarm.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.teamnexters.eyelong.BR
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.databinding.ActivityAlarmBinding
import com.teamnexters.eyelong.ui.alarm.viewmodel.AlarmViewModel

class AlarmActivity : AppCompatActivity() {
    private lateinit var alarmViewModel: AlarmViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        alarmViewModel = AlarmViewModel()
        val binding: ActivityAlarmBinding =
            DataBindingUtil.setContentView(this@AlarmActivity, R.layout.activity_alarm)
        binding.setVariable(BR.viewModel, alarmViewModel)
    }
}
