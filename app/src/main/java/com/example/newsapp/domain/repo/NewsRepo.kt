package com.example.newsapp.domain.repo

import com.example.newsapp.domain.models.NewsResponse

interface NewsRepo {

    suspend fun fetchNewsFromRemote(query: String): NewsResponse
}