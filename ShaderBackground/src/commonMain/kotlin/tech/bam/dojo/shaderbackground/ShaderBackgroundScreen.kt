package tech.bam.dojo.shaderbackground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen

class ShaderBackgroundScreen : Screen {
    override val key = "Shader Background"

    @Composable
    override fun Content() {
        ShaderBackgroundView()
    }
}

@Composable
fun ShaderBackgroundView() {
    PlatformShaderView()
}
