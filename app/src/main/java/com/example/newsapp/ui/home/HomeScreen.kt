package com.example.newsapp.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapp.NewsViewModel
import com.example.newsapp.ui.home.components.ArticleList
import com.example.newsapp.ui.home.components.ErrorText
import com.example.newsapp.ui.home.components.Loading
import com.example.newsapp.utils.Resource

@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {
    var searchQuery by remember { mutableStateOf("") }

    LaunchedEffect(searchQuery) {
        if (searchQuery.isNotEmpty()) {
            newsViewModel.getNews(searchQuery)
        }
    }

    val newsState by newsViewModel.newsFlow.collectAsState(initial = Resource.Idle)

    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(8.dp))
        SearchBar(searchQuery = searchQuery, onSearchQueryChanged = { searchQuery = it })

        Spacer(modifier = Modifier.height(16.dp))

        // Display news based on its state
        when (newsState) {
            is Resource.Idle -> {}

            is Resource.Loading -> {
                Loading()
            }
            is Resource.Error -> {
                ErrorText(message = "Error")
            }
            is Resource.Success<*> -> {
                val articles = (newsState as Resource.Success).data.articles
                if (articles.isNullOrEmpty()) {
                    Text(text = "No articles found")
                } else {
                    ArticleList(articles = articles)
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit
) {

    TextField(
        value = searchQuery,
        onValueChange = { onSearchQueryChanged(it) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        label = { Text(text = "Search") },
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface)
    )
}











