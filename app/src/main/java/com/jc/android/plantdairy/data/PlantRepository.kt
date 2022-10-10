package com.jc.android.plantdairy.data

import com.jc.android.plantdairy.data.local.dao.MarsPhotoDao
import com.jc.android.plantdairy.data.remote.MarsApiService
import com.jc.android.plantdairy.data.model.MarsPhoto
import javax.inject.Inject

class PlantRepository
@Inject constructor(
    private val plantDao: MarsPhotoDao,
    private val marsApiService : MarsApiService
) {

    suspend fun getPlants() : List<MarsPhoto> {
        val localData = plantDao.getPlants()
        if (localData.isNotEmpty()){
            return localData
        }

        val remoteData = marsApiService.getPhotos()
        plantDao.insertAll(remoteData)

        return remoteData
    }

    suspend fun getPlant(id : String) : MarsPhoto {
        return plantDao.getPlant(id)
    }
}