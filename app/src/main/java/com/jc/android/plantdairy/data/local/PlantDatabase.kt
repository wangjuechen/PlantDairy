package com.jc.android.plantdairy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jc.android.plantdairy.data.local.dao.PlantDao


@Database(
    entities = [PlantDao::class],
    version = 1,
    exportSchema = false
)
abstract class PlantDatabase : RoomDatabase() {
    abstract fun plantDao() : PlantDao

    companion object {
        @Volatile
        private var INSTANCE: PlantDatabase? = null

        fun getDatabase(context: Context): PlantDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PlantDatabase::class.java,
                    "plants_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}