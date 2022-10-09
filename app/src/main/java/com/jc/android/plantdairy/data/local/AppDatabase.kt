package com.jc.android.plantdairy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jc.android.plantdairy.data.model.MarsPhoto
import com.jc.android.plantdairy.data.model.Plant

@Database(
    entities = [Plant::class, MarsPhoto::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPlantDao(): PlantDao
    abstract fun getMarsPhotoDao(): MarsPhotoDao

    //Save the instance to memory
    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        
        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(
                    context
                ).also { instance = it }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "PlantDatabase")
                .fallbackToDestructiveMigration()
                .build()
    }
}