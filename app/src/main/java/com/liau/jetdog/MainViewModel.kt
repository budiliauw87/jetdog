package com.liau.jetdog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liau.jetgithub.core.data.DogRepository
import com.liau.jetgithub.core.data.local.entity.DogEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


/**
 * Created by Budiliauw87 on 2023-10-29.
 * budiliauw87.github.io
 * Budiliauw87@gmail.com
 */
class MainViewModel(private val repository: DogRepository) : ViewModel() {
    val uiState: StateFlow<MainUiState> = repository.getDogBreed().map {
        MainUiState.Success(it)
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainUiState.Loading,
        started = SharingStarted.WhileSubscribed(5_000),
    )
}

sealed interface MainUiState {
    object Loading : MainUiState
    data class Success(val entity: DogEntity) : MainUiState
}
