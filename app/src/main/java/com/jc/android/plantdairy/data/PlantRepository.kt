package com.jc.android.plantdairy.data

import com.jc.android.plantdairy.API.MarsApiService
import com.jc.android.plantdairy.data.local.dao.PlantDao
import com.jc.android.plantdairy.model.Plant
import javax.inject.Inject

class PlantRepository
@Inject constructor(
    private val plantDao: PlantDao,
    private val marsApiService : MarsApiService) {

    suspend fun getPlants() : List<Plant> {
        val localData = plantDao.getPlants()
        if (localData.isNotEmpty()){
            return localData
        }

        val remoteData = marsApiService.getPhotos()
        plantDao.insertAll(remoteData)

        return remoteData
    }

    suspend fun getPlant(id : String) : Plant {
        return plantDao.getPlant(id)
    }
}