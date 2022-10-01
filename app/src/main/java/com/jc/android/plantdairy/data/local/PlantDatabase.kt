package com.jc.android.plantdairy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jc.android.plantdairy.data.local.dao.PlantDao
import com.jc.android.plantdairy.model.Plant


@Database(
    entities = [Plant::class],
    version = 1,
    exportSchema = false
)
abstract class PlantDatabase : RoomDatabase() {
    abstract fun getPlantDao() : PlantDao

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