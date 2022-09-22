package com.jc.android.plantdairy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plants")
data class PlantList(
    @PrimaryKey val id: Int,
    val name: String,
    val plantClass: String
)