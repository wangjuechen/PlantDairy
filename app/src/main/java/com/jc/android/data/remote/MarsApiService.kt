package com.jc.android.data.remote

import com.jc.android.data.model.MarsPhoto
import retrofit2.http.GET

const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

/**
 * A public interface that exposes the [getPhotos] method
 */
interface MarsApiService {
    /**
     * Returns a [List] of [MarsPhoto] and this method can be called from a Coroutine.
     * The @GET annotation indicates that the "photos" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("photos")
    suspend fun getPhotos() : List<MarsPhoto>
}
