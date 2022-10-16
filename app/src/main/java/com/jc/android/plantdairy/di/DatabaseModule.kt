package com.jc.android.plantdairy.di

import android.content.Context
import com.jc.android.plantdairy.data.local.PlantDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun providePlantDatabase(@ApplicationContext context: Context) = PlantDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun providePlantDao(db: PlantDatabase) = db.getPlantDao()

    @Provides
    @Singleton
    fun provideMarsPhotoDao(db: PlantDatabase) = db.getMarsPhotoDao()
}