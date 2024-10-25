package tech.bam.dojo.shaderbackground.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tech.bam.dojo.shaderbackground.FreeTimeLanceTrackerBackground
import tech.bam.dojo.shaderbackground.GradientShaderNoColorParameterString
import tech.bam.dojo.shaderbackground.shader

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun GradientShaderBrush(modifier: Modifier = Modifier) {
    FreeTimeLanceTrackerBackground(modifier)
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
private fun Modifier.gradientShader(): Modifier =
    this then
        shader(
            shader = GradientShaderNoColorParameterString,
            uniformsBlock = {
                uniform("iTime", 0f)
            }
        )
