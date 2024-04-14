package com.example.newsapp.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.newsapp.utils.Converters

data class NewsResponse(
    val articles: List<Article>? = mutableListOf(),
    val status: String? = "",
    val totalResults: Int? = 0
)

@Entity(tableName = "favorites_table")
data class Article(
    val author: String? = "",
    @PrimaryKey
    val content: String,
    val description: String? = "",
    val publishedAt: String? = "",
    @TypeConverters(Converters::class)
    val source: Source? = Source(),
    val title: String? = "",
    val url: String? = "",
    val urlToImage: String? = "",
    var isFavorite: Boolean = false
) : java.io.Serializable

data class Source(
    val id: String? = "",
    val name: String? = ""
) : java.io.Serializable


