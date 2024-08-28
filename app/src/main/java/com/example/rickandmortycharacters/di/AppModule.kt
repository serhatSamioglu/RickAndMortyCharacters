package com.example.rickandmortycharacters.di

import com.example.rickandmortycharacters.data.repository.CharacterRepository
import com.example.rickandmortycharacters.data.repository.CharacterRepositoryImpl
import com.example.rickandmortycharacters.data.responses.CharacterAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    const val BASE_URL = "https://rickandmortyapi.com/api/"

    @Provides
    @Singleton
    fun provideCharacterApi(): CharacterAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharacterAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(characterAPI: CharacterAPI): CharacterRepository {
        return CharacterRepositoryImpl(characterAPI)
    }
}