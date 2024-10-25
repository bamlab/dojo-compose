package tech.bam.dojo.shaderbackground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
actual fun PlatformShaderView() {
    GradientShaderBrush(Modifier.fillMaxSize())
}

@Composable
fun GradientShaderBrush(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().shaderBrush(GradientShaderNoColorParameterString) {})
}

@Composable
fun GradientRenderEffect(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().shader(GradientShaderNoColorParameterString) {})
}
