package tech.bam.dojo.revealanimation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

class RevealAnimationScreen : Screen {
    override val key = "Reveal Animation"

    @Composable
    override fun Content() {
        RevealAnimationView()
    }
}

@Composable
fun RevealAnimationView() {
    var baseModifier =
        Modifier
            .size(150.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier =
                baseModifier
                    .clickable(
                        remember { MutableInteractionSource() },
                        null,
                    ) {},
        )
        Text(
            "toto",
            Modifier
                .clickable {}
                .padding(16.dp),
        )
    }
}

@Composable
fun AnimatedVisibilityScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier =
                Modifier
                    .size(150.dp)
                    .clickable(
                        remember { MutableInteractionSource() },
                        null,
                    ) {},
        )

        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier =
                Modifier
                    .size(150.dp),
        )

        Text(
            "toto",
            Modifier
                .clickable {}
                .padding(16.dp),
        )
    }
}
