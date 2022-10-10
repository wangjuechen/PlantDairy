package com.jc.android.plantdairy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jc.android.plantdairy.data.local.dao.MarsPhotoDao
import com.jc.android.plantdairy.data.model.MarsPhoto


@Database(
    entities = [MarsPhoto::class],
    version = 3,
    exportSchema = false
)
abstract class PlantDatabase : RoomDatabase() {
    abstract fun getPlantDao() : MarsPhotoDao

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