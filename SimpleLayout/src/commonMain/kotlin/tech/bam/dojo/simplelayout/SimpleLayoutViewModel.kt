package tech.bam.dojo.simplelayout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import tech.bam.dojo.freetimelancetracker.repository.ContactRepository
import tech.bam.dojo.freetimelancetracker.repository.PremiumRepository

class SimpleLayoutViewModel(
    private val premiumRepository: PremiumRepository = PremiumRepository(),
    private val contactRepository: ContactRepository = ContactRepository()
) : ViewModel() {
    private val isPremium: StateFlow<Boolean> = premiumRepository.isPremium
    private val isInEditionMode = MutableStateFlow(false)
    private val contact = contactRepository.contact

    val uiState: StateFlow<SimpleLayoutUiState> = combine(
        isPremium,
        isInEditionMode
    ) { (isPremium, isInEditionMode) ->
        SimpleLayoutUiState(
            isPremium = isPremium,
            isInEditionMode = isInEditionMode
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SimpleLayoutUiState.empty()
    )

    fun onPremiumButtonClick() {
        premiumRepository.setPremium()
    }

    fun onEditButtonClick() {
        isInEditionMode.value = !isInEditionMode.value
    }
}
