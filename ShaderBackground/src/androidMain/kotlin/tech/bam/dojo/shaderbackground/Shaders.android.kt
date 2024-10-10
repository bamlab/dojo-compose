package tech.bam.dojo.shaderbackground

import android.graphics.RenderEffect
import android.graphics.RuntimeShader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
fun Modifier.shaderBrush(
    shader: String,
    speed: Float = 1f,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)?,
): Modifier =
    this then
        composed {
            val runtimeShaderBuilder =
                remember {
                    RuntimeShader(shader)
                }
            val shaderUniformProvider =
                remember { ShaderUniformProviderImpl(runtimeShaderBuilder) }
            val brush =
                ShaderBrush(
                    runtimeShaderBuilder
                        .apply {
                            uniformsBlock?.invoke(shaderUniformProvider)
                        },
                )
            val time: Float by produceDrawLoopCounter(speed)
            this then
                drawWithCache {
                    onDrawBehind {
                        shaderUniformProvider.updateResolution(size)
                        shaderUniformProvider.uniform("iTime", time)
                        drawRect(brush = brush)
                    }
                }
        }

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
actual fun Modifier.shader(
    shader: String,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)?,
): Modifier =
    this then
        composed {
            val runtimeShader = remember { RuntimeShader(shader) }
            val shaderUniformProvider = remember { ShaderUniformProviderImpl(runtimeShader) }
            graphicsLayer {
                clip = true
                renderEffect =
                    RenderEffect
                        .createShaderEffect(
                            runtimeShader.apply {
                                uniformsBlock?.invoke(shaderUniformProvider)
                                shaderUniformProvider.updateResolution(size)
                            },
                        ).asComposeRenderEffect()
            }
        }

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
actual fun Modifier.runtimeShader(
    shader: String,
    uniformName: String,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)?,
): Modifier =
    this then
        composed {
            val runtimeShader = remember { RuntimeShader(shader) }
            val shaderUniformProvider = remember { ShaderUniformProviderImpl(runtimeShader) }
            graphicsLayer {
                clip = true
                renderEffect =
                    RenderEffect
                        .createRuntimeShaderEffect(
                            runtimeShader.apply {
                                uniformsBlock?.invoke(shaderUniformProvider)
                                shaderUniformProvider.updateResolution(size)
                            },
                            uniformName,
                        ).asComposeRenderEffect()
            }
        }

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
private class ShaderUniformProviderImpl(
    private val runtimeShader: RuntimeShader,
) : ShaderUniformProvider {
    fun updateResolution(size: Size) {
        uniform("iResolution", size.width, size.height)
    }

    override fun uniform(
        name: String,
        value: Int,
    ) {
        runtimeShader.setIntUniform(name, value)
    }

    override fun uniform(
        name: String,
        value: Float,
    ) {
        runtimeShader.setFloatUniform(name, value)
    }

    override fun uniform(
        name: String,
        value1: Float,
        value2: Float,
    ) {
        runtimeShader.setFloatUniform(name, value1, value2)
    }
}
