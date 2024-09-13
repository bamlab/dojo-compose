package tech.bam.dojo.freetimelancetracker.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PremiumRepository {

    private val _isPremium = MutableStateFlow(false)
    val isPremium: StateFlow<Boolean> = _isPremium

    private fun updateIsPremium(newState: Boolean) {
        _isPremium.value = newState
    }

    fun setPremium() {
        updateIsPremium(true)
    }

    fun removePremium() {
        updateIsPremium(false)
    }
}
