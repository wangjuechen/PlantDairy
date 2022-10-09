package com.jc.android.plantdairy.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jc.android.plantdairy.model.Plant
import java.util.concurrent.Flow

@Dao
interface PlantDao {
    @Query("SELECT * from Plants")
    suspend fun getPlants() : List<Plant>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteData: List<Plant>)

    @Query("Select * from Plants WHERE id = :plantId")
    suspend fun getPlant(plantId: String) : Plant
}