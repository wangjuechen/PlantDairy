package com.jc.android.plantdairy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "MarsPhotos")
@JsonClass(generateAdapter = true)
data class MarsPhoto(
    @PrimaryKey val id: String,
    @Json(name = "img_src") val imgSrcUrl: String
)
