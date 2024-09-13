package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dojocompose.freetimelancetracker.generated.resources.avatar_age_fake_value
import dojocompose.freetimelancetracker.generated.resources.avatar_name_fake_value
import dojocompose.freetimelancetracker.generated.resources.avatar_title_fake_value
import tech.bam.dojo.freetimelancetracker.text.FreetimelanceTrackerStrings
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerDimens

@Composable
fun AvatarCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        backgroundColor = FreetimelanceTrackerColors.white.copy(alpha = 0.2f),
        contentColor = FreetimelanceTrackerColors.white,
        shape = FreetimelanceTrackerDimens.roundedShape,
        elevation = 0.dp,
        border = BorderStroke(1.dp, FreetimelanceTrackerColors.white.copy(alpha = 0.4f))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = FreetimelanceTrackerStrings.avatar_name_fake_value, style = MaterialTheme.typography.h4)
            Text(text = FreetimelanceTrackerStrings.avatar_title_fake_value, style = MaterialTheme.typography.subtitle2)
            Text(text = FreetimelanceTrackerStrings.avatar_age_fake_value, style = MaterialTheme.typography.body1)
        }
    }
}
