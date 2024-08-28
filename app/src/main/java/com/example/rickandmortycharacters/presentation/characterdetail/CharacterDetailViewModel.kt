package com.example.rickandmortycharacters.presentation.characterdetail

import androidx.lifecycle.ViewModel
import com.example.rickandmortycharacters.data.repository.CharacterRepository
import com.example.rickandmortycharacters.data.responses.Character
import com.example.rickandmortycharacters.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {
    suspend fun getCharacterDetail(characterIDD: Int): Resource<Character> {
        return characterRepository.getCharacterDetail(characterIDD)
    }
}