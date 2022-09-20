package com.jc.android.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "MarsPhotos")
data class MarsPhoto(
    @PrimaryKey val id: String,
    @Json(name = "img_src") val imgSrcUrl: String
)
