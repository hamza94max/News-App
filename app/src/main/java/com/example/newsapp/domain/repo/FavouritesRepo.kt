package com.example.newsapp.domain.repo

import com.example.newsapp.domain.models.Article
import kotlinx.coroutines.flow.Flow

interface FavouritesRepo {

    fun getFavourites(): Flow<List<Article>>

    suspend fun insertArticleToFavourites(article: Article)

    suspend fun deleteArticleFromFavourites(article: Article)
}