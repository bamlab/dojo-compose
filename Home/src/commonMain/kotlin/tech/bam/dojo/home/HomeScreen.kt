package tech.bam.dojo.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Pause
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.RestartAlt
import androidx.compose.material.icons.outlined.StopCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import kotlin.time.Duration
import tech.bam.dojo.freetimelancetracker.components.FreelanceButton
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

class HomeScreen : Screen {
    override val key = "Home"
    private val vm = HomeViewModel()

    @Composable
    override fun Content() {
        val uiState = vm.uiState.collectAsState().value
        HomeView(
            chrono = uiState.chronoState,
            time = uiState.time,
            onPlayClick = { vm.handleOnPlayClick() },
            onResetClick = { vm.handleOnResetClick() },
            onPauseClick = { vm.handleOnPauseClick() },
            onStopClick = { vm.handleOnStopClick() }
        )
    }
}

@Composable
fun HomeView(
    chrono: ChronoState,
    time: Duration,
    onPlayClick: () -> Unit,
    onResetClick: () -> Unit,
    onPauseClick: () -> Unit,
    onStopClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(FreetimelanceTrackerColors.purpleLight)
    ) {
        Spacer(Modifier.height(24.dp))
        if (chrono == ChronoState.STOPPED) {
            FreelanceButton(
                onClick = onPlayClick,
                modifier = Modifier.size(92.dp),
                icon = Icons.Outlined.PlayArrow,
                backgroundColor = FreetimelanceTrackerColors.purpleDark,
                iconColor = FreetimelanceTrackerColors.white
            )
        } else {
            time.toComponents { minutes, seconds, nanoseconds ->
                Text(
                    text = "${minutes.toTime()}:${seconds.toTime()}:${nanoseconds.toTime()}",
                    color = FreetimelanceTrackerColors.white,
                    style = MaterialTheme.typography.h2
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(32.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FreelanceButton(
                    onClick = onResetClick,
                    modifier = Modifier.size(72.dp),
                    icon = Icons.Outlined.RestartAlt,
                    backgroundColor = FreetimelanceTrackerColors.purple.copy(alpha = .6f),
                    iconColor = FreetimelanceTrackerColors.white
                )
                if (chrono == ChronoState.RUNNING) {
                    FreelanceButton(
                        onClick = onPauseClick,
                        modifier = Modifier.size(92.dp),
                        icon = Icons.Outlined.Pause,
                        backgroundColor = FreetimelanceTrackerColors.yellow,
                        iconColor = FreetimelanceTrackerColors.purpleDark
                    )
                }
                FreelanceButton(
                    onClick = onStopClick,
                    modifier = Modifier.size(72.dp),
                    icon = Icons.Outlined.StopCircle,
                    backgroundColor = FreetimelanceTrackerColors.purple.copy(alpha = .6f),
                    iconColor = FreetimelanceTrackerColors.white
                )
            }
        }
    }
}

private fun Long.toTime(): String = if (this < 10) "0$this" else this.toString().take(2)
private fun Int.toTime() = this.toLong().toTime()
