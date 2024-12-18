package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.bam.dojo.freetimelancetracker.text.FreetimelanceTrackerStrings
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerDimens

@Composable
fun PremiumButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isPremium: Boolean
) {
    Button(
        modifier = modifier,
        shape = FreetimelanceTrackerDimens.roundedShape,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = FreetimelanceTrackerColors.yellow,
            contentColor = FreetimelanceTrackerColors.purpleDark
        ),
        border = BorderStroke(1.dp, FreetimelanceTrackerColors.white),
        enabled = !isPremium
    ) {
        val buttonText = remember(isPremium) {
            if (isPremium) {
                FreetimelanceTrackerStrings.premium_Repository_button_label_premium
            } else {
                FreetimelanceTrackerStrings.premium_Repository_button_label
            }
        }
        Text(
            text = buttonText
        )
    }
}
