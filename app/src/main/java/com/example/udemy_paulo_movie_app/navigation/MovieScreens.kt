package com.example.udemy_paulo_movie_app.navigation

enum class MovieScreens {
    HomeScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens {
            return when (route?.substringBefore("/")) {
                HomeScreen.name -> HomeScreen
                DetailScreen.name -> DetailScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route not found")
            }
        }
    }
}