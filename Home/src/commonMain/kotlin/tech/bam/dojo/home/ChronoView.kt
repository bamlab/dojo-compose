package tech.bam.dojo.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Composable
internal fun ChronoView(minutes: Long, seconds: Int, nanoseconds: Int) {
    Box(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .size(300.dp)
            .clip(CircleShape)
            .background(FreetimelanceTrackerColors.purple.copy(alpha = 0.1f)),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.matchParentSize(),
            color = FreetimelanceTrackerColors.yellow,
            strokeWidth = 16.dp,
            backgroundColor = FreetimelanceTrackerColors.purple.copy(alpha = 0.2f),
            strokeCap = StrokeCap.Round
        )
        Text(
            text = "${minutes.toTime()}:${seconds.toTime()}:${nanoseconds.toTime()}",
            color = FreetimelanceTrackerColors.white,
            style = MaterialTheme.typography.h2
        )
    }
}

private fun Long.toTime(): String = if (this < 10) "0$this" else this.toString().take(2)
private fun Int.toTime() = this.toLong().toTime()
