package com.example.newsapp.data.repoImpl

import com.example.newsapp.data.local.FavouritesDataBase
import com.example.newsapp.domain.models.Article
import com.example.newsapp.domain.repo.FavouritesRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouritesRepoImpl @Inject constructor(
    private val favouritesDataBase: FavouritesDataBase
) : FavouritesRepo {

    override fun getFavourites(): Flow<List<Article>> =
        favouritesDataBase.getFavouritesDao().getAllCompetitions()


    override suspend fun insertArticleToFavourites(article: Article) {
        favouritesDataBase.getFavouritesDao().insertArticle(article)
    }

    override suspend fun deleteArticleFromFavourites(article: Article) {
        favouritesDataBase.getFavouritesDao().deleteArticle(article)
    }
}