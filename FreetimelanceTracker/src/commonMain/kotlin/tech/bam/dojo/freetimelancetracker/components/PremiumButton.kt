package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.bam.dojo.freetimelancetracker.text.FreetimelanceTrackerStrings
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Composable
fun PremiumButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        onClick = onClick,
        colors =
            ButtonDefaults.buttonColors(
                backgroundColor = FreetimelanceTrackerColors.yellow,
                contentColor = FreetimelanceTrackerColors.purpleDark,
            ),
    ) {
        Text(
            text = FreetimelanceTrackerStrings.premium_button_label,
        )
    }
}
