package tech.bam.dojo.freetimelancetracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.bam.dojo.freetimelancetracker.components.AvatarCard
import tech.bam.dojo.freetimelancetracker.components.ContactCard
import tech.bam.dojo.freetimelancetracker.components.NoiseTexture
import tech.bam.dojo.freetimelancetracker.components.PremiumButton
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerDimens

@Preview
@Composable
internal fun BackgroundPreview() = BackgroundView()

@Preview
@Composable
internal fun CardsPreview() =
    Box(Modifier.fillMaxSize()) {
        BackgroundView()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AvatarCard(Modifier.height(100.dp))
            ContactCard(Modifier.size(100.dp, 200.dp))
            PremiumButton(Modifier.fillMaxWidth())
        }
    }

@Composable
private fun BackgroundView() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier =
                Modifier
                    .background(FreetimelanceTrackerColors.purple)
                    .blur(FreetimelanceTrackerDimens.backgroundBlur)
                    .fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier =
                    Modifier
                        .background(FreetimelanceTrackerColors.yellow)
                        .size(100.dp),
            )
        }
        NoiseTexture()
    }
}
