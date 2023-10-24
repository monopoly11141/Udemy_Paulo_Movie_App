package com.example.udemy_paulo_movie_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.udemy_paulo_movie_app.screens.detail.DetailScreen
import com.example.udemy_paulo_movie_app.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(MovieScreens.DetailScreen.name) {
            DetailScreen(navController = navController)
        }
    }
}