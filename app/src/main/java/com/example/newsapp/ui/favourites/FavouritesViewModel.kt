package com.example.newsapp.ui.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.models.Article
import com.example.newsapp.domain.repo.FavouritesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val favouritesRepo: FavouritesRepo
) : ViewModel() {


    init {
        getFavourites()
    }

    private val _favourites = MutableStateFlow<List<Article>>(emptyList())
    val favouritesFlow: Flow<List<Article>> = _favourites

    fun getFavourites() {
        viewModelScope.launch {
            favouritesRepo.getFavourites().collect { favourites ->
                _favourites.value = favourites
            }
        }
    }

    fun insertToFavourites(article: Article) {
        viewModelScope.launch {
            favouritesRepo.insertArticleToFavourites(article)
        }
    }

    fun deleteFromFavourites(article: Article) {
        viewModelScope.launch {
            favouritesRepo.deleteArticleFromFavourites(article)

        }
    }


}