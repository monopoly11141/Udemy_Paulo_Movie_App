package com.example.udemy_paulo_movie_app.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.transform.CircleCropTransformation
import com.example.udemy_paulo_movie_app.model.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieItem(
    movie: Movie,
    onItemClicked: (String) -> Unit = {}
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(125.dp)
            .clickable {
                onItemClicked(movie.id)
            },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 4.dp
            ) {
//                Icon(
//                    imageVector = Icons.Default.AccountBox,
//                    contentDescription = "Movie Image"
//                )
                Image(
                    painter = rememberAsyncImagePainter(
                        model = movie.images[0],
                        imageLoader = ImageLoader.Builder(LocalContext.current)
                            .crossfade(true)
                            .build(),
                    ),
                    contentDescription = "Movie Image",
                    modifier = Modifier
                        .clip(CircleShape)
                )
            }

            Column(
                modifier = Modifier
                    .padding(4.dp)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "Director ${movie.director}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Released ${movie.year}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }
    }
}