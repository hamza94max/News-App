package com.example.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsapp.ui.favourites.FavouriteScreen
import com.example.newsapp.ui.home.HomeScreen

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Home.route,
        modifier = modifier
    ) {

        composable(route = Home.route) {
            HomeScreen()
        }

        composable(Favorite.route) {
            FavouriteScreen(
                onBackBtnClick = { navHostController.popBackStack() }
            )
        }

    }
}