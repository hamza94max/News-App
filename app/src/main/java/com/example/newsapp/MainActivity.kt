package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.navigation.AppNavHost
import com.example.newsapp.navigation.BottomNavigationBar
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NewsAppTheme {
                setUpBottomNavigationView()
            }
        }
    }

    @Composable
    private fun setUpBottomNavigationView(
        modifier: Modifier = Modifier
    ) {
        // A surface container using the 'background' color from the theme
        androidx.compose.material3.Surface(
            modifier = modifier.fillMaxSize(),
            color = androidx.compose.material3.MaterialTheme.colorScheme.background
        ) {

            val navHostController = rememberNavController()
            val bottomBarState = rememberSaveable { mutableStateOf(false) }
            val navBackStackEntry by navHostController.currentBackStackEntryAsState()
            when (navBackStackEntry?.destination?.route) {

                else -> bottomBarState.value = true
            }

            Scaffold(
                bottomBar = {
                    if (bottomBarState.value) {
                        BottomNavigationBar(
                            navController = navHostController,
                            bottomBarState = bottomBarState,
                        )
                    }
                }
            ) { paddingValues ->
                AppNavHost(
                    navHostController = navHostController,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }

}