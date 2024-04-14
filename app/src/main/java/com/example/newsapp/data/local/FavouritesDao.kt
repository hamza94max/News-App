package com.example.newsapp.data.local

import androidx.room.*
import com.example.newsapp.domain.models.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(vararg article: Article)

    @Query("SELECT * FROM favorites_table")
    fun getAllCompetitions(): Flow<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}