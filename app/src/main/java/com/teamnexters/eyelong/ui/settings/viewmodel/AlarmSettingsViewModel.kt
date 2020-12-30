package com.teamnexters.eyelong.ui.settings.viewmodel

import android.util.Log
import android.widget.CompoundButton
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.teamnexters.eyelong.R
import com.teamnexters.eyelong.network.entity.CreateData
import com.teamnexters.eyelong.network.entity.DeleteData
import com.teamnexters.eyelong.network.service.EyeLongService
import com.teamnexters.eyelong.ui.settings.binding.count
import com.teamnexters.eyelong.ui.settings.binding.format
import com.teamnexters.eyelong.wrapper.provider.ResourceProvider
import com.teamnexters.eyelong.wrapper.usecase.ActivityUseCase
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalTime

class AlarmSettingsViewModel(
    private val activityUseCase: ActivityUseCase,
    private val resourceProvider: ResourceProvider
) {
    val startTime = ObservableField<LocalTime>()
    val endTime = ObservableField<LocalTime>()
    val repeatTime = ObservableField<LocalTime>()
    val repeatCount = ObservableField<Int>().apply { set(0) }
    val buttonEnable = ObservableField<Boolean>().apply { set(false) }
    val buttonCheck = ObservableField<Boolean>()

    private val checklist = mutableListOf<String>()
    private var firebaseToken: String? = null

    init {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(
                        FirebaseInstanceId::class.qualifiedName,
                        "getInstanceId failed",
                        task.exception
                    )
                    return@OnCompleteListener
                }

                firebaseToken = task.result?.token
            })

        val callback = object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                repeatTime.get()?.let {
                    val start = startTime.get()
                    val end = endTime.get()

                    if (start != null && end != null) {
                        repeatCount.set(it.count(start, end).toInt())
                    }
                }

                isNullOrEmptyObservable()
            }
        }

        startTime.addOnPropertyChangedCallback(callback)
        endTime.addOnPropertyChangedCallback(callback)
        repeatTime.addOnPropertyChangedCallback(callback)
    }

    fun onTimePickerStartClick() = onTimePickerClick(field = startTime)
    fun onTimePickerEndClick() = onTimePickerClick(field = endTime)
    fun onTimePickerRepeatClick() = onTimePickerClick(is24HourView = true, field = repeatTime)

    fun onBackButtonClick() {
        activityUseCase.finishActivity()
    }

    fun onClearButtonClick() {
        firebaseToken?.let {
            val retrofit = Retrofit.Builder()
                .baseUrl(resourceProvider.getString(R.string.server_base_url).toString())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(EyeLongService::class.java)
            service.deleteAlarm(DeleteData(it))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { activityUseCase.showWarningToast("server error") }
                .subscribe { Log.i(Retrofit::class.qualifiedName, it.toString()) }
        }

        startTime.set(null)
        endTime.set(null)
        repeatTime.set(null)
        repeatCount.set(0)
        buttonCheck.set(false)
        buttonCheck.set(null)
    }

    fun onCompoundButtonCheck(compoundButton: CompoundButton, isChecked: Boolean) {
        compoundButton.tag.toString().let {
            if (isChecked) {
                checklist.add(it)
            } else {
                checklist.remove(it)
            }
        }

        isNullOrEmptyObservable()
    }

    fun onSaveButtonClick() {
        firebaseToken?.let {
            val format = "%02d:%02d"
            val data = CreateData(
                deviceId = it,
                title = "",
                content = "",
                clickAction = "",
                iconPath = "",
                from = startTime.get()!!.format(format),
                to = endTime.get()!!.format(format),
                unit = repeatTime.get()!!.format(format),
                dayList = checklist.map { it.toInt() }
            )

            val retrofit = Retrofit.Builder()
                .baseUrl(resourceProvider.getString(R.string.server_base_url).toString())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service = retrofit.create(EyeLongService::class.java)
            service.createAlarm(data)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { activityUseCase.showWarningToast("server error") }
                .subscribe { activityUseCase.finishActivity() }
        }
    }

    private fun onTimePickerClick(
        is24HourView: Boolean = false,
        field: ObservableField<LocalTime>
    ) {
        activityUseCase.showTimePickerDialog(is24HourView) { hourOfDay, minute ->
            field.set(LocalTime.of(hourOfDay, minute))
        }
    }

    private fun isNullOrEmptyObservable() {
        buttonEnable.set(
            startTime.get() != null
                    && endTime.get() != null
                    && repeatTime.get() != null
                    && checklist.size > 0
        )
    }
}
