package com.jakub.brutal.mainmenu.presentation

import com.jakub.brutal.core.presentation.BaseViewModel
import com.jakub.brutal.mainmenu.presentation.model.MainMenuEvent
import com.jakub.brutal.mainmenu.presentation.model.MainMenuState
import kotlinx.coroutines.flow.update
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MainMenuScreenViewModel : BaseViewModel<MainMenuState, MainMenuEvent>(MainMenuState()) {

    override fun onUiStateSubscribed() {
        super.onUiStateSubscribed()
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
}
