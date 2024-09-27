package tech.bam.dojo.shaderbackground

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Preview
@Composable
fun ShaderBackgroundPreview() {
    PlatformShaderView()
}
