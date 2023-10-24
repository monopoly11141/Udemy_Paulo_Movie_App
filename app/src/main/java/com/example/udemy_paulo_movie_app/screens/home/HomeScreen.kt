package com.example.udemy_paulo_movie_app.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.udemy_paulo_movie_app.model.Movie
import com.example.udemy_paulo_movie_app.model.getMovies
import com.example.udemy_paulo_movie_app.navigation.MovieScreens
import com.example.udemy_paulo_movie_app.widgets.MovieItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text("Movie")
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Magenta
                )
            )
        }
    ) {
        MainContent(
            navController = navController,
            paddingValues = it
        )
    }
}


@Composable
fun MainContent(
    navController: NavController,
    paddingValues: PaddingValues,
    movieList: List<Movie> = getMovies()
) {
    Surface(
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding()),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            LazyColumn {
                items(
                    items = movieList
                ) {
                    MovieItem(it) { movieItem ->
                        navController.navigate(route = MovieScreens.DetailScreen.name + "/$movieItem")
                    }
                }
            }
        }
    }
}