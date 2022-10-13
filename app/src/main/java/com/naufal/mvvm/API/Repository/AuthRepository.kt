package com.naufal.mvvm.API.Repository

import android.util.Log
import com.naufal.mvvm.APIServices
import com.naufal.mvvm.API.Model.LoginRequest
import com.naufal.mvvm.API.Model.LoginResponse

class AuthRepository (private val webApi: APIServices) {

    suspend fun login(loginRequest: LoginRequest): LoginResponse {
        lateinit var response: LoginResponse
        try {
            response = webApi.login(loginRequest)
            Log.d("Login Repository", "Succesfull")
        } catch (e: Exception) {
            Log.d("Login Repository", "Failed")
        }
        return response
    }
}