package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Composable
fun PremiumButton(modifier: Modifier = Modifier) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = FreetimelanceTrackerColors.yellow
            ),
            shape = RoundedCornerShape(
                size = 16.dp
            ),
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(vertical = 20.dp),
            border = BorderStroke(
                1.dp,
                Color.White
            )
        ) {
            Text(
                text = "\uD83D\uDD25 Passer premium \uD83D\uDD25 ",
                color = FreetimelanceTrackerColors.purpleDark,
            )
        }
}
