package com.example.newsapp.di

import com.example.newsapp.data.local.FavouritesDataBase
import com.example.newsapp.data.remote.ApiService
import com.example.newsapp.data.repoImpl.FavouritesRepoImpl
import com.example.newsapp.data.repoImpl.NewsRepoImpl
import com.example.newsapp.domain.repo.FavouritesRepo
import com.example.newsapp.domain.repo.NewsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideNewsRepo(
        apiService: ApiService
    ): NewsRepo {
        return NewsRepoImpl(apiService)
    }

    @Provides
    fun provideFavouritesRepo(
        favouritesDataBase: FavouritesDataBase
    ): FavouritesRepo {
        return FavouritesRepoImpl(favouritesDataBase)
    }

}