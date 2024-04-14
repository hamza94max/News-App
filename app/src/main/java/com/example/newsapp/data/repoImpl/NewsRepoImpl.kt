package com.example.newsapp.data.repoImpl

import com.example.newsapp.data.remote.ApiService
import com.example.newsapp.domain.models.NewsResponse
import com.example.newsapp.domain.repo.NewsRepo
import javax.inject.Inject

class NewsRepoImpl @Inject constructor(
    private val apiService: ApiService
) : NewsRepo {


    override suspend fun fetchNewsFromRemote(query: String): NewsResponse =
        apiService.getNews(query)
}