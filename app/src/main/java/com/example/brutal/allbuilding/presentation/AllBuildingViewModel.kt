package com.example.brutal.allbuilding.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brutal.allbuilding.domain.usecases.GetBuildingsUseCase
import com.example.brutal.allbuilding.presentation.states.AllBuildingState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.handleCoroutineException
import kotlinx.coroutines.launch

class AllBuildingViewModel(
    private val useCase: GetBuildingsUseCase,
    private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _uiState = MutableStateFlow(AllBuildingState())
    val uiState get() = _uiState.asStateFlow()

    fun getAllBuilding() {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch(dispatcher) {
            useCase.runCatching {
                invoke()
            }.onSuccess { buildings ->
                _uiState.update { it.copy(isLoading = false, buildings = buildings) }
            }.onFailure { exception ->
                if (exception is CancellationException) throw exception
                Log.e("getAllBuilding", "error: $exception", )
                _uiState.update { it.copy(isLoading = false, errorMessage = exception.message) }
            }
        }
    }
}
