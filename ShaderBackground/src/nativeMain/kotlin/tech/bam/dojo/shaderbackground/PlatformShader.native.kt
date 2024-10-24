package tech.bam.dojo.shaderbackground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun PlatformShaderView() {
    Box(modifier = Modifier.fillMaxSize().shaderBrush(GradientShaderNoColorParameterString) {})
}
