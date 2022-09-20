package com.jc.android.data.local

import androidx.room.Dao
import androidx.room.Query
import com.jc.android.data.model.MarsPhoto

@Dao
interface MarsPhotoDao {

    @Query("SELECT * FROM MarsPhotos")
    fun getPhotos(): List<MarsPhoto>
}