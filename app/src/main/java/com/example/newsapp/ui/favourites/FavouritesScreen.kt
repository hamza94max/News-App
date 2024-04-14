package com.example.newsapp.ui.favourites

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapp.ui.home.components.ArticleList

@Composable
fun FavouriteScreen(
    onBackBtnClick: () -> Unit,
    favouritesViewModel: FavouritesViewModel = hiltViewModel()
) {


    Column(modifier = Modifier.fillMaxSize()) {

        Spacer(modifier = Modifier.height(8.dp))

        val favourites by favouritesViewModel.favouritesFlow.collectAsState(emptyList())

        if (favourites.isEmpty()) {
            Text(
                text = "No favourites found",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        } else {
            ArticleList(
                articles = favourites, onFavoriteClicked = {
                    favouritesViewModel.deleteFromFavourites(it)
                }
            )
        }


    }
}
