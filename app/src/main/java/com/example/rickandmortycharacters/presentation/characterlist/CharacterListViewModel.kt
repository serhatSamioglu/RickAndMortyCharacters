package com.example.rickandmortycharacters.presentation.characterlist

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortycharacters.data.repository.CharacterRepository
import com.example.rickandmortycharacters.data.responses.Character
import com.example.rickandmortycharacters.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    var characterList = mutableStateOf<List<Character?>>(emptyList())
    var errorMessage = mutableStateOf<String?>(null)

    init {
        getAllCharacters()
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            when(val allCharacter = characterRepository.getAllRickAndMortyCharacters()) {
                is Resource.Success -> {
                    characterList.value = allCharacter.data?.results ?: emptyList()
                }
                is Resource.Error -> {
                    errorMessage.value = allCharacter.message
                }
            }
        }
    }
}