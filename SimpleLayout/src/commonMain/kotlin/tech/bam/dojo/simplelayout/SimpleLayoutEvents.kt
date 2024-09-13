package tech.bam.dojo.simplelayout

data class SimpleLayoutEvents(val onPremiumButtonClick: () -> Unit) {
    companion object {
        fun previewDefault(): SimpleLayoutEvents = SimpleLayoutEvents({})
    }
}
