package tech.bam.dojo.shaderbackground

import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import org.jetbrains.skia.ImageFilter
import org.jetbrains.skia.RuntimeEffect
import org.jetbrains.skia.RuntimeShaderBuilder

actual fun Modifier.shaderBrush(
    shader: String,
    speed: Float,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)?
): Modifier =
    this then
        composed {
            val runtimeShaderBuilder =
                remember {
                    RuntimeShaderBuilder(
                        effect = RuntimeEffect.makeForShader(shader)
                    )
                }
            val shaderUniformProvider =
                remember { ShaderUniformProviderImpl(runtimeShaderBuilder) }
            val time: Float by produceDrawLoopCounter(speed)
            this then
                drawWithCache {
                    val brush = ShaderBrush(
                        runtimeShaderBuilder
                            .apply {
                                uniformsBlock?.invoke(shaderUniformProvider)
                                shaderUniformProvider.updateResolution(size)
                                shaderUniformProvider.uniform("iTime", time)
                            }.makeShader()
                    )
                    onDrawBehind {
                        drawRect(brush = brush)
                    }
                }
        }

actual fun Modifier.shader(
    shader: String,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)?
): Modifier =
    this then
        composed {
            val runtimeShaderBuilder =
                remember {
                    RuntimeShaderBuilder(
                        effect = RuntimeEffect.makeForShader(shader)
                    )
                }
            val shaderUniformProvider =
                remember { ShaderUniformProviderImpl(runtimeShaderBuilder) }
            val time: Float by produceDrawLoopCounter(1f)
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
                                    shaderUniformProvider.uniform("iTime", time)
                                }.makeShader(),
                            crop = null
                        ).asComposeRenderEffect()
            }
        }

actual fun Modifier.runtimeShader(
    shader: String,
    uniformName: String,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)?
): Modifier =
    this then
        composed {
            val runtimeShaderBuilder =
                remember {
                    RuntimeShaderBuilder(
                        effect = RuntimeEffect.makeForShader(shader)
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
                            input = null
                        ).asComposeRenderEffect()
            }
        }

private class ShaderUniformProviderImpl(
    private val runtimeShaderBuilder: RuntimeShaderBuilder
) : ShaderUniformProvider {
    fun updateResolution(size: Size) {
        uniform("iResolution", size.width, size.height)
    }

    override fun uniform(
        name: String,
        value: Int
    ) {
        runtimeShaderBuilder.uniform(name, value)
    }

    override fun uniform(
        name: String,
        value: Float
    ) {
        runtimeShaderBuilder.uniform(name, value)
    }

    override fun uniform(
        name: String,
        value1: Float,
        value2: Float
    ) {
        runtimeShaderBuilder.uniform(name, value1, value2)
    }

    override fun uniform(name: String, color: Color) {
        runtimeShaderBuilder.uniform(name, color.red, color.green, color.blue, color.alpha)
    }
}
