package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Composable
fun ContactCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(FreetimelanceTrackerColors.white),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Contact Fake Card",
            color = FreetimelanceTrackerColors.purpleDark,
        )
    }
}
