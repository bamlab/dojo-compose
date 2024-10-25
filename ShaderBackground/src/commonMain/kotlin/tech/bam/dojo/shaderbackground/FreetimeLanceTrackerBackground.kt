package tech.bam.dojo.shaderbackground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

// TODO: investigate why box works on skia but android need an image
@Composable
fun FreeTimeLanceTrackerBackground(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .freetimeLanceTrackerBackground()
    )
}

fun Modifier.freetimeLanceTrackerBackground(): Modifier = composed {
    this then shaderBrush(GradientShader) {
        uniform("color1a", FreetimelanceTrackerColors.purple)
        uniform("color1b", FreetimelanceTrackerColors.yellow)
        uniform("color2a", FreetimelanceTrackerColors.purple)
        uniform("color2b", FreetimelanceTrackerColors.purple)
    }
        .runtimeShader(
            NoiseGrain,
            "image"
        ) {
            uniform("intensity", 0.15f)
        }
}
