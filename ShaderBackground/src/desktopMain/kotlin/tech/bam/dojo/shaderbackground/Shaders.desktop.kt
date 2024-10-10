package tech.bam.dojo.shaderbackground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import org.jetbrains.skia.ImageFilter
import org.jetbrains.skia.RuntimeEffect
import org.jetbrains.skia.RuntimeShaderBuilder

fun Modifier.shaderBrush(
    shader: String,
    speed: Float = 1f,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)?,
): Modifier =
    this then
        composed {
            val runtimeShaderBuilder =
                remember {
                    RuntimeShaderBuilder(
                        effect = RuntimeEffect.makeForShader(shader),
                    )
                }
            val shaderUniformProvider =
                remember { ShaderUniformProviderImpl(runtimeShaderBuilder) }
            val brush =
                ShaderBrush(
                    runtimeShaderBuilder
                        .apply {
                            uniformsBlock?.invoke(shaderUniformProvider)
                        }.makeShader(),
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

actual fun Modifier.shader(
    shader: String,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)?,
): Modifier =
    this then
        composed {
            val runtimeShaderBuilder =
                remember {
                    RuntimeShaderBuilder(
                        effect = RuntimeEffect.makeForShader(shader),
                    )
                }
            val shaderUniformProvider =
                remember { ShaderUniformProviderImpl(runtimeShaderBuilder) }
            graphicsLayer {
                clip = true
                renderEffect =
                    ImageFilter
                        .makeShader(
                            shader =
                                runtimeShaderBuilder
                                    .apply {
                                        uniformsBlock?.invoke(shaderUniformProvider)
                                        shaderUniformProvider.updateResolution(size)
                                    }.makeShader(),
                            crop = null,
                        ).asComposeRenderEffect()
            }
        }

actual fun Modifier.runtimeShader(
    shader: String,
    uniformName: String,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)?,
): Modifier =
    this then
        composed {
            val runtimeShaderBuilder =
                remember {
                    RuntimeShaderBuilder(
                        effect = RuntimeEffect.makeForShader(shader),
                    )
                }
            val shaderUniformProvider =
                remember { ShaderUniformProviderImpl(runtimeShaderBuilder) }
            graphicsLayer {
                clip = true
                renderEffect =
                    ImageFilter
                        .makeRuntimeShader(
                            runtimeShaderBuilder =
                                runtimeShaderBuilder.apply {
                                    uniformsBlock?.invoke(shaderUniformProvider)
                                    shaderUniformProvider.updateResolution(size)
                                },
                            shaderName = uniformName,
                            input = null,
                        ).asComposeRenderEffect()
            }
        }

private class ShaderUniformProviderImpl(
    private val runtimeShaderBuilder: RuntimeShaderBuilder,
) : ShaderUniformProvider {
    fun updateResolution(size: Size) {
        uniform("iResolution", size.width, size.height)
    }

    override fun uniform(
        name: String,
        value: Int,
    ) {
        runtimeShaderBuilder.uniform(name, value)
    }

    override fun uniform(
        name: String,
        value: Float,
    ) {
        runtimeShaderBuilder.uniform(name, value)
    }

    override fun uniform(
        name: String,
        value1: Float,
        value2: Float,
    ) {
        runtimeShaderBuilder.uniform(name, value1, value2)
    }
}
