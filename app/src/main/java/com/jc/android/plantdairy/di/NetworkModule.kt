package com.jc.android.plantdairy.di

import com.jc.android.plantdairy.API.BASE_URL
import com.jc.android.plantdairy.API.MarsApiService
import com.jc.android.plantdairy.network.InternetConnectSetting
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient() = InternetConnectSetting.getClientSetting()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideMarsApiService(retrofit: Retrofit) : MarsApiService = retrofit.create(MarsApiService::class.java)

}