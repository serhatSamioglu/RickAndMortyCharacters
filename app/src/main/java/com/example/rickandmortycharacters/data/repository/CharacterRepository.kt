package com.example.rickandmortycharacters.data.repository

import com.example.rickandmortycharacters.data.responses.Character
import com.example.rickandmortycharacters.data.responses.RickAndMortyResponse
import com.example.rickandmortycharacters.util.Resource

interface CharacterRepository {
    suspend fun getAllRickAndMortyCharacters() : Resource<RickAndMortyResponse>
    suspend fun getCharacterDetail(characterID : Int) : Resource<Character>
}