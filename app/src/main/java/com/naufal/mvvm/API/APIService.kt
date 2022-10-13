package com.naufal.mvvm

import com.naufal.mvvm.API.Model.LoginRequest
import com.naufal.mvvm.API.Model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface APIServices {
    //Authentication
    @POST("/api/signin")
    suspend fun login(
        @Body body: LoginRequest
    ): LoginResponse
}
