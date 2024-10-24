package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerDimens

@Composable
fun FreelanceIconButton(
    onClick: () -> Unit,
    modifier: Modifier,
    icon: ImageVector,
    backgroundColor: Color,
    iconColor: Color,
) {
    val shape = RoundedCornerShape(16.dp)
    IconButton(
        onClick = onClick,
        modifier =
            modifier
                .clip(shape)
                .background(backgroundColor)
                .border(1.dp, FreetimelanceTrackerColors.white.copy(alpha = .1f), shape),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(FreetimelanceTrackerDimens.iconSize),
        )
    }
}
