package com.naufal.mvvm.API.Model


data class LoginRequest(
    val nip: String,
    val fingerid: String,
    val recaptcha: String,
)