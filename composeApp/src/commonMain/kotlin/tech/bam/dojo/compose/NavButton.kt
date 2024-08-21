package tech.bam.dojo.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator

@Composable
fun NavButton(
    screen: Screen,
    navigator: Navigator,
) {
    Button(
        onClick = {
            navigator.push(screen)
        },
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
    ) {
        Text(text = screen.key.replace('_', ' ').lowercase(), style = MaterialTheme.typography.h6)
    }
}
