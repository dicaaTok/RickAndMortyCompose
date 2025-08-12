package com.dica.rickandmortycompose.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dica.rickandmortycompose.ui.navgation.Navigation
import com.dica.rickandmortycompose.ui.theme.RickAndMortyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyComposeTheme {
              Navigation()
            }
        }
    }
}
