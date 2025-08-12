package com.dica.rickandmortycompose.ui.screens.characters

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
fun CharacterScreen(
    navController: NavController,
    viewModel: CharacterViewModel = koinViewModel()
) {
    val characters = viewModel.characters.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCharacters()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Magenta)

    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(characters.value) { character ->
                Text(
                    text = character.id.toString()+ " " + character.name.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            character.id?.let { id ->
                                navController.navigate("character_detail/$id")
                            }
                        }
                        .padding(16.dp)
                        .background(color = Color.White,
                            shape = RoundedCornerShape(8.dp))
                )
            }
        }
    }
}
