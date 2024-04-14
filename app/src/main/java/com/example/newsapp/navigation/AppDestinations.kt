package com.example.newsapp.navigation

interface AppDestinations {
    val route: String
}

object Home : AppDestinations {
    override val route = "home"
}

object Favorite : AppDestinations {
    override val route = "favorite"
}

