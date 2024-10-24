package tech.bam.dojo.home

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlin.time.Duration

@Preview
@Composable
fun HomePreview() = MaterialTheme {
    HomeView(ChronoState.RUNNING, Duration.ZERO, {}, {}, {}, {})
}
