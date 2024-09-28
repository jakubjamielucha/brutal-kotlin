package com.jakub.brutal.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakub.brutal.core.presentation.utils.receiveAsFlowOn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

abstract class BaseViewModel<State, Event>(
    defaultState: State
) : ViewModel(), KoinComponent {

    protected val ioDispatcher by inject<CoroutineDispatcher>(named("io"))
    protected val _uiState = MutableStateFlow(defaultState)
    val uiState = _uiState
            .onStart { onUiStateSubscribed() }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(DEFAULT_SUBSCRIBED_TIME),
                defaultState
            )

    private val _uiEvent = Channel<Event>()
    val uiEvent = _uiEvent
            .receiveAsFlowOn(ioDispatcher)
            .onEach(::onEventSideEffect)

    protected open fun onUiStateSubscribed() = Unit

    open fun onEvent(event: Event) {
        viewModelScope.launch(ioDispatcher) { _uiEvent.send(event) }
    }

    open fun onEventSideEffect(event: Event) = Unit

    companion object {
        private const val DEFAULT_SUBSCRIBED_TIME = 5_000L
    }
}
