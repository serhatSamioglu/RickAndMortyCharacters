package com.example.rickandmortycharacters.presentation.characterlist

import com.example.rickandmortycharacters.presentation.data.repository.MockCharacterRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CharacterListViewModelTest {
    private lateinit var characterListViewModel: CharacterListViewModel
    private lateinit var mockCharacterRepository: MockCharacterRepository

    @Before
    fun setUp() {
        mockCharacterRepository = MockCharacterRepository()
        characterListViewModel = CharacterListViewModel(mockCharacterRepository)
    }

    @Test
    fun `get character list, list is not empty`() = runBlocking {
        characterListViewModel.getAllCharacters()
        assertThat(characterListViewModel.characterList.value.isNotEmpty()).isTrue()
    }

    @Test
    fun `error occurred while getting character list, error is not empty`() = runBlocking {
        mockCharacterRepository.isSuccess = false
        characterListViewModel.getAllCharacters()
        assertThat(characterListViewModel.errorMessage).isNotNull()
    }
}