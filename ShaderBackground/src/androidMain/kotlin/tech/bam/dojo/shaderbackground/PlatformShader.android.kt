package tech.bam.dojo.shaderbackground

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import tech.bam.dojo.shaderbackground.view.GradientShaderNoColorParamView

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
actual fun PlatformShaderView() {
    GradientShaderNoColorParamView()
}
