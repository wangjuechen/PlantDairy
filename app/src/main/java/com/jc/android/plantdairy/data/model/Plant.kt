package com.jc.android.plantdairy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "Plants")
@JsonClass(generateAdapter = true)
data class Plant(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val plantType: String,
    val plantImages: List<String>,
    val waterFrequency: Long,
    val lastWaterTime: Long
)
