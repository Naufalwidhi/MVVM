package com.naufal.mvvm

import com.naufal.mvvm.API.Repository.AuthRepository
import com.naufal.mvvm.ViewModel.LoginViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
}
val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .build()
    }

//    Mohon maaf base url tidak bisa ditampilkan dikarenakan permintaan teman saya
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("Base URL ke Database")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(APIServices::class.java)
    }
}

val repositoryModule = module {
    single { AuthRepository(get()) }
}