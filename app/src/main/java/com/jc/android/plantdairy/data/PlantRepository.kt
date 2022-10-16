package com.jc.android.plantdairy.data

import com.jc.android.plantdairy.data.local.dao.PlantDao
import com.jc.android.plantdairy.data.model.Plant
import javax.inject.Inject

class PlantRepository @Inject constructor(private val plantDao: PlantDao) {

    suspend fun getPlants(): List<Plant> {
        val localData = plantDao.getPlants()
        return localData.ifEmpty {
//            emptyList()
            dummyPlantData
        }
    }

    suspend fun getPlant(id: Int): Plant {
        return plantDao.getPlant(id)
    }
}

val dummyPlantData = listOf(
    Plant(
        1,
        "Monstera",
        plantType = "tropical",
        plantImages = emptyList(),
        lastWaterTime = 0L,
        waterFrequency = 0L
    ),
    Plant(
        2,
        "Monstera",
        plantType = "tropical",
        plantImages = emptyList(),
        lastWaterTime = 0L,
        waterFrequency = 0L
    ),
    Plant(
        3,
        "Monstera",
        plantType = "tropical",
        plantImages = emptyList(),
        lastWaterTime = 0L,
        waterFrequency = 0L
    ),
    Plant(
        4,
        "Monstera",
        plantType = "tropical",
        plantImages = emptyList(),
        lastWaterTime = 0L,
        waterFrequency = 0L
    )
)