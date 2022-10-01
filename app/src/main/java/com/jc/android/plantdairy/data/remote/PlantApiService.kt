package com.jc.android.plantdairy.API

import com.jc.android.plantdairy.model.Plant
import retrofit2.http.GET

const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos() : List<Plant>
}
