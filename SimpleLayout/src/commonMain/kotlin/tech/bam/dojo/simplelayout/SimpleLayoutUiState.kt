package tech.bam.dojo.simplelayout

data class SimpleLayoutUiState(
    val isPremium: Boolean,
    val isInEditionMode: Boolean
) {
    companion object {
        fun empty(): SimpleLayoutUiState = SimpleLayoutUiState(false, false)
    }
}
