package com.example.newsapp.data.local


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.domain.models.Article
import com.example.newsapp.utils.Converters


@Database(entities = [Article::class], version = 4, exportSchema = false)
@TypeConverters(Converters::class)
abstract class FavouritesDataBase : RoomDatabase() {

    abstract fun getFavouritesDao(): FavouritesDao

}