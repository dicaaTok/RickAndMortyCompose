package com.dica.rickandmortycompose.ui.screens.locations

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
fun LocationsScreen(
    navController: NavController,
    viewModel: LocationViewModel = koinViewModel()
) {
    val locations = viewModel.locationsStateFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchLocations()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(locations.value) { location ->
                Text(
                    text = location.id.toString()+ " " + location.name.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            location.id?.let { id ->
                                navController.navigate("location_detail/$id")
                            }
                        }
                        .padding(26.dp)
                        .wrapContentHeight()
                        .background(
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        )
                )
            }
        }
    }
}
