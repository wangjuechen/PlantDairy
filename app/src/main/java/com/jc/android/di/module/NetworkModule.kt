package com.jc.android.di.module

import com.jc.android.data.remote.BASE_URL
import com.jc.android.data.remote.MarsApiService
import com.jc.android.utils.BaseApiServiceSetting
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
    fun providesOkHttpClient() = BaseApiServiceSetting.getClientSetting()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun providesMarsApiService(retrofit: Retrofit): MarsApiService = retrofit.create(MarsApiService::class.java)

}