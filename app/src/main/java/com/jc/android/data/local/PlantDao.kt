package com.jc.android.data.local

import androidx.room.Dao
import androidx.room.Query
import com.jc.android.data.model.Plant

@Dao
interface PlantDao {
    @Query("SELECT * FROM Plants")
    suspend fun getPlants(): List<Plant>
}