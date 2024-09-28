package com.jakub.brutal.mainmenu.presentation.model

sealed interface MainMenuEvent {
    data object NavigateToAllBuildings: MainMenuEvent
    data object NavigateMap: MainMenuEvent
    data object NavigateFavorites: MainMenuEvent
    data object NavigateShop: MainMenuEvent
    data object NavigateToContact: MainMenuEvent
}
