package com.jc.android.plantdairy.data.Dao

import androidx.room.Dao
import androidx.room.Query
import com.jc.android.plantdairy.model.PlantList

@Dao
interface PlantDao {
    @Query("SELECT * from plants")
    fun getPlant(plants:PlantList) : List<PlantList>
}