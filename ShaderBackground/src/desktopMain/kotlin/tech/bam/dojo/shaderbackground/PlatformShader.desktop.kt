package tech.bam.dojo.shaderbackground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerColors

@Composable
actual fun PlatformShaderView() {
    FreeTimeLanceTrackerBackground(Modifier.fillMaxSize())
}

@Composable
fun GradientShaderBrush(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().shaderBrush(GradientShaderNoColorParameterString) {})
}

@Composable
fun GradientShaderBrushColor(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .shaderBrush(GradientShader) {
                uniform("color1a", FreetimelanceTrackerColors.purple)
                uniform("color1b", FreetimelanceTrackerColors.yellow)
                uniform("color2a", FreetimelanceTrackerColors.purple)
                uniform("color2b", FreetimelanceTrackerColors.purple)
            }
    )
}

@Composable
fun GradientRenderEffect(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().shader(GradientShaderNoColorParameterString) {})
}
