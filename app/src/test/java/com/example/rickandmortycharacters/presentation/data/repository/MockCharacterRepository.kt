package com.example.rickandmortycharacters.presentation.data.repository

import com.example.rickandmortycharacters.data.repository.CharacterRepository
import com.example.rickandmortycharacters.data.responses.Character
import com.example.rickandmortycharacters.data.responses.RickAndMortyResponse
import com.example.rickandmortycharacters.util.Resource

class MockCharacterRepository : CharacterRepository {

    private val characters = mutableListOf(Character(name = "Rick Sanchez"))
    var isSuccess = true
    val errorMessage = "Error occurred"

    override suspend fun getAllRickAndMortyCharacters(): Resource<RickAndMortyResponse> {
        return if (isSuccess)
            Resource.Success(RickAndMortyResponse(characters))
        else
            Resource.Error(errorMessage)
    }

    override suspend fun getCharacterDetail(characterID: Int): Resource<Character> {
        return if (isSuccess)
            Resource.Success(characters[characterID])
        else
            Resource.Error(errorMessage)
    }
}