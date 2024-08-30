package tech.bam.dojo.simplelayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
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

    @Composable
    override fun Content() {
        SimpleLayoutView()
    }
}

@Composable
fun SimpleLayoutView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(FreetimelanceTrackerColors.purple)
            .padding(
                horizontal = 16.dp
            )
    ) {
        AvatarCard()
        ContactCard()
        PremiumButton()
    }
}
