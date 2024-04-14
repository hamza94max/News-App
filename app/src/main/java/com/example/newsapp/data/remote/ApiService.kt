package com.example.newsapp.data.remote

import com.example.newsapp.domain.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("everything")
    suspend fun getNews(
        @Query("q") query: String
    ): NewsResponse


}