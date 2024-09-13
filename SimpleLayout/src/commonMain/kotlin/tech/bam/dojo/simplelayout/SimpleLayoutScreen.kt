package tech.bam.dojo.simplelayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import tech.bam.dojo.freetimelancetracker.components.AvatarCard
import tech.bam.dojo.freetimelancetracker.components.ContactCard
import tech.bam.dojo.freetimelancetracker.components.PremiumButton
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

class SimpleLayoutScreen : Screen {
    override val key = "Simple Layout"
    private val viewModel = SimpleLayoutViewModel()

    @Composable
    override fun Content() {
        SimpleLayoutView(
            state = SimpleLayoutUiState.empty(), // TODO plug to VM
            events = SimpleLayoutEvents(
                onPremiumButtonClick = {} // TODO plug to VM
            )
        )
    }
}

@Composable
fun SimpleLayoutView(
    state: SimpleLayoutUiState,
    events: SimpleLayoutEvents
) {
    Column(
        modifier = Modifier
            .background(FreetimelanceTrackerColors.purple)
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        AvatarCard(Modifier.fillMaxWidth())
        ContactCard(Modifier.fillMaxWidth())
        PremiumButton(Modifier.fillMaxWidth().height(62.dp)) { }
    }
}
