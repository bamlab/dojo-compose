package tech.bam.dojo.freetimelancetracker

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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
import tech.bam.dojo.freetimelancetracker.text.FreetimelanceTrackerStrings
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerDimens

@Preview
@Composable
internal fun InDevelopmentPreview() =
    Box {
        BackgroundView()
        Card(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            backgroundColor = FreetimelanceTrackerColors.white.copy(alpha = 0.2f),
            contentColor = FreetimelanceTrackerColors.white
        ) {
            Column(
                modifier =
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Person, // TODO change icon
                    contentDescription = "Contact",
                    modifier = Modifier.size(24.dp)
                )
                Text(text = FreetimelanceTrackerStrings.contact_label)
                Text(text = FreetimelanceTrackerStrings.contact_website_label)
                Text(text = FreetimelanceTrackerStrings.contact_website_fake_value)
                Text(text = FreetimelanceTrackerStrings.contact_email_label)
                Text(text = FreetimelanceTrackerStrings.contact_email_fake_value)
                Text(text = FreetimelanceTrackerStrings.contact_phone_label)
                Text(text = FreetimelanceTrackerStrings.contact_phone_fake_value)
                Text(text = FreetimelanceTrackerStrings.contact_membership_duration_fake_value)
            }
        }
    }

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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AvatarCard(Modifier.height(100.dp))
            ContactCard(Modifier.size(100.dp, 200.dp))
            PremiumButton(Modifier.fillMaxWidth()) {}
        }
    }

@Composable
private fun BackgroundView() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier =
            Modifier
                .background(FreetimelanceTrackerColors.purple)
                .blur(FreetimelanceTrackerDimens.backgroundBlur)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier =
                Modifier
                    .background(FreetimelanceTrackerColors.yellow)
                    .size(100.dp)
            )
        }
        NoiseTexture()
    }
}

@Preview
@Composable
private fun PremiumButtonPreview() = PremiumButton(Modifier.fillMaxWidth()) {}
