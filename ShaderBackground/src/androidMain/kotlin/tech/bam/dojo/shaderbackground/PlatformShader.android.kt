package tech.bam.dojo.shaderbackground

import android.graphics.RenderEffect
import android.graphics.RuntimeShader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
actual fun PlatformShaderView() {
    Highlight()
}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
val HighlightEffect =
    RuntimeShader(
        """
uniform shader inputTexture; // Input texture. Its name has to match the one declared during creation of render effect.
uniform vec2 rectPosition; // Origin coordinate of the excluded rectangle
uniform vec2 rectSize; // Size of excluded rectangle
uniform float grayscaleIntensity;
    
vec4 main(vec2 fragCoord){
    // Get the color from the original input texture
    vec4 originalColor = inputTexture.eval(fragCoord);

    // Check if the current fragment is inside the defined rectangle
    if (fragCoord.x >= rectPosition.x &&
        fragCoord.x <= rectPosition.x + rectSize.x &&
        fragCoord.y >= rectPosition.y &&
        fragCoord.y <= rectPosition.y + rectSize.y)
    {
        // If inside the rectangle, use the original color
        return originalColor;
    }
    else
    {
        // If outside the rectangle, convert to grayscale
        float gray = dot(originalColor.rgb, vec3(0.299, 0.587, 0.114));
        vec3 grayscaleColor = mix(originalColor.rgb, vec3(gray), grayscaleIntensity);
        return vec4(vec3(grayscaleColor), originalColor.a);
    }
}
""",
    )
