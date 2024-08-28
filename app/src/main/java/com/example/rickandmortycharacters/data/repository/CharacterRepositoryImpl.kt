package com.example.rickandmortycharacters.data.repository

import com.example.rickandmortycharacters.data.responses.Character
import com.example.rickandmortycharacters.data.responses.CharacterAPI
import com.example.rickandmortycharacters.data.responses.RickAndMortyResponse
import com.example.rickandmortycharacters.util.Resource
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val characterAPI: CharacterAPI
) : CharacterRepository {
    override suspend fun getAllRickAndMortyCharacters() : Resource<RickAndMortyResponse> {
        return try {
            Resource.Success(characterAPI.getAllRickAndMortyCharacters())
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }

    override suspend fun getCharacterDetail(characterID : Int) : Resource<Character> {
        return try {
            Resource.Success(characterAPI.getCharacterDetail(characterID))
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "An unknown error occurred")
        }
    }
}