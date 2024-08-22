package tech.bam.dojo.simplelayout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import tech.bam.dojo.freetimelancetracker.components.AvatarCard

class SimpleLayoutScreen : Screen {
    override val key = "Simple Layout"

    @Composable
    override fun Content() {
        SimpleLayoutView()
    }
}

@Composable
fun SimpleLayoutView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        AvatarCard()
    }
}
