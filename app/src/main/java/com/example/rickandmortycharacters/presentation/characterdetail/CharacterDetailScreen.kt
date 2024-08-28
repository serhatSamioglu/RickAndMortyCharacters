package com.example.rickandmortycharacters.presentation.characterdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.rickandmortycharacters.data.responses.Character
import com.example.rickandmortycharacters.util.Resource

@Composable
fun CharacterDetailScreen(
    characterID: Int?,
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    val characterDetail = produceState<Resource<Character>?>(null) {
        value = viewModel.getCharacterDetail(characterID ?: 0)
    }.value

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        AsyncImage(
            model = characterDetail?.data?.image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = "Name: " + characterDetail?.data?.name,
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "Gender: " + characterDetail?.data?.gender,
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "Species: " + characterDetail?.data?.species,
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = "Status: " + characterDetail?.data?.status,
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}