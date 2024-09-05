package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dojocompose.freetimelancetracker.generated.resources.contact_email_fake_value
import dojocompose.freetimelancetracker.generated.resources.contact_email_label
import dojocompose.freetimelancetracker.generated.resources.contact_label
import dojocompose.freetimelancetracker.generated.resources.contact_membership_duration_fake_value
import dojocompose.freetimelancetracker.generated.resources.contact_phone_fake_value
import dojocompose.freetimelancetracker.generated.resources.contact_phone_label
import dojocompose.freetimelancetracker.generated.resources.contact_website_fake_value
import dojocompose.freetimelancetracker.generated.resources.contact_website_label
import tech.bam.dojo.freetimelancetracker.text.FreetimelanceTrackerStrings
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Composable
fun ContactCard(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        backgroundColor = FreetimelanceTrackerColors.white.copy(alpha = 0.2f),
        contentColor = FreetimelanceTrackerColors.white,
    ) {
        Column(
            modifier =
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
        ) {
            Icon(
                imageVector = Icons.Default.Person, // TODO change icon
                contentDescription = "Contact",
                modifier = Modifier.size(24.dp),
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
