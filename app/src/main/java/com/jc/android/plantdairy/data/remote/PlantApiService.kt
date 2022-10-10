package com.jc.android.plantdairy.data.remote


import com.jc.android.plantdairy.data.model.MarsPhoto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.http.GET

const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos() : List<MarsPhoto>
}
