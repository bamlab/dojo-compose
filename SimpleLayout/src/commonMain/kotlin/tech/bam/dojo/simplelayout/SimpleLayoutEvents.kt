package tech.bam.dojo.simplelayout

data class SimpleLayoutEvents(
    val onPremiumButtonClick: () -> Unit,
    val onEditButtonClick: () -> Unit
) {

    companion object {
        fun previewDefault(): SimpleLayoutEvents = SimpleLayoutEvents({}, {})
    }
}
