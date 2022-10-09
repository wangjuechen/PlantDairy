package com.jc.android.plantdairy.di.module

import android.content.Context
import com.jc.android.plantdairy.data.local.AppDatabase
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
    fun providePlantDatabase(@ApplicationContext context: Context) = AppDatabase.getDatabase(context)

    @Provides
    @Singleton
    fun providePlantDao(db: AppDatabase) = db.getPlantDao()

    @Provides
    @Singleton
    fun provideMarsPhoto(db: AppDatabase) = db.getMarsPhotoDao()

}