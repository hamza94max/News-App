package com.example.newsapp.domain.models

data class NewsResponse(
    val articles: List<Article>? = mutableListOf(),
    val status: String? = "",
    val totalResults: Int? = 0
)

data class Article(
    val author: String? = "",
    val content: String? = "",
    val description: String? = "",
    val publishedAt: String? = "",
    val source: Source? = Source(),
    val title: String? = "",
    val url: String? = "",
    val urlToImage: String? = ""
)

data class Source(
    val id: String? = "",
    val name: String? = ""
)