package com.example.rickandmortycharacters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortycharacters.presentation.characterdetail.CharacterDetailScreen
import com.example.rickandmortycharacters.presentation.characterlist.CharacterListScreen
import com.example.rickandmortycharacters.ui.theme.RickAndMortyCharactersTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RickAndMortyCharactersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "character_list_screen"
                    ) {
                        composable(
                            route = "character_list_screen"
                        ) {
                            CharacterListScreen(navController)
                        }

                        composable(
                            "character_detail_screen/{characterID}",
                            arguments = listOf(
                                navArgument("characterID") {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            val characterID = remember {
                                it.arguments?.getInt("characterID", 0)
                            }
                            CharacterDetailScreen(characterID)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMortyCharactersTheme {
        Greeting("Android")
    }
}