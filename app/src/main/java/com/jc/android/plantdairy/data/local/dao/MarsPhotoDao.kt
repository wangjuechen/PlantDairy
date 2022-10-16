package com.jc.android.plantdairy.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jc.android.plantdairy.data.model.MarsPhoto

@Dao
interface MarsPhotoDao {
    @Query("SELECT * from MarsPhotos")
    suspend fun getMarsPhotos() : List<MarsPhoto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteData: List<MarsPhoto>)

    @Query("Select * from MarsPhotos WHERE id = :plantId")
    suspend fun getMarsPhoto(plantId: String) : MarsPhoto
}