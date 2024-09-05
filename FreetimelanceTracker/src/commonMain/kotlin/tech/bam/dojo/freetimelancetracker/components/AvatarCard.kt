package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dojocompose.freetimelancetracker.generated.resources.avatar_age_fake_value
import dojocompose.freetimelancetracker.generated.resources.avatar_name_fake_value
import dojocompose.freetimelancetracker.generated.resources.avatar_title_fake_value
import tech.bam.dojo.freetimelancetracker.text.FreetimelanceTrackerStrings
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Composable
fun AvatarCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(FreetimelanceTrackerColors.white),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = FreetimelanceTrackerStrings.avatar_name_fake_value)
        Text(text = FreetimelanceTrackerStrings.avatar_title_fake_value)
        Text(text = FreetimelanceTrackerStrings.avatar_age_fake_value)
    }
}
