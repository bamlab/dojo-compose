package tech.bam.dojo.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val time = MutableStateFlow(Duration.ZERO)
    private val chronoState = MutableStateFlow(ChronoState.STOPPED)
    val uiState: StateFlow<HomeUiState> = combine(
        time,
        chronoState
    ) { time, chronoState ->
        HomeUiState(
            time = time,
            chronoState = chronoState
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = HomeUiState.empty()
    )

    fun handleOnPlayClick() {
        chronoState.value = ChronoState.RUNNING
        // Start timer
        viewModelScope.launch {
            while (chronoState.value == ChronoState.RUNNING) {
                delay(10L)
                time.value = time.value.plus(10.milliseconds)
            }
        }
    }

    fun handleOnPauseClick() {
        chronoState.value = ChronoState.PAUSED
    }

    fun handleOnStopClick() {
        chronoState.value = ChronoState.STOPPED
        time.value = Duration.ZERO
    }

    fun handleOnResetClick() {
        time.value = Duration.ZERO
    }
}
