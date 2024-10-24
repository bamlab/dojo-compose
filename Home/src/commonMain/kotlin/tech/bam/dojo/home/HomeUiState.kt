package tech.bam.dojo.home

import kotlin.time.Duration

data class HomeUiState(
    val time: Duration,
    val chronoState: ChronoState
) {
    companion object {
        fun empty(): HomeUiState = HomeUiState(Duration.ZERO, ChronoState.STOPPED)
    }
}
