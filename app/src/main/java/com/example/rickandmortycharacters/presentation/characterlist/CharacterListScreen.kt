package com.example.rickandmortycharacters.presentation.characterlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CharacterListScreen(
    navController: NavController,
    viewModel: CharacterListViewModel = hiltViewModel()
) {
    val characterList by remember {viewModel.characterList}
    val errorMessage by remember {viewModel.errorMessage}

    errorMessage?.let {
        Text(text = it)
    } ?: run {
        LazyColumn(modifier = Modifier.fillMaxSize().padding(vertical = 64.dp)) {
            items(characterList) {
                CharacterListItem(it, navController)
            }
        }
    }
}