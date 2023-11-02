package com.liau.jetdog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liau.jetdog.core.data.DogRepository
import com.liau.jetdog.core.data.local.entity.DogEntity
import com.liau.jetdog.state.UiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch


/**
 * Created by Budiliauw87 on 2023-10-29.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */
class MainViewModel(private val repository: DogRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<DogEntity>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<DogEntity>>
        get() = _uiState

    fun getDogBreeds() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            delay(2000)
            _uiState.value = UiState.Error("Something Error");
//            _uiState.value = UiState.Success(repository.getDogBreed().collect())

        }
    }
}

