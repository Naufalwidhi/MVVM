package com.naufal.mvvm.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.naufal.mvvm.API.Model.LoginItemResponse
import com.naufal.mvvm.API.Model.LoginRequest
import com.naufal.mvvm.API.Repository.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel (private val repository: AuthRepository) : ViewModel() {

    private var _loginResponse = MutableLiveData<LoginItemResponse>()
    val loginResponse: LiveData<LoginItemResponse>
        get() = _loginResponse
    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            try {
                val response = repository.login(loginRequest)
                _loginResponse.value = response.data
            } catch (e: Exception) {
                Log.d("Login View Model Error", "$e")
            }
        }
    }

    fun clearVM() {
        _loginResponse.value = null
    }
}
