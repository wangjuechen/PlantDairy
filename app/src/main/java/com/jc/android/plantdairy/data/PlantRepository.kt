package com.jc.android.plantdairy.data

import com.jc.android.plantdairy.data.local.MarsPhotoDao
import com.jc.android.plantdairy.data.model.MarsPhoto
import com.jc.android.plantdairy.data.remote.MarsApiService
import javax.inject.Inject


class PlantRepository @Inject constructor(
    private val marsPhotoDao: MarsPhotoDao,
    private val marsApiService: MarsApiService
) {
    suspend fun getPlants(): List<MarsPhoto> {
        //do query to local database
        //if we have data in local cache, return it, otherwise, fetch from remote
        val localData = marsPhotoDao.getPhotos()
        if (localData.isNotEmpty()) {
            return localData
        }

        //call remote service
        //save data to local database (optional: if it is different from local)
        val remoteData = marsApiService.getPhotos()
        marsPhotoDao.insertAll(remoteData)

        return remoteData
    }
}

