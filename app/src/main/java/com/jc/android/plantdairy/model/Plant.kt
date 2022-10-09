package com.jc.android.plantdairy.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Plants")
data class Plant(
    @PrimaryKey(autoGenerate = true) val id: String,
    val name: String,
    val plantClass: String,
    val plantImage: String
)