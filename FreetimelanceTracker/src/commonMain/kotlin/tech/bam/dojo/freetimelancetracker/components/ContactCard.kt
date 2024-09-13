package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import tech.bam.dojo.freetimelancetracker.text.FreetimelanceTrackerStrings
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerDimens

@Composable
fun ContactCard(modifier: Modifier = Modifier, isInEditionMode: Boolean, onEditButtonClick: () -> Unit) {
    Card(
        modifier = modifier,
        backgroundColor = FreetimelanceTrackerColors.white.copy(alpha = 0.2f),
        contentColor = FreetimelanceTrackerColors.purpleDark,
        shape = FreetimelanceTrackerDimens.roundedShape,
        elevation = 0.dp,
        border = BorderStroke(1.dp, FreetimelanceTrackerColors.white.copy(alpha = 0.4f))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = FreetimelanceTrackerStrings.contact_label,
                    style = MaterialTheme.typography.h4,
                    color = FreetimelanceTrackerColors.white
                )
                IconButton(
                    onClick = onEditButtonClick
                ) {
                    Icon(
                        imageVector = if (!isInEditionMode) Icons.Default.Edit else Icons.Default.CheckCircle,
                        contentDescription = "Contact",
                        tint = FreetimelanceTrackerColors.white,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            ContactCardLine(Icons.Default.Link, FreetimelanceTrackerStrings.contact_website_label, FreetimelanceTrackerStrings.contact_website_fake_value)
            ContactCardLine(
                Icons.Default.Email,
                FreetimelanceTrackerStrings.contact_email_label,
                FreetimelanceTrackerStrings.contact_email_fake_value
            )
            ContactCardLine(
                Icons.Default.Phone,
                FreetimelanceTrackerStrings.contact_phone_label,
                FreetimelanceTrackerStrings.contact_phone_fake_value
            )
            Text(
                text = FreetimelanceTrackerStrings.contact_membership_duration_fake_value,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Composable
private fun ContactCardLine(
    icon: ImageVector,
    label: String,
    value: String,
    isEditable: Boolean = false
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(16.dp)
            )
            Text(
                text = label,
                modifier = Modifier.padding(horizontal = 8.dp),
                style = MaterialTheme.typography.body2
            )
        }
        Text(
            text = value,
            color = FreetimelanceTrackerColors.white,
            style = MaterialTheme.typography.body1
        )
    }
}
