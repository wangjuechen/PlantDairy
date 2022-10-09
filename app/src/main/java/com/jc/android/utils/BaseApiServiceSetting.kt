package com.jc.android.utils

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


object BaseApiServiceSetting {

    fun getClientSetting(): OkHttpClient {
        val request = Interceptor { chain ->
            val request = chain.request()
            request.headers.toString()
            chain.proceed(request)
        }

        val builder = OkHttpClient.Builder()

        return builder
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(request)
            .build()
    }
}