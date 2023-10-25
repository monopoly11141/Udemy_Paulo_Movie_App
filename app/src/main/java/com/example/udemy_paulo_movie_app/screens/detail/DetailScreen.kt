package com.example.udemy_paulo_movie_app.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.udemy_paulo_movie_app.model.Movie
import com.example.udemy_paulo_movie_app.model.getMovies
import com.example.udemy_paulo_movie_app.widgets.MovieItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun DetailScreen(
    navController: NavController,
    movieId: String?
) {

    val movie = getMovies().first { it.id == movieId }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text("Movie")
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        }
    ) {
        Row(
            modifier = Modifier
                .padding(it),
            horizontalArrangement = Arrangement.Start,

            ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow back",
                modifier = Modifier
                    .clickable {
                        navController.popBackStack()
                    }
            )


        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MovieItem(movie = movie)

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Divider()

        Text("Movie Images")

        HorizontalScrollableMovieImageView(movie)
    }

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HorizontalScrollableMovieImageView(movie: Movie) {
    LazyRow {
        items(items = movie.images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = image),
                    contentDescription = "Movie Poster"
                )
            }
        }
    }
}