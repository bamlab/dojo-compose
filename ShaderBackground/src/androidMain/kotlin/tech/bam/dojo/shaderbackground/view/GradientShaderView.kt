package tech.bam.dojo.shaderbackground.view

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.tooling.preview.Preview
import tech.bam.dojo.shaderbackground.GradientShaderNoColorParameterString
import tech.bam.dojo.shaderbackground.SketchWithCache
import tech.bam.dojo.shaderbackground.shader
import tech.bam.dojo.shaderbackground.shaderBrush
import tech.bam.dojo.shaderbackground.shaders.GradientShader
import tech.bam.dojo.shaderbackground.shaders.GradientShaderNoColorParameter

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun GradientShaderView(modifier: Modifier = Modifier) {
    val brush = remember { ShaderBrush(GradientShader) }
    Box(modifier = modifier.fillMaxSize()) {
        SketchWithCache(
            speed = 1f,
            modifier = Modifier.fillMaxSize(),
        ) { time ->
            GradientShader.setColorUniform(
                "color1a",
                Color.parseColor("#16325B"),
            )
            GradientShader.setColorUniform(
                "color1b",
                Color.parseColor("#227B94"),
            )
            GradientShader.setColorUniform(
                "color2a",
                Color.parseColor("#78B7D0"),
            )
            GradientShader.setColorUniform(
                "color2b",
                Color.parseColor("#FFDC7F"),
            )
            GradientShader.setFloatUniform(
                "iResolution",
                this.size.width,
                this.size.height,
            )
            GradientShader.setFloatUniform("iTime", time)
            onDrawBehind {
                drawRect(brush)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun GradientShaderNoColorParamView(modifier: Modifier = Modifier) {
    val brush = remember { ShaderBrush(GradientShaderNoColorParameter) }
    Box(modifier = modifier.fillMaxSize()) {
        SketchWithCache(
            speed = 1f,
            modifier = Modifier.fillMaxSize(),
        ) { time ->
            GradientShaderNoColorParameter.setFloatUniform(
                "iResolution",
                this.size.width,
                this.size.height,
            )
            GradientShaderNoColorParameter.setFloatUniform("iTime", time)
            onDrawBehind {
                drawRect(brush)
            }
        }
    }
}

// FIXME Not working don't know why
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun GradientShaderModifierView(modifier: Modifier = Modifier) {
    Box(
        modifier =
            modifier
                .fillMaxSize()
                .gradientShader(),
    )
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun GradientShaderBrush(modifier: Modifier = Modifier) {
    Box(
        modifier =
            modifier
                .fillMaxSize()
                .shaderBrush(GradientShaderNoColorParameterString) {},
    )
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
private fun Modifier.gradientShader(): Modifier =
    this then
        shader(
            shader = GradientShaderNoColorParameterString,
            uniformsBlock = {
                uniform("iTime", 0f)
                },
            )

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview
@Composable
fun GradientShaderViewPreview() = GradientShaderView()
