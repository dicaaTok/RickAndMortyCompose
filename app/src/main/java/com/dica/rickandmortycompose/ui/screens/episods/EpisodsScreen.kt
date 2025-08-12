package com.dica.rickandmortycompose.ui.screens.episods

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun EpisodsScreen(
    navController: NavController,
    viewModel: EpisodeViewModel = koinViewModel()
) {
    val episodes = viewModel.episodesStateFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchEpisodes()
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)

    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),

        ) {
            items(episodes.value) { episode ->
                Text(
                    text = episode.id.toString() + " " + episode.name.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            episode.id?.let { id ->
                                navController.navigate("episode_detail/$id")
                                Log.e("EpisodeScreen", "Clicked on character with ID: $id")
                            }
                        }
                        .padding(24.dp)
                        .background(
                            color = Color.Green,
                            shape = RoundedCornerShape(8.dp)
                            )

                )
            }
        }
    }
}