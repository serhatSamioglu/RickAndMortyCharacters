package com.example.rickandmortycharacters.presentation.characterdetail

import com.example.rickandmortycharacters.data.responses.Character
import com.example.rickandmortycharacters.presentation.data.repository.MockCharacterRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CharacterDetailViewModelTest {
    private lateinit var characterDetailViewModel: CharacterDetailViewModel
    private lateinit var mockCharacterRepository: MockCharacterRepository

    @Before
    fun setUp() {
        mockCharacterRepository = MockCharacterRepository()
        characterDetailViewModel = CharacterDetailViewModel(mockCharacterRepository)
    }

    @Test
    fun `get character detail, check first character`() = runBlocking {
        val firstCharacterIndex = 0
        val characterDetail = characterDetailViewModel.getCharacterDetail(firstCharacterIndex)
        Truth.assertThat(characterDetail).isEqualTo(Character(name = "Rick Sanchez"))
    }
}