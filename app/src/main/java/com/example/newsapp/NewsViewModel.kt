package com.example.newsapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.models.NewsResponse
import com.example.newsapp.domain.repo.NewsRepo
import com.example.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepo: NewsRepo
) : ViewModel() {

    private val _news = MutableStateFlow<Resource<NewsResponse>>(Resource.Idle)
    val newsFlow: Flow<Resource<NewsResponse>> = _news

    fun getNews(query: String) {
        Log.i("hamzaDATA", "getNews($query) in view model")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _news.emit(
                    Resource.Success(
                        newsRepo.fetchNewsFromRemote(query)
                    )
                )
            } catch (e: Exception) {
                _news.emit(
                    Resource.Error(e)
                )
            }
        }
    }

}