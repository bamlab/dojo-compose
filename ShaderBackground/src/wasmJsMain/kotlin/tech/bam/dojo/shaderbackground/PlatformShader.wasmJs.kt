package tech.bam.dojo.shaderbackground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ShaderBrush
import org.jetbrains.skia.RuntimeEffect
import org.jetbrains.skia.RuntimeShaderBuilder

@Composable
actual fun PlatformShaderView() {
    GradientSketch()
}

@Composable
fun GradientShaderBrush(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().shaderBrush(GradientShaderNoColorParameterString) {})
}

@Composable
fun GradientSketch(modifier: Modifier = Modifier) {
    val runtimeShaderBuilder =
        remember {
            RuntimeShaderBuilder(
                effect = RuntimeEffect.makeForShader(GradientShaderNoColorParameterString),
            )
        }
    val brush =
        remember {
            ShaderBrush(
                runtimeShaderBuilder.makeShader(),
            )
        }
    Box(modifier = modifier.fillMaxSize()) {
        SketchWithCache(
            speed = 1f,
            modifier = Modifier.fillMaxSize(),
        ) { time ->
            runtimeShaderBuilder.uniform(
                "iResolution",
                this.size.width,
                this.size.height,
            )
            runtimeShaderBuilder.uniform("iTime", time)
            onDrawBehind {
                drawRect(brush)
            }
        }
    }
}
