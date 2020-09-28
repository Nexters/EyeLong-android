package com.teamnexters.eyelong.network.service

import com.teamnexters.eyelong.network.entity.CreateData
import com.teamnexters.eyelong.network.entity.DeleteData
import io.reactivex.rxjava3.core.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.HTTP
import retrofit2.http.Headers
import retrofit2.http.POST

interface EyeLongService {
    @Headers("Content-Type: application/json")
    @POST("alarm")
    fun createAlarm(@Body body: CreateData): Observable<ResponseBody>

    @Headers("Content-Type: application/json")
    @HTTP(method = "DELETE", path = "alarm", hasBody = true)
    fun deleteAlarm(@Body body: DeleteData): Observable<ResponseBody>
}