package com.example.starwarapi_retrofit_rxjava.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class RetrofitInstance {
    val retrofit = Retrofit
    get() {
        val loggingInterceptor = HttpLoggingInterceptor()
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    }
}