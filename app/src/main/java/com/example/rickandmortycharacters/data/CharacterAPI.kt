package com.example.rickandmortycharacters.data.responses

import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterAPI {
    @GET("character")
    suspend fun getAllRickAndMortyCharacters() : RickAndMortyResponse

    @GET("character/{characterID}")
    suspend fun getCharacterDetail(
        @Path("characterID") characterID : Int
    ) : Character
}