package com.example.newsapp.di

import android.app.Application
import androidx.room.Room
import com.example.newsapp.data.local.FavouritesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideFavouritesDatabase(app: Application): FavouritesDataBase =
        Room.databaseBuilder(app, FavouritesDataBase::class.java, "Favorites_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
}