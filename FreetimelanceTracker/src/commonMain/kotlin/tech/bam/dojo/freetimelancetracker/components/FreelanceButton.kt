package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerDimens

@Composable
fun FreelanceButton(
    onClick: () -> Unit,
    modifier: Modifier,
    icon: ImageVector,
    backgroundColor: Color,
    iconColor: Color
) {
    Button(
        onClick = onClick,
        shape = FreetimelanceTrackerDimens.roundedShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = iconColor
        ),
        border = BorderStroke(
            width = 1.dp,
            color = FreetimelanceTrackerColors.white.copy(alpha = .1f)
        ),
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(FreetimelanceTrackerDimens.iconSize)
        )
    }
}
