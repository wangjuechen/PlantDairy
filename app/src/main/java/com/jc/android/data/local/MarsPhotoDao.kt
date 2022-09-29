package com.jc.android.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jc.android.data.model.MarsPhoto

@Dao
interface MarsPhotoDao {

    @Query("SELECT * FROM MarsPhotos")
    suspend fun getPhotos(): List<MarsPhoto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photos: List<MarsPhoto>)
}