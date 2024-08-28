package com.example.rickandmortycharacters.presentation.characterlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.rickandmortycharacters.data.responses.Character

@Composable
fun CharacterListItem(character: Character?, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate(
                    "detail_screen/${character?.id}"
                )
            }
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = character?.image,
                contentDescription = "character image",
                modifier = Modifier.clip(RoundedCornerShape(8.dp))
            )
            Text(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .align(alignment = Alignment.CenterVertically),
                text = character?.name ?: "default name",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}