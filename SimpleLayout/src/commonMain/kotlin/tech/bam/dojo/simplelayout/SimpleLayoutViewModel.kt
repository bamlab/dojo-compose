package tech.bam.dojo.simplelayout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import tech.bam.dojo.freetimelancetracker.repository.PremiumRepository

class SimpleLayoutViewModel(
    private val repository: PremiumRepository = PremiumRepository()
) : ViewModel() {
    private val isPremium: StateFlow<Boolean> = repository.isPremium

    val uiState: StateFlow<SimpleLayoutUiState> = isPremium.map {
        SimpleLayoutUiState(
            isPremium = it
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SimpleLayoutUiState.empty()
    )

    fun onPremiumButtonClick() {
        repository.setPremium()
    }
}
