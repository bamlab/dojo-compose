package tech.bam.dojo.freetimelancetracker.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import dojocompose.freetimelancetracker.generated.resources.Res
import dojocompose.freetimelancetracker.generated.resources.noise__texture
import org.jetbrains.compose.resources.painterResource
import tech.bam.dojo.freetimelancetracker.theme.FreetimelanceTrackerDimens

@Composable
fun NoiseTexture() {
    if (!LocalInspectionMode.current) { // else it crashes previews
        Image(
            painter = painterResource(Res.drawable.noise__texture),
            contentDescription = "noise texture",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().alpha(FreetimelanceTrackerDimens.noiseOpacity),
        )
    }
}
