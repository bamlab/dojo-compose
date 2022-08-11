package tech.bamlab.dojo.revealanimation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RevealAnimationScreen() {

    var baseModifier = Modifier
        .size(150.dp)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = baseModifier
                .clickable(
                    remember { MutableInteractionSource() }, null
                ) {}

        )
        Text(
            "toto",
            Modifier
                .clickable {}
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RevealAnimationScreenPreview() {
    RevealAnimationScreen()
}
