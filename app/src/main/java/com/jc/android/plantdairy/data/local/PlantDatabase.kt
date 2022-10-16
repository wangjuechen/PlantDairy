package com.jc.android.plantdairy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jc.android.plantdairy.data.local.dao.MarsPhotoDao
import com.jc.android.plantdairy.data.local.dao.PlantDao
import com.jc.android.plantdairy.data.model.MarsPhoto
import com.jc.android.plantdairy.data.model.Plant
import com.jc.android.plantdairy.utils.StringListConverter


@Database(
    entities = [MarsPhoto::class, Plant::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(StringListConverter::class)
abstract class PlantDatabase : RoomDatabase() {
    abstract fun getMarsPhotoDao(): MarsPhotoDao

    abstract fun getPlantDao(): PlantDao

    companion object {
        fun getDatabase(context: Context): PlantDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                PlantDatabase::class.java,
                "plants_database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}