package tech.bam.dojo.home

data class HomeEvents(
    val onPlayClick: () -> Unit,
    val onPauseClick: () -> Unit,
    val onStopClick: () -> Unit,
    val onResetClick: () -> Unit
) {

    companion object {
        fun previewDefault(): HomeEvents = HomeEvents({}, {}, {}, {})
    }
}
