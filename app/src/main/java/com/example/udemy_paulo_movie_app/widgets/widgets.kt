package com.example.udemy_paulo_movie_app.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import com.example.udemy_paulo_movie_app.model.Movie
import com.example.udemy_paulo_movie_app.model.getMovies

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MovieItem(
    movie: Movie = getMovies()[0],
    onItemClicked: (String) -> Unit = {}
) {
    var isExpandedStateValue by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
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

                AnimatedVisibility(visible = isExpandedStateValue) {
                    Column(

                    ) {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 14.sp
                                    ),
                                ) {
                                    append("Plot : ")
                                }

                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Light
                                    ),
                                ) {
                                    append(movie.plot)
                                }
                            },
                            modifier = Modifier
                                .padding(6.dp)
                        )

                        Divider(
                            modifier = Modifier
                                .padding(3.dp)
                        )

                        Text(
                            text = "Director : ${movie.director}",
                            style = MaterialTheme.typography.bodySmall
                        )

                        Text(
                            text = "Actors : ${movie.actors}",
                            style = MaterialTheme.typography.bodySmall
                        )

                        Text(
                            text = "Rating : ${movie.rating}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }

                Icon(
                    imageVector = if (isExpandedStateValue) {
                        Icons.Filled.KeyboardArrowUp
                    } else {
                        Icons.Filled.KeyboardArrowDown
                    },
                    contentDescription = "Down Arrow",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            isExpandedStateValue = !isExpandedStateValue
                        },
                    tint = Color.DarkGray
                )
            }

        }


    }
}