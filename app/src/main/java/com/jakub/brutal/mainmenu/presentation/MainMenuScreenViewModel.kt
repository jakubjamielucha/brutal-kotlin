package com.jakub.brutal.mainmenu.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakub.brutal.mainmenu.presentation.model.MainMenuEvent
import com.jakub.brutal.mainmenu.presentation.model.MainMenuState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainMenuScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainMenuState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = Channel<MainMenuEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        _uiState.update {
            it.copy(
                menuList = listOf(
                    "All buildings.",
                    "Maps.",
                    "Favorites.",
                    "Shops.",
                    "Contact.",
                )
            )
        }
    }

    fun onEvent(event: MainMenuEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}
