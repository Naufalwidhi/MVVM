package com.naufal.mvvm.API.Model

import com.google.gson.annotations.SerializedName


data class LoginResponse(
    @SerializedName("message")
    var message: String,

    @SerializedName("data")
    val data: LoginItemResponse,
)
data class LoginItemResponse(
    @field:SerializedName("nip")
    val nip: String,
    @field:SerializedName("nik")
    val nik: String,
    @field:SerializedName("nama")
    val nama: String,
    @field:SerializedName("token")
    val token: String
)
