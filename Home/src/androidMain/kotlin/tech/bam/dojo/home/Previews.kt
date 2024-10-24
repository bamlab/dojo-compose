package tech.bam.dojo.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Pause
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.RestartAlt
import androidx.compose.material.icons.outlined.StopCircle
import androidx.compose.material.icons.sharp.Pause
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.bam.dojo.freetimelancetracker.components.FreelanceIconButton
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Preview
@Composable
fun FreelanceIconButtonPreview() =
    MaterialTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            FreelanceIconButton(
                onClick = {},
                modifier = Modifier.size(72.dp),
                icon = Icons.Outlined.RestartAlt,
                backgroundColor = FreetimelanceTrackerColors.purple.copy(alpha = .6f),
                iconColor = FreetimelanceTrackerColors.white,
            )
            FreelanceIconButton(
                onClick = {},
                modifier = Modifier.size(92.dp),
                icon = Icons.Outlined.Pause,
                backgroundColor = FreetimelanceTrackerColors.yellow,
                iconColor = FreetimelanceTrackerColors.purpleDark,
            )
            FreelanceIconButton(
                onClick = {},
                modifier = Modifier.size(72.dp),
                icon = Icons.Outlined.StopCircle,
                backgroundColor = FreetimelanceTrackerColors.purple.copy(alpha = .6f),
                iconColor = FreetimelanceTrackerColors.white,
            )
        }
        FreelanceIconButton(
            onClick = {},
            modifier = Modifier.size(92.dp),
            icon = Icons.Outlined.PlayArrow,
            backgroundColor = FreetimelanceTrackerColors.purpleDark,
            iconColor = FreetimelanceTrackerColors.white,
        )
    }

@Preview
@Composable
fun HomePreview() = HomeView()
