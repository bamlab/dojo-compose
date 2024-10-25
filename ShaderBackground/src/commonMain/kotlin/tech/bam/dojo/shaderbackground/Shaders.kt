package tech.bam.dojo.shaderbackground

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

expect fun Modifier.shaderBrush(
    shader: String,
    speed: Float = 1f,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)? = null
): Modifier

expect fun Modifier.shader(
    shader: String,
    uniformsBlock: (ShaderUniformProvider.() -> Unit)? = null
): Modifier

expect fun Modifier.runtimeShader(
    shader: String,
    uniformName: String = "content",
    uniformsBlock: (ShaderUniformProvider.() -> Unit)? = null
): Modifier

interface ShaderUniformProvider {
    fun uniform(
        name: String,
        value: Int
    )

    fun uniform(
        name: String,
        value: Float
    )

    fun uniform(
        name: String,
        value1: Float,
        value2: Float
    )

    fun uniform(
        name: String,
        color: Color
    )
}
